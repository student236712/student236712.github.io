package diseases.history.DHapplication.Objects.DTO;

import java.io.Serializable;


public class DiseasesGroupsDTO implements Serializable {

    private Long groupId;
    private String description;
    private DiseasesClassificationsDTO diseasesClassifications;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DiseasesClassificationsDTO getDiseasesClassifications() {
        return diseasesClassifications;
    }

    public void setDiseasesClassifications(DiseasesClassificationsDTO diseasesClassifications) {
        this.diseasesClassifications = diseasesClassifications;
    }
}
