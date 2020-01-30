package diseases.history.DHapplication.Pomoc.DTO;

import java.io.Serializable;


public class ProceduresLibraryDTO implements Serializable {

    private Long proceduresLibraryId;
    private String name;
    private String icdCode;
    private String categoryCode;
    private ProceduresCategoriesDTO proceduresCategories;
    private ProceduresResultsModelerDTO proceduresResultsModeler;

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

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public ProceduresCategoriesDTO getProceduresCategories() {
        return proceduresCategories;
    }

    public void setProceduresCategories(ProceduresCategoriesDTO proceduresCategories) {
        this.proceduresCategories = proceduresCategories;
    }

    public Long getProceduresLibraryId() {
        return proceduresLibraryId;
    }

    public void setProceduresLibraryId(Long proceduresLibraryId) {
        this.proceduresLibraryId = proceduresLibraryId;
    }

    public ProceduresResultsModelerDTO getProceduresResultsModeler() {
        return proceduresResultsModeler;
    }

    public void setProceduresResultsModeler(ProceduresResultsModelerDTO proceduresResultsModeler) {
        this.proceduresResultsModeler = proceduresResultsModeler;
    }
}
