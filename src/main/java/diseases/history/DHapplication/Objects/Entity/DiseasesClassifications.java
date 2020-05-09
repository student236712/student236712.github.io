package diseases.history.DHapplication.Objects.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
public class DiseasesClassifications implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long classificationId;
    private String lowerCategoryLimit;
    private String upperCategoryLimit;
    @Column(unique = true)
    private String description;
    @OneToMany(mappedBy = "diseasesClassifications")
    Set<DiseasesGroups> diseasesGroups;


    public DiseasesClassifications() {
    }


    public Set<DiseasesGroups> getDiseasesGroups() {
        return diseasesGroups;
    }

    public void setDiseasesGroups(Set<DiseasesGroups> diseasesGroups) {
        this.diseasesGroups = diseasesGroups;
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

    public Long getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Long classificationId) {
        this.classificationId = classificationId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
