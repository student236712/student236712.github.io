package diseases.history.DHapplication.Pomoc.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity

public class Prescription implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL)
    private Set<PrescriptionMedicament> prescriptionMedicaments;


    @OneToOne
    @JoinColumn(name = "visit_id")
    private Visit visit;

    public Prescription(Visit visit, Set<PrescriptionMedicament> prescriptionMedicaments) {

        for (PrescriptionMedicament prescriptionMedicament : prescriptionMedicaments)
            prescriptionMedicament.setPrescription(this);
        this.prescriptionMedicaments = prescriptionMedicaments;



        this.visit = visit;
    }

    public Prescription() {
    }


    public Set<PrescriptionMedicament> getPrescriptionMedicaments() {
        return prescriptionMedicaments;
    }

    public void setPrescriptionMedicaments(Set<PrescriptionMedicament> prescriptionMedicaments) {
        this.prescriptionMedicaments = prescriptionMedicaments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }
}
