package diseases.history.DHapplication.Objects.DTO;

import java.io.Serializable;


public class DiseasesClassificationsDTO implements Serializable {

    private Long classificationId;
    private String lowerCategoryLimit;
    private String upperCategoryLimit;
    private String description;


    public Long getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Long classificationId) {
        this.classificationId = classificationId;
    }

    public String getLowerCategoryLimit() {
        return lowerCategoryLimit;
    }

    public void setLowerCategoryLimit(String lowerCategoryLimit) {
        this.lowerCategoryLimit = lowerCategoryLimit;
    }

    public String getUpperCategoryLimit() {
        return upperCategoryLimit;
    }

    public void setUpperCategoryLimit(String upperCategoryLimit) {
        this.upperCategoryLimit = upperCategoryLimit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
