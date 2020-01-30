package diseases.history.DHapplication.Pomoc.DTO;

import java.io.Serializable;
import java.time.LocalDate;


public class VisitDTO implements Serializable {

    private Long id;
    private LocalDate visitDate;
    private String visitDateString;
    private PatientForDoctorAndWorkerDTO patient;
    private DoctorDTO doctor;
    private DiseaseDTO disease;
    private PrescriptionDTO prescription;

    public String getVisitDateString() {
        return visitDateString;
    }

    public void setVisitDateString(String visitDateString) {
        this.visitDateString = visitDateString;
    }

    public VisitDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public PatientForDoctorAndWorkerDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientForDoctorAndWorkerDTO patient) {
        this.patient = patient;
    }

    public DoctorDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDTO doctor) {
        this.doctor = doctor;
    }

    public DiseaseDTO getDisease() {
        return disease;
    }

    public void setDisease(DiseaseDTO disease) {
        this.disease = disease;
    }

    public PrescriptionDTO getPrescription() {
        return prescription;
    }

    public void setPrescription(PrescriptionDTO prescription) {
        this.prescription = prescription;
    }
}
