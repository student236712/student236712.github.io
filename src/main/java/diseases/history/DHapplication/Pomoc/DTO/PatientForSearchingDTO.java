package diseases.history.DHapplication.Pomoc.DTO;

import java.io.Serializable;

public class PatientForSearchingDTO implements Serializable {
    private Long id;
    private String individualNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIndividualNumber() {
        return individualNumber;
    }

    public void setIndividualNumber(String individualNumber) {
        this.individualNumber = individualNumber;
    }
}
