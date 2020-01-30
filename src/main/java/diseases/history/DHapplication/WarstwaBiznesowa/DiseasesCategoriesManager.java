package diseases.history.DHapplication.WarstwaBiznesowa;

import diseases.history.DHapplication.WarstwaIntegracji.DiseasesCategoriesRepo;
import diseases.history.DHapplication.Pomoc.DTO.DiseasesCategoriesDTO;
import diseases.history.DHapplication.Pomoc.Entity.DiseasesCategories;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class DiseasesCategoriesManager {


    private DiseasesCategoriesRepo diseasesCategoriesRepo;
    private ModelMapper modelMapper = new ModelMapper();
    private Type listType = new TypeToken<List<DiseasesCategoriesDTO>>() {
    }.getType();

    @Autowired
    public DiseasesCategoriesManager(DiseasesCategoriesRepo diseasesCategoriesRepo) {
        this.diseasesCategoriesRepo = diseasesCategoriesRepo;

    }

    public List<DiseasesCategoriesDTO> findByDescription(String description) {
        List<DiseasesCategories> diseasesCategories = diseasesCategoriesRepo.
                findByDiseasesGroupsDescription(description);
        return modelMapper.map(diseasesCategories, listType);

    }

}

