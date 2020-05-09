package diseases.history.DHapplication.Objects.DTO;

import java.io.Serializable;
import java.util.HashSet;

public class PrescriptionDTO implements Serializable {

    private Long id;

    private HashSet<PrescriptionMedicamentDTO> prescriptionMedicaments;

    private VisitDTO visit;

    public PrescriptionDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HashSet<PrescriptionMedicamentDTO> getPrescriptionMedicaments() {
        return prescriptionMedicaments;
    }

    public void setPrescriptionMedicaments(HashSet<PrescriptionMedicamentDTO> prescriptionMedicaments) {
        this.prescriptionMedicaments = prescriptionMedicaments;
    }

    public VisitDTO getVisit() {
        return visit;
    }

    public void setVisit(VisitDTO visit) {
        this.visit = visit;
    }
}
