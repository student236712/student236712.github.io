package diseases.history.DHapplication.BusinessLayer;

import diseases.history.DHapplication.Objects.DTO.*;
import diseases.history.DHapplication.IntegrationLayer.PatientRepo;
import diseases.history.DHapplication.Objects.Entity.Doctor;
import diseases.history.DHapplication.Objects.Entity.Patient;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.lang.reflect.Type;
import java.util.*;

@Service
public class PatientManager {

    private PatientRepo patientRepo;
    private DoctorManager doctorManager;
    private Type listType = new TypeToken<List<PatientForSearchingDTO>>() {
    }.getType();

    private ModelMapper modelMapper = new ModelMapper();


    @Autowired
    public PatientManager(PatientRepo patientRepo, DoctorManager doctorManager) {
        this.patientRepo = patientRepo;
        this.doctorManager = doctorManager;

    }


    public Patient findByIndividualNumber(String individualNumber) {
        Optional<Patient> optionalPatient = patientRepo.findByIndividualNumber(individualNumber);

        return optionalPatient.orElse(null);
    }

    public Patient findByNumberPesel(String numberPesel) {
        Optional<Patient> optionalPatient = patientRepo.findByNumberPesel(numberPesel);

        return optionalPatient.orElse(null);
    }

    public PatientForDoctorAndWorkerDTO findByIndividualNumberForDoctorAndWorkerDTO(String individualNumber) {

        Optional<Patient> optionalPatient = patientRepo.findByIndividualNumber(individualNumber);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            return modelMapper.map(patient, PatientForDoctorAndWorkerDTO.class);
        } else {
            return null;
        }
    }

    public PatientToCreateHistoryDTO findByIndividualNumberCreateHistory(String individualNumber) {
        Optional<Patient> optionalPatient = patientRepo.findByIndividualNumber(individualNumber);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();

            PatientToCreateHistoryDTO patientToCreateHistoryDTO =
                    modelMapper.map(patient, PatientToCreateHistoryDTO.class);

            if (patientToCreateHistoryDTO.getGender() == 'K') {
                patientToCreateHistoryDTO.setGenderInt(1);
            } else {
                patientToCreateHistoryDTO.setGenderInt(0);
            }

            Set<String> diseasesCategories = new HashSet<>();
            Set<String> diseasesClassifications = new HashSet<>();
            Set<String> diseasesGroups = new HashSet<>();
            Set<String> proceduresCategories = new HashSet<>();
            Set<String> proceduresGroups = new HashSet<>();


            for (DiseaseDTO disease : patientToCreateHistoryDTO.getDiseases()) {

                diseasesClassifications.add(disease.getDiseasesLibrary().getDiseasesCategories().getDiseasesGroups().getDiseasesClassifications().getDescription());
                diseasesGroups.add(disease.getDiseasesLibrary().getDiseasesCategories().getDiseasesGroups().getDescription());
                diseasesCategories.add(disease.getDiseasesLibrary().getDiseasesCategories().getDescription());

                List<PrescriptionMedicamentDTO> prescriptionMedicamentDTOList = new ArrayList<>();
                List<VisitDTO> visitDTOList = new ArrayList<>(disease.getVisits());
                for (VisitDTO visit : visitDTOList) {
                    if (visit.getPrescription() != null) {
                        prescriptionMedicamentDTOList.addAll(new ArrayList<>(visit.getPrescription().getPrescriptionMedicaments()));
                    }
                }
                disease.setPrescriptionMedicaments(prescriptionMedicamentDTOList);
            }


            for (ProcedureDTO procedure : patientToCreateHistoryDTO.getProcedures()) {

                proceduresCategories.add(procedure.getProceduresLibrary().getProceduresCategories().getDescription());
                proceduresGroups.add(procedure.getProceduresLibrary().getProceduresCategories().getProceduresGroups().getDescription());
            }


            //Make lists from sets
            List<String> diseasesCategoriesList = new ArrayList<>(diseasesCategories);
            List<String> diseasesGroupsList = new ArrayList<>(diseasesGroups);
            List<String> diseasesClassificationsList = new ArrayList<>(diseasesClassifications);
            List<String> proceduresCategoriesList = new ArrayList<>(proceduresCategories);
            List<String> proceduresGroupsList = new ArrayList<>(proceduresGroups);


            //Sort lists
            diseasesCategoriesList.sort(String::compareToIgnoreCase);
            diseasesGroupsList.sort(String::compareToIgnoreCase);
            diseasesClassificationsList.sort(String::compareToIgnoreCase);
            proceduresCategoriesList.sort(String::compareToIgnoreCase);
            proceduresGroupsList.sort(String::compareToIgnoreCase);

            //Set lists to object fields
            patientToCreateHistoryDTO.setDiseasesCategories(diseasesCategoriesList);
            patientToCreateHistoryDTO.setDiseasesGroups(diseasesGroupsList);
            patientToCreateHistoryDTO.setDiseasesClassifications(diseasesClassificationsList);
            patientToCreateHistoryDTO.setProceduresCategories(proceduresCategoriesList);
            patientToCreateHistoryDTO.setProceduresGroups(proceduresGroupsList);


            return patientToCreateHistoryDTO;
        } else {
            return null;
        }

    }

    public List<PatientForSearchingDTO> findAll() {

        List<Patient> patients = patientRepo.findAll();
        return modelMapper.map(patients, listType);

    }

    public List<PatientForSearchingDTO> findAllDoctorPatientsIndividualNumbers(String pzwNumber) {
        Doctor doctor = doctorManager.findByPzwNumber(pzwNumber);
        List<Patient> patients = patientRepo.findDoctorPatients(doctor.getId());
        return modelMapper.map(patients, listType);

    }

    public Map<Boolean, List<String>> save(PatientForRegistrantDTO patientDTO, BindingResult bindingResult) {

        List<String> messages = new ArrayList<>();
        Map map = new HashMap();

        patientDTO.setDateOfBirth();
        patientDTO.setGender();
        validate(patientDTO, bindingResult);

        if (bindingResult.hasErrors()) {
            List<FieldError> errorsList = bindingResult.getFieldErrors();
            for (FieldError error : errorsList) {
                messages.add(error.getCode());
            }
            if (messages.size() == 2) {
                String message = messages.get(0).concat(messages.get(1));
                messages.clear();
                messages.add(message);
            }
            map.put(false, messages);
        } else {
            Patient patient = modelMapper.map(patientDTO, Patient.class);
            patientRepo.save(patient);
            messages.add("Patient added successfully");

            map.put(true, messages);

        }
        return map;

    }

    public void validate(Object o, Errors errors) {
        PatientForRegistrantDTO patient = (PatientForRegistrantDTO) o;


        if (findByIndividualNumber(patient.getIndividualNumber()) != null) {
            errors.rejectValue("individualNumber", "Patient individual number exists in database. Please check  and correct it.");
        }
        if (!patient.isIdCorrect()) {
            errors.rejectValue("numberPesel", "Number PESEL is not correct.");
        }
        if (findByNumberPesel(patient.getNumberPesel()) != null) {
            errors.rejectValue("numberPesel", "Patient with this number PESEL exists in database. Please check  and correct it.");
        }
    }

}
