package diseases.history.DHapplication.Objects.DTO;

import java.io.Serializable;


public class ProceduresCategoriesDTO implements Serializable {


    Long id;
    String description;
    String categoryCode;
    ProceduresGroupsDTO proceduresGroups;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ProceduresGroupsDTO getProceduresGroups() {
        return proceduresGroups;
    }

    public void setProceduresGroups(ProceduresGroupsDTO proceduresGroups) {
        this.proceduresGroups = proceduresGroups;
    }
}
