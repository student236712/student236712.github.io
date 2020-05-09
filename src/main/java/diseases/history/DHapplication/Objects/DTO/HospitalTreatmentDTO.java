package diseases.history.DHapplication.Objects.DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
public class HospitalTreatmentDTO implements Serializable {

    private Long hospitalTreatmentId;
    private String diagnosis; //rozpoznanie
    private LocalDate admissionDate; //data przyjęcia
    private LocalDate dischargeDate; //data wypisu
    private String recommendations; //zalecenia

    private PatientForSearchingDTO patient;

    private Set<ProcedureDTO> procedureSet;

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

    public PatientForSearchingDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientForSearchingDTO patient) {
        this.patient = patient;
    }

    public Set<ProcedureDTO> getProcedureSet() {
        return procedureSet;
    }

    public void setProcedureSet(Set<ProcedureDTO> procedureSet) {
        this.procedureSet = procedureSet;
    }
}
