package diseases.history.DHapplication.Pomoc.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ProceduresLibrary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long libraryId;
    private String name;
    private String icdCode;
    @OneToOne
    ProcedureResultModeler proceduresResultsModeler;
    @ManyToOne

    private ProceduresCategories proceduresCategories;


    public ProceduresLibrary() {
    }

    public Long getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Long libraryId) {
        this.libraryId = libraryId;
    }

    public ProcedureResultModeler getProceduresResultsModeler() {
        return proceduresResultsModeler;
    }

    public void setProceduresResultsModeler(ProcedureResultModeler proceduresResultsModeler) {
        this.proceduresResultsModeler = proceduresResultsModeler;
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


    public ProceduresCategories getProceduresCategories() {
        return proceduresCategories;
    }

    public void setProceduresCategories(ProceduresCategories proceduresCategories) {
        this.proceduresCategories = proceduresCategories;
    }

}
