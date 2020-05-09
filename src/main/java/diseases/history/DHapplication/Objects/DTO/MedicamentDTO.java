package diseases.history.DHapplication.Objects.DTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class MedicamentDTO implements Serializable {
    private Long id;
    private Set<PrescriptionMedicamentDTO> prescriptionMedicaments = new HashSet<>();
    private String eanCode;
    private String officialName;
    private String usefulName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<PrescriptionMedicamentDTO> getPrescriptionMedicaments() {
        return prescriptionMedicaments;
    }

    public void setPrescriptionMedicaments(Set<PrescriptionMedicamentDTO> prescriptionMedicaments) {
        this.prescriptionMedicaments = prescriptionMedicaments;
    }

    public String getEanCode() {
        return eanCode;
    }

    public void setEanCode(String eanCode) {
        this.eanCode = eanCode;
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
