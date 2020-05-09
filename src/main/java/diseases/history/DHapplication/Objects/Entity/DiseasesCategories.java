package diseases.history.DHapplication.Objects.Entity;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NaturalIdCache

public class DiseasesCategories implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;
    @Column(unique = true)
    private String description;
    @NaturalId
    private String categoryCode;
    @NaturalId(mutable = true)
    @ManyToOne
    private DiseasesGroups diseasesGroups;

    public DiseasesCategories() {
    }


    public DiseasesGroups getDiseasesGroups() {
        return diseasesGroups;
    }

    public void setDiseasesGroups(DiseasesGroups diseasesGroups) {
        this.diseasesGroups = diseasesGroups;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}