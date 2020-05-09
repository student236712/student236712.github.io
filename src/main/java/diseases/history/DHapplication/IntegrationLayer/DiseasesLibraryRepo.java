package diseases.history.DHapplication.IntegrationLayer;


import diseases.history.DHapplication.Objects.Entity.DiseasesLibrary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DiseasesLibraryRepo extends JpaRepository<DiseasesLibrary, Long> {



    List<DiseasesLibrary> findByDiseasesCategories_CategoryCode(String categoryCode);
    Optional<DiseasesLibrary> findByIcdCode(String icdCode);
}
