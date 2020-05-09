package diseases.history.DHapplication.Objects.Entity;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NaturalIdCache

public class ProceduresCategories implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long categoryId;

    private String description;
    @NaturalId
    private String categoryCode;
    @NaturalId(mutable = true)
    @ManyToOne
    private ProceduresGroups proceduresGroups;

    public ProceduresCategories() {
    }

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

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public ProceduresGroups getProceduresGroups() {
        return proceduresGroups;
    }

    public void setProceduresGroups(ProceduresGroups proceduresGroups) {
        this.proceduresGroups = proceduresGroups;
    }

}
