package diseases.history.DHapplication.WarstwaIntegracji;

import diseases.history.DHapplication.Pomoc.Enums.Status;
import diseases.history.DHapplication.Pomoc.Entity.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface DiseaseRepo extends JpaRepository<Disease, Long> {


    Optional<Disease> findByPatientIndividualNumberAndStartDateAndDiseasesLibraryIcdCode
            (String patientIndividualNumber, LocalDate startDate, String icdCode);

    List<Disease> findByPatientIndividualNumberAndStatus(String individualNumber, Status status);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE `diseases_history`.`disease` SET `end_date` = (?1)," +
            "`status` = (?2) WHERE `disease_id` = (?3);")
    void update(@Param("param") LocalDate endDate,
                @Param("param2") Integer status, @Param("param3") Long diseaseId);
}
