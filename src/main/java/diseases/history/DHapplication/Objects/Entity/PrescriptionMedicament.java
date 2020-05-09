package diseases.history.DHapplication.Objects.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity

public class PrescriptionMedicament implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Id
    @ManyToOne
    @JoinColumn
    private Medicament medicament;

    @Id
    @ManyToOne
    @JoinColumn
    private Prescription prescription;
    double dose;

    public PrescriptionMedicament() {
    }

    public PrescriptionMedicament(Medicament medicament, double dose) {
        this.medicament = medicament;
        this.dose = dose;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    public double getDose() {
        return dose;
    }

    public void setDose(double dose) {
        this.dose = dose;
    }



}
