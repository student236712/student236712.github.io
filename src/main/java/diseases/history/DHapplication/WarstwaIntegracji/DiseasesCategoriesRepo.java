package diseases.history.DHapplication.WarstwaIntegracji;

import diseases.history.DHapplication.Pomoc.Entity.DiseasesCategories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiseasesCategoriesRepo extends JpaRepository<DiseasesCategories, Long> {



    List<DiseasesCategories> findByDiseasesGroupsDescription(String description);
}
