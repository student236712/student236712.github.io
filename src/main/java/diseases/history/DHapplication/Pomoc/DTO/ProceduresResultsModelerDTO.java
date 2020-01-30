package diseases.history.DHapplication.Pomoc.DTO;

import java.io.Serializable;


public class ProceduresResultsModelerDTO implements Serializable {

    private Long id;

    private double lowerLimitWomen;
    private double upperLimitWomen;
    private double lowerLimitMen;
    private double upperLimitMen;
    private ProceduresLibraryDTO proceduresLibrary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public double getLowerLimitWomen() {
        return lowerLimitWomen;
    }

    public void setLowerLimitWomen(double lowerLimitWomen) {
        this.lowerLimitWomen = lowerLimitWomen;
    }

    public double getUpperLimitWomen() {
        return upperLimitWomen;
    }

    public void setUpperLimitWomen(double upperLimitWomen) {
        this.upperLimitWomen = upperLimitWomen;
    }

    public double getLowerLimitMen() {
        return lowerLimitMen;
    }

    public void setLowerLimitMen(double lowerLimitMen) {
        this.lowerLimitMen = lowerLimitMen;
    }

    public double getUpperLimitMen() {
        return upperLimitMen;
    }

    public void setUpperLimitMen(double upperLimitMen) {
        this.upperLimitMen = upperLimitMen;
    }

    public ProceduresLibraryDTO getProceduresLibrary() {
        return proceduresLibrary;
    }

    public void setProceduresLibrary(ProceduresLibraryDTO proceduresLibrary) {
        this.proceduresLibrary = proceduresLibrary;
    }
}
