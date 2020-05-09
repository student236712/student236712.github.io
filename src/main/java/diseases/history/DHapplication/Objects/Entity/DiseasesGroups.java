package diseases.history.DHapplication.Objects.Entity;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class DiseasesGroups implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long groupId;
    private String lowerCategoryLimit;
    private String upperCategoryLimit;


    @ManyToOne
    private DiseasesClassifications diseasesClassifications;
    @UniqueElements
    private String description;

    public DiseasesGroups() {
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
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

    public DiseasesClassifications getDiseasesClassifications() {
        return diseasesClassifications;
    }

    public void setDiseasesClassifications(DiseasesClassifications diseasesClassifications) {
        this.diseasesClassifications = diseasesClassifications;
    }

}
