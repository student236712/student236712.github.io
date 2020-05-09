package diseases.history.DHapplication.Objects.DTO;

import java.io.Serializable;
import java.util.Set;


public class DiseasesLibraryDTO implements Serializable {

    private Long libraryId;

    private String name;

    private String icdCode;

    private String categoryCode;
    private DiseasesCategoriesDTO diseasesCategories;
    private Set<DiseaseDTO> diseaseDTOS;

    public Set<DiseaseDTO> getDiseaseDTOS() {
        return diseaseDTOS;
    }

    public void setDiseaseDTOS(Set<DiseaseDTO> diseaseDTOS) {
        this.diseaseDTOS = diseaseDTOS;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public void setDiseasesCategories(DiseasesCategoriesDTO diseasesCategories) {
        this.diseasesCategories = diseasesCategories;
    }

    public Long getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Long libraryId) {
        this.libraryId = libraryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcdCode() {
        return icdCode;
    }

    public void setIcdCode(String icdCode) {
        this.icdCode = icdCode;
    }


    public DiseasesCategoriesDTO getDiseasesCategories() {
        return diseasesCategories;
    }

    public void setDiseasesCategoriesDTO(DiseasesCategoriesDTO diseasesCategoriesDTO) {
        this.diseasesCategories = diseasesCategoriesDTO;
    }

}
