package diseases.history.DHapplication.Objects.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity

public class HospitalTreatment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hospitalTreatmentId;
    private String diagnosis; //rozpoznanie
    private LocalDate admissionDate; //data przyjęcia
    private LocalDate dischargeDate; //data wypisu
    private String recommendations; //zalecenia

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @OneToMany(mappedBy = "hospitalTreatment", cascade = CascadeType.ALL)
    private Set<Procedure> procedureSet;

    public Long getHospitalTreatmentId() {
        return hospitalTreatmentId;
    }

    public void setHospitalTreatmentId(Long hospitalTreatmentId) {
        this.hospitalTreatmentId = hospitalTreatmentId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Set<Procedure> getProcedureSet() {
        return procedureSet;
    }

    public void setProcedureSet(Set<Procedure> procedureSet) {
        this.procedureSet = procedureSet;
    }

}
