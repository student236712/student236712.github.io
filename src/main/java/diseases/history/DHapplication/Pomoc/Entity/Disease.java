package diseases.history.DHapplication.Pomoc.Entity;

import diseases.history.DHapplication.Pomoc.Enums.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;


@Entity

public class Disease implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long diseaseId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Status status;
    @ManyToOne
    @JoinColumn
    private DiseasesLibrary diseasesLibrary;
    @ManyToOne
    @JoinColumn
    private Patient patient;
    @OneToMany(mappedBy = "disease")
    private Set<Visit> visits;

    public Disease() {
    }

    public DiseasesLibrary getDiseasesLibrary() {
        return diseasesLibrary;
    }

    public void setDiseasesLibrary(DiseasesLibrary diseasesLibrary) {
        this.diseasesLibrary = diseasesLibrary;
    }

    public Long getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Long diseaseId) {
        this.diseaseId = diseaseId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}
