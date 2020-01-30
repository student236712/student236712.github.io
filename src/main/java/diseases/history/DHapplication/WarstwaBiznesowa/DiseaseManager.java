package diseases.history.DHapplication.WarstwaBiznesowa;

import diseases.history.DHapplication.Pomoc.Enums.Status;
import diseases.history.DHapplication.WarstwaIntegracji.DiseaseRepo;
import diseases.history.DHapplication.Pomoc.DTO.DiseaseDTO;
import diseases.history.DHapplication.Pomoc.DTO.PatientForDoctorAndWorkerDTO;
import diseases.history.DHapplication.Pomoc.Entity.Disease;
import diseases.history.DHapplication.Pomoc.Entity.DiseasesLibrary;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DiseaseManager {

    private DiseaseRepo diseaseRepo;

    private DiseasesLibraryManager diseasesLibraryManager;
    private ModelMapper modelMapper = new ModelMapper();
    private Type listType = new TypeToken<List<DiseaseDTO>>() {
    }.getType();

    @Autowired
    public DiseaseManager(DiseaseRepo diseaseRepo, DiseasesLibraryManager diseasesLibraryManager) {
        this.diseaseRepo = diseaseRepo;
        this.diseasesLibraryManager = diseasesLibraryManager;
    }


    public void update(DiseaseDTO diseaseDTO) {

        String endDateString = diseaseDTO.getEndDateString();
        Integer status;
        LocalDate endDate = null;
        if (endDateString != "" && endDateString != null) {
            status = (Status.TERMINATED).ordinal();
            endDate = LocalDate.parse(endDateString);
        } else {
            status = Status.CHRONIC.ordinal();

        }
        diseaseRepo.update(endDate, status, diseaseDTO.getDiseaseId());

    }

    public Map<Boolean, List<String>> save(DiseaseDTO diseaseDTO, BindingResult bindingResult) {
        validate(diseaseDTO, bindingResult);
        diseaseDTO.setStartDate(LocalDate.parse(diseaseDTO.getStartDateString()));

        List<String> messages = new ArrayList<>();
        Map map = new HashMap();


        if (bindingResult.hasErrors()) {
            List<FieldError> errorsList = bindingResult.getFieldErrors();
            for (FieldError error : errorsList) {
                messages.add(error.getCode());
            }
            map.put(false, messages);
        } else {


            diseaseDTO.setStatus(Status.UNDERWAY);

            DiseasesLibrary diseasesLibrary = diseasesLibraryManager.
                    findByIcdCode(diseaseDTO.getDiseasesLibrary().getIcdCode());
            diseaseDTO.getDiseasesLibrary().setLibraryId(diseasesLibrary.getLibraryId());
            Disease disease = modelMapper.map(diseaseDTO, Disease.class);
            diseaseRepo.save(disease);
            messages.add("Disease saved successfully");
            map.put(true, messages);
        }
        return map;
    }


    public Disease findDiseaseByPatientAndStartDateAndDiseasesLibraryIcdCode(String patientIndividualNumber,
                                                                             LocalDate startDate, String icdCode) {

        Optional<Disease> optionalDisease = diseaseRepo.
                findByPatientIndividualNumberAndStartDateAndDiseasesLibraryIcdCode
                        (patientIndividualNumber, startDate,
                                icdCode);
        if (optionalDisease.isPresent()) {
            return optionalDisease.get();
        } else return null;


    }

    public List<DiseaseDTO> findDiseasesByPatientAndStatus(PatientForDoctorAndWorkerDTO
                                                                   patientForDoctorAndWorkerDTO,
                                                           Status status) {

        List<Disease> diseaseList = diseaseRepo.findByPatientIndividualNumberAndStatus(patientForDoctorAndWorkerDTO.getIndividualNumber(), status);
        return modelMapper.map(diseaseList, listType);

    }


    public List<DiseaseDTO> prepare(PatientForDoctorAndWorkerDTO patientForDoctorAndWorkerDTO) {
        List<DiseaseDTO> diseasesUnderwayFound =
                findDiseasesByPatientAndStatus(patientForDoctorAndWorkerDTO, Status.UNDERWAY);
        List<DiseaseDTO> diseasesChronicFound = findDiseasesByPatientAndStatus(patientForDoctorAndWorkerDTO, Status.CHRONIC);
        return Stream.concat(diseasesChronicFound.stream(), diseasesUnderwayFound.stream()).collect(Collectors.toList());
    }

    public void validate(Object o, Errors errors) {
        DiseaseDTO diseaseDTO = (DiseaseDTO) o;
        diseaseDTO.setStartDate(LocalDate.parse(diseaseDTO.getStartDateString()));

        if (findDiseaseByPatientAndStartDateAndDiseasesLibraryIcdCode(
                diseaseDTO.getPatient().getIndividualNumber(), diseaseDTO.getStartDate(), diseaseDTO.getDiseasesLibrary().getIcdCode()) != null) {
            errors.rejectValue("startDate", "This disease for this patient exists");
        }

    }

}

