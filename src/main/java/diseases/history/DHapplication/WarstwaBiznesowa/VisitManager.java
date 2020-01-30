package diseases.history.DHapplication.WarstwaBiznesowa;

import diseases.history.DHapplication.Pomoc.DTO.*;
import diseases.history.DHapplication.WarstwaIntegracji.VisitRepo;
import diseases.history.DHapplication.Pomoc.Entity.Disease;
import diseases.history.DHapplication.Pomoc.Entity.Doctor;
import diseases.history.DHapplication.Pomoc.Entity.Patient;
import diseases.history.DHapplication.Pomoc.Entity.Visit;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.time.LocalDate;
import java.util.*;

@Service
public class VisitManager {
    private VisitRepo visitRepo;
    private PatientManager patientManager;
    private DoctorManager doctorManager;
    private DiseaseManager diseaseManager;
    private ModelMapper modelMapper = new ModelMapper();


    @Autowired
    public VisitManager(VisitRepo visitRepo, PatientManager patientManager, DoctorManager doctorManager,
                        DiseaseManager diseaseManager) {
        this.visitRepo = visitRepo;
        this.patientManager = patientManager;
        this.doctorManager = doctorManager;
        this.diseaseManager = diseaseManager;
    }


    public VisitDTO findByPatientIdAndDoctorIdAndVisitDate
            (VisitSearchDTO visitSearchDTO) {
        Patient patient = patientManager.findByIndividualNumber(visitSearchDTO.getPatientIndividualNumber());
        Doctor doctor = doctorManager.findByPzwNumber(visitSearchDTO.getPzwNumber());
        if (patient != null && doctor != null) {
            Optional<Visit> optionalVisit = visitRepo.findByPatientIdAndDoctorIdAndVisitDate(patient.getId(), doctor.getId(),
                    LocalDate.parse(visitSearchDTO.getVisitDate()));
            if (optionalVisit.isPresent()) {
                Visit visit = optionalVisit.get();
                return modelMapper.map(visit, VisitDTO.class);

            } else {
                return null;
            }
        } else
            return null;
    }


    public Map<Boolean, List<String>> save(VisitDTO visitDTO, BindingResult bindingResult) {
        String startDate = visitDTO.getVisitDateString();
        if (startDate != null) {
            visitDTO.setVisitDate(LocalDate.parse(startDate));
        }
        Doctor doctor = doctorManager.findByPzwNumber(visitDTO.getDoctor().getPzwNumber());
        Patient patient = patientManager.findByIndividualNumber(visitDTO.getPatient().getIndividualNumber());

        validate(visitDTO, bindingResult, patient, doctor);

        List<String> messages = new ArrayList<>();
        Map map = new HashMap();

        if (bindingResult.hasErrors()) {
            List<FieldError> errorsList = bindingResult.getFieldErrors();
            for (FieldError error : errorsList) {
                messages.add(error.getCode());
            }
            map.put(false, messages);
        } else {

            Visit visit = modelMapper.map(visitDTO, Visit.class);
            visit.setPatient(patient);
            visit.setDoctor(doctor);
            visitRepo.save(visit);
            messages.add("Visit added successfully");
            map.put(true, messages);
        }
        return map;

    }

    public VisitDTO addDiseaseToVisit(DiseaseDTO diseaseDTO, VisitDTO visitDTO) {

        Disease foundDisease = diseaseManager.
                findDiseaseByPatientAndStartDateAndDiseasesLibraryIcdCode
                        (visitDTO.getPatient().getIndividualNumber(),
                                LocalDate.parse(diseaseDTO.getStartDateString()), diseaseDTO.getDiseasesLibrary().getIcdCode());


        Long diseaseId = foundDisease.getDiseaseId();
        Visit visit = findByPatientIndividualNumberAndDoctorPzwNumberAndVisitDate(visitDTO.getPatient().getIndividualNumber(), visitDTO.getDoctor().getPzwNumber(), visitDTO.getVisitDate());
        Long visitId = visit.getId();

        visitRepo.updateVisit(diseaseId, visitId);
        DiseaseDTO diseaseForVisit = modelMapper.map(foundDisease, DiseaseDTO.class);
        visitDTO.setDisease(diseaseForVisit);
        return visitDTO;


    }


    public Visit findByPatientIndividualNumberAndDoctorPzwNumberAndVisitDate(String patientIndividualNumber,
                                                                             String doctorPzwNumber, LocalDate visitDate) {
        Optional<Visit> optionalVisit = visitRepo.findByPatientIndividualNumberAndDoctorPzwNumberAndVisitDate
                (patientIndividualNumber, doctorPzwNumber, visitDate);
        return optionalVisit.orElse(null);
    }

    public Map<String, List<String>> createHelpVisit() {


        List<DoctorDTO> doctorDTOList = doctorManager.findAll();
        List<String> doctorsPzwNumberList = new ArrayList<>();
        for (DoctorDTO doctor : doctorDTOList) {
            doctorsPzwNumberList.add(doctor.getPzwNumber());
        }


        List<PatientForSearchingDTO> patientForSearchingDTOList = patientManager.findAll();
        List<String> patientsIndividualNumberList = new ArrayList<>();
        for (PatientForSearchingDTO patientForSearchingDTO : patientForSearchingDTOList) {
            patientsIndividualNumberList.add(patientForSearchingDTO.getIndividualNumber());
        }

        Map<String, List<String>> map = new HashMap<>();
        map.put("doctorsPzwNumberList", doctorsPzwNumberList);
        map.put("patientsIndividualNumberList", patientsIndividualNumberList);
        return map;
    }

    public void validate(Object o, Errors errors, Patient patient, Doctor doctor) {
        VisitDTO visitDTO = (VisitDTO) o;


        if (findByPatientIndividualNumberAndDoctorPzwNumberAndVisitDate(visitDTO.getPatient().getIndividualNumber(), visitDTO.getDoctor().getPzwNumber(), visitDTO.getVisitDate()) != null) {
            errors.rejectValue("patient.individualNumber", "This visit exists");
        }
        if (doctor == null) {
            errors.rejectValue("doctor.pzwNumber", "Doctor doesn't exist");
        }
        if (patient == null) {
            errors.rejectValue("patient.individualNumber", "Patient doesn't exist");
        }
    }

}
