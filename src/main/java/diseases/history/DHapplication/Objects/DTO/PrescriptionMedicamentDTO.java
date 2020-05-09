package diseases.history.DHapplication.Objects.DTO;

import java.io.Serializable;


public class PrescriptionMedicamentDTO implements Serializable {

    private Long id;
    private MedicamentDTO medicament;

    private PrescriptionDTO prescription;
    private double dose;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MedicamentDTO getMedicament() {
        return medicament;
    }

    public void setMedicament(MedicamentDTO medicament) {
        this.medicament = medicament;
    }

    public PrescriptionDTO getPrescription() {
        return prescription;
    }

    public void setPrescription(PrescriptionDTO prescription) {
        this.prescription = prescription;
    }

    public double getDose() {
        return dose;
    }

    public void setDose(double dose) {
        this.dose = dose;
    }
}
