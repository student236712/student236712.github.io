package diseases.history.DHapplication.WarstwaIntegracji;

import diseases.history.DHapplication.Pomoc.Entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface VisitRepo extends JpaRepository<Visit, Long> {
    public Optional<Visit> findByPatientIndividualNumberAndDoctorPzwNumberAndVisitDate(String patientIndividualNumber, String doctorPzwNumber, LocalDate visitDate);

    public Optional<Visit> findByPatientIdAndDoctorIdAndVisitDate(Long patientId, Long doctorId, LocalDate visitDate);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE `diseases_history`.`visits` SET `disease_disease_id` = (?1) " +
            "WHERE `id` =(?2)")
    public void updateVisit(@Param("param") Long diseaseId, @Param("param2") Long visitId);

}
