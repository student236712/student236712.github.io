package diseases.history.DHapplication.Objects.DTO;

import java.io.Serializable;


public class ProceduresGroupsDTO implements Serializable {

    private Long id;
    private String groupCode;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
