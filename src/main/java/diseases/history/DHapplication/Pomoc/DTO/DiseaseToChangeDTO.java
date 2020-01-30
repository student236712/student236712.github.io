package diseases.history.DHapplication.Pomoc.DTO;

import diseases.history.DHapplication.Pomoc.Enums.Status;

import java.io.Serializable;

public class DiseaseToChangeDTO implements Serializable {


    private Long id;

    private String endDate;
    private Status status;
    private DiseasesLibraryDTO diseasesLibrary;
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public DiseasesLibraryDTO getDiseasesLibrary() {
        return diseasesLibrary;
    }

    public void setDiseasesLibrary(DiseasesLibraryDTO diseasesLibrary) {
        this.diseasesLibrary = diseasesLibrary;
    }
}
