package diseases.history.DHapplication.Objects.DTO;

import java.io.Serializable;

public class DiseasesCategoriesDTO implements Serializable {


    private Long categoryId;
    private String description;
    private DiseasesGroupsDTO diseasesGroups;
    private DiseasesClassificationsDTO diseasesClassifications;
    private String categoryCode;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DiseasesGroupsDTO getDiseasesGroups() {
        return diseasesGroups;
    }

    public void setDiseasesGroups(DiseasesGroupsDTO diseasesGroups) {
        this.diseasesGroups = diseasesGroups;
    }

    public DiseasesClassificationsDTO getDiseasesClassifications() {
        return diseasesClassifications;
    }

    public void setDiseasesClassifications(DiseasesClassificationsDTO diseasesClassifications) {
        this.diseasesClassifications = diseasesClassifications;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }
}
