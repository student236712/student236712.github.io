package diseases.history.DHapplication.WarstwaIntegracji;

import diseases.history.DHapplication.Pomoc.Entity.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicamentRepo extends JpaRepository<Medicament, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM diseases_history.medicament where useful_name in (?1);")
    List<Medicament> findAllMedicamentsFromList(@Param("param") List<String> eanCode);
}
