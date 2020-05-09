package diseases.history.DHapplication.BusinessLayer;

import diseases.history.DHapplication.IntegrationLayer.DiseasesLibraryRepo;
import diseases.history.DHapplication.Objects.DTO.DiseasesLibraryDTO;
import diseases.history.DHapplication.Objects.Entity.DiseasesLibrary;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class DiseasesLibraryManager {
    private DiseasesLibraryRepo diseasesLibraryRepo;

    private ModelMapper modelMapper = new ModelMapper();
    private Type listType = new TypeToken<List<DiseasesLibraryDTO>>() {
    }.getType();

    @Autowired
    public DiseasesLibraryManager(DiseasesLibraryRepo diseasesLibraryRepo) {
        this.diseasesLibraryRepo = diseasesLibraryRepo;


    }


    public List<DiseasesLibraryDTO> findByDiseasesCategoriesCode(String categoryCode) {
        List<DiseasesLibrary> diseasesLibrary = diseasesLibraryRepo.
                findByDiseasesCategories_CategoryCode(categoryCode);
        return modelMapper.map(diseasesLibrary, listType);

    }

    public DiseasesLibrary findByIcdCode(String icdCode){
        Optional<DiseasesLibrary> optionalDiseasesLibrary = diseasesLibraryRepo.findByIcdCode(icdCode);
        return optionalDiseasesLibrary.orElse(null);
    }
}

