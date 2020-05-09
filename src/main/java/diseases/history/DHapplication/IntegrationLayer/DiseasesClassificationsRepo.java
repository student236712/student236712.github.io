package diseases.history.DHapplication.IntegrationLayer;

import diseases.history.DHapplication.Objects.Entity.DiseasesClassifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseasesClassificationsRepo extends JpaRepository<DiseasesClassifications,Long> {



}
