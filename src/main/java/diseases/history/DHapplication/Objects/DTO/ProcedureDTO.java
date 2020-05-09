package diseases.history.DHapplication.Objects.DTO;

import java.io.Serializable;
import java.time.LocalDate;

public class ProcedureDTO implements Serializable {


    private Long procedureId;
    private LocalDate performanceDate;
    private ProceduresLibraryDTO proceduresLibrary;
    private PatientForSearchingDTO patient;
    private HospitalTreatmentDTO hospitalTreatment;
    private double result;

    public Long getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(Long procedureId) {
        this.procedureId = procedureId;
    }

    public LocalDate getPerformanceDate() {
        return performanceDate;
    }

    public void setPerformanceDate(LocalDate performanceDate) {
        this.performanceDate = performanceDate;
    }


    public ProceduresLibraryDTO getProceduresLibrary() {
        return proceduresLibrary;
    }

    public void setProceduresLibrary(ProceduresLibraryDTO proceduresLibrary) {
        this.proceduresLibrary = proceduresLibrary;
    }

    public PatientForSearchingDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientForSearchingDTO patient) {
        this.patient = patient;
    }

    public HospitalTreatmentDTO getHospitalTreatment() {
        return hospitalTreatment;
    }

    public void setHospitalTreatment(HospitalTreatmentDTO hospitalTreatment) {
        this.hospitalTreatment = hospitalTreatment;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public boolean hasResult(){
        if (this.result == 0) return false;
        else return true;
    }




}
