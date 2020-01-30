package diseases.history.DHapplication.Pomoc.DTO;

import diseases.history.DHapplication.Pomoc.Enums.Status;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;


public class DiseaseDTO implements Serializable {


    private Long diseaseId;
    private String startDateString;
    private String endDateString;
    private LocalDate startDate;
    private LocalDate endDate;
    private Status status;
    private DiseasesLibraryDTO diseasesLibrary;
    private PatientForDoctorAndWorkerDTO patient;
    private Set<VisitDTO> visits;
    private List<PrescriptionMedicamentDTO> prescriptionMedicaments;

    public Long getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Long diseaseId) {
        this.diseaseId = diseaseId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public DiseasesLibraryDTO getDiseasesLibrary() {
        return diseasesLibrary;
    }

    public void setDiseasesLibrary(DiseasesLibraryDTO diseasesLibrary) {
        this.diseasesLibrary = diseasesLibrary;
    }

    public PatientForDoctorAndWorkerDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientForDoctorAndWorkerDTO patient) {
        this.patient = patient;
    }

    public String getStartDateString() {
        return startDateString;
    }

    public void setStartDateString(String startDateString) {
        this.startDateString = startDateString;
    }

    public String getEndDateString() {
        return endDateString;
    }

    public void setEndDateString(String endDateString) {
        this.endDateString = endDateString;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Set<VisitDTO> getVisits() {
        return visits;
    }

    public void setVisits(Set<VisitDTO> visits) {
        this.visits = visits;
    }

    public List<PrescriptionMedicamentDTO> getPrescriptionMedicaments() {
        return prescriptionMedicaments;
    }

    public void setPrescriptionMedicaments(List<PrescriptionMedicamentDTO> prescriptionMedicaments) {
        this.prescriptionMedicaments = prescriptionMedicaments;
    }
}
