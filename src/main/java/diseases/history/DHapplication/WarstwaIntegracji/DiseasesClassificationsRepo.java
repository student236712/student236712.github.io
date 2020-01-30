package diseases.history.DHapplication.WarstwaIntegracji;

import diseases.history.DHapplication.Pomoc.Entity.DiseasesClassifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseasesClassificationsRepo extends JpaRepository<DiseasesClassifications,Long> {



}
