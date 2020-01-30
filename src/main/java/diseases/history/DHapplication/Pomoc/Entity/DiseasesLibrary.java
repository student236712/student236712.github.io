package diseases.history.DHapplication.Pomoc.Entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity

public class DiseasesLibrary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long libraryId;

    private String name;
    @Column(unique = true)
    private String icdCode;
    @OneToMany(mappedBy = "diseasesLibrary", cascade = CascadeType.ALL)
    Set<Disease> diseases;


    private String categoryCode;

    @ManyToOne

    private DiseasesCategories diseasesCategories;

    public DiseasesLibrary() {

    }


    public Long getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Long libraryId) {
        this.libraryId = libraryId;
    }

    public String getIcdCode() {
        return icdCode;
    }

    public void setIcdCode(String icdCode) {
        this.icdCode = icdCode;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DiseasesCategories getDiseasesCategories() {
        return diseasesCategories;
    }

    public void setDiseasesCategories(DiseasesCategories diseasesCategories) {
        this.diseasesCategories = diseasesCategories;
    }

    public void setCategoryCode() {
        this.categoryCode = icdCode.substring(0, 3);
    }

    public Set<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(Set<Disease> diseases) {
        this.diseases = diseases;
    }

}
