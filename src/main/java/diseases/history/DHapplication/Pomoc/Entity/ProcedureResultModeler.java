package diseases.history.DHapplication.Pomoc.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity


public class ProcedureResultModeler implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long resultModelerId;
    private double lowerLimitWomen;
    private double upperLimitWomen;
    private double lowerLimitMen;
    private double upperLimitMen;

    @OneToOne
    private ProceduresLibrary proceduresLibrary;


    public Long getResultModelerId() {
        return resultModelerId;
    }

    public void setResultModelerId(Long resultModelerId) {
        this.resultModelerId = resultModelerId;
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

    public ProceduresLibrary getProceduresLibrary() {
        return proceduresLibrary;
    }

    public void setProceduresLibrary(ProceduresLibrary proceduresLibrary) {
        this.proceduresLibrary = proceduresLibrary;
    }

}
