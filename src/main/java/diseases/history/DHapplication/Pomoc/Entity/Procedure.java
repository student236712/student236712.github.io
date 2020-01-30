package diseases.history.DHapplication.Pomoc.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity

@Table(name = "patients_procedures")

public class Procedure implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long procedureId;
    private double result;
    private LocalDate performanceDate;

    @ManyToOne
    @JoinColumn(name = "procedures_library_library_id")
    private ProceduresLibrary proceduresLibrary;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "hospital_treatment_id", nullable = true)
    private HospitalTreatment hospitalTreatment;


    public Procedure() {
    }

    public ProceduresLibrary getProceduresLibrary() {
        return proceduresLibrary;
    }

    public void setProceduresLibrary(ProceduresLibrary proceduresLibrary) {
        this.proceduresLibrary = proceduresLibrary;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public HospitalTreatment getHospitalTreatment() {
        return hospitalTreatment;
    }

    public void setHospitalTreatment(HospitalTreatment hospitalTreatment) {
        this.hospitalTreatment = hospitalTreatment;
    }

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

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

}
