package diseases.history.DHapplication.Objects.Entity;

import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@NaturalIdCache
public class Medicament implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL)
    private Set<PrescriptionMedicament> prescriptionMedicaments = new HashSet<>();



    private String eanCode;
    private String officialName;
    private String usefulName;


    public Medicament() {
    }


    public String getEanCode() {
        return eanCode;
    }

    public void setEanCode(String eanCode) {
        this.eanCode = eanCode;
    }


    public Medicament(Long id, Set<PrescriptionMedicament>
            prescriptionMedicaments, String eanCode, String officialName, String usefulName) {
        this.id = id;
        this.prescriptionMedicaments = prescriptionMedicaments;
        this.eanCode = eanCode;
        this.officialName = officialName;
        this.usefulName = usefulName;
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

    public String getOfficialName() {
        return officialName;
    }

    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }

    public String getUsefulName() {
        return usefulName;
    }

    public void setUsefulName(String usefulName) {
        this.usefulName = usefulName;
    }
}
