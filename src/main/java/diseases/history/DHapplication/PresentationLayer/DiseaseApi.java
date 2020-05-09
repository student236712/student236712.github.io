package diseases.history.DHapplication.PresentationLayer;

import diseases.history.DHapplication.Objects.Enums.Status;
import diseases.history.DHapplication.Objects.DTO.*;
import diseases.history.DHapplication.BusinessLayer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/api/disease")

public class DiseaseApi {


    private DiseaseManager diseaseManager;
    private DiseasesLibraryManager diseasesLibraryManager;
    private DiseasesGroupsManager diseasesGroupsManager;
    private DiseasesCategoriesManager diseasesCategoriesManager;
    private DiseasesClassificationsManager diseasesClassificationsManager;


    @Autowired
    public DiseaseApi(DiseaseManager diseaseManager, DiseasesLibraryManager diseasesLibraryManager,
                      DiseasesGroupsManager diseasesGroupsManager,
                      DiseasesCategoriesManager diseasesCategoriesManager,
                      DiseasesClassificationsManager diseasesClassificationsManager) {
        this.diseaseManager = diseaseManager;
        this.diseasesLibraryManager = diseasesLibraryManager;
        this.diseasesGroupsManager = diseasesGroupsManager;
        this.diseasesCategoriesManager = diseasesCategoriesManager;
        this.diseasesClassificationsManager = diseasesClassificationsManager;

    }


    @PostMapping("/changeSpecification")
    public String changeSpecification(@ModelAttribute(value = "selectedDisease") DiseaseDTO diseaseDTO,
                                      RedirectAttributes redirectAttributes) {

        diseaseManager.update(diseaseDTO);
        redirectAttributes.addFlashAttribute("patient", diseaseDTO.getPatient());
        return "redirect:/api/disease/c";
    }


    @GetMapping("/c")
    public String findDiseasesByPatientAndStatusNotEndForPatient(
            Model model, @ModelAttribute(value = "patient")
            PatientForDoctorAndWorkerDTO patientForDoctorAndWorkerDTO) {

        List<DiseaseDTO> diseasesFound = diseaseManager.prepare(patientForDoctorAndWorkerDTO);
        model.addAttribute("continuingPatientDiseases", diseasesFound);

        DiseaseDTO diseaseDTO = new DiseaseDTO();

        model.addAttribute("selectedDisease", diseaseDTO);
        model.addAttribute("statusList", Status.values());

        return "DiseaseChangeSpecification";
    }

    @GetMapping("/findPatientDiseasesForVisit")
    public String findPatientDiseasesForVisit(
            HttpServletRequest request, Model model,
            @ModelAttribute(value = "visitFound") VisitDTO visitDTO) {


        List<DiseaseDTO> diseasesFound = diseaseManager.prepare(visitDTO.getPatient());
        model.addAttribute("continuingPatientDiseases", diseasesFound);

        DiseaseDTO diseaseDTO = new DiseaseDTO();

        model.addAttribute("selectedDisease", diseaseDTO);


        return "VisitAddDisease";
    }


    @GetMapping("/searchClassifications")
    public String searchClassifications(Model model,
                                        @ModelAttribute(name = "visitFound") VisitDTO visitDTO) {
        DiseasesClassificationsDTO diseasesClassificationsDTO = new DiseasesClassificationsDTO();
        model.addAttribute("selectedClassification", diseasesClassificationsDTO);

        List<DiseasesClassificationsDTO> allClassifications =
                diseasesClassificationsManager.findAll();
        model.addAttribute("diseasesClassifications", allClassifications);

        return "DiseaseAdd";
    }


    @GetMapping("/searchGroupsForSelectedClassification")

    public String searchGroupsForSelectedClassification(
            @ModelAttribute(value = "selectedClassification") DiseasesClassificationsDTO
                    diseasesClassificationsDTO, Model model,
            @ModelAttribute(name = "visitFound") VisitDTO visitDTO) {
        String description = diseasesClassificationsDTO.getDescription();

        List<DiseasesGroupsDTO> foundGroups =
                diseasesGroupsManager.findByClassificationDescription(description);
        model.addAttribute("diseasesGroups", foundGroups);
        DiseasesGroupsDTO diseasesGroupsDTO = new DiseasesGroupsDTO();
        model.addAttribute("selectedGroup", diseasesGroupsDTO);

        return "DiseaseAddSecondStep";


    }

    @GetMapping("/searchCategoriesForSelectedGroup")
    public String searchCategoriesForSelectedGroup(@ModelAttribute(value = "selectedGroup")
                                                           DiseasesGroupsDTO diseasesGroupsDTO,
                                                   Model model,
                                                   @ModelAttribute(name = "visitFound") VisitDTO visitDTO) {

        List<DiseasesCategoriesDTO> foundCategories =
                diseasesCategoriesManager.findByDescription(diseasesGroupsDTO.getDescription());
        model.addAttribute("diseasesCategories", foundCategories);

        DiseasesCategoriesDTO diseasesCategoriesDTO = new DiseasesCategoriesDTO();
        model.addAttribute("selectedCategory", diseasesCategoriesDTO);
        return "DiseaseAddThirdStep";
    }

    @GetMapping("/searchDiseasesForSelectedCategory")
    public String searchDiseasesForSelectedCategory(@ModelAttribute(value = "selectedCategory")
                                                            DiseasesCategoriesDTO diseasesCategoriesDTO,
                                                    Model model,
                                                    @ModelAttribute(name = "message") String message,
                                                    @ModelAttribute(name = "visitFound") VisitDTO visitDTO) {

        List<DiseasesLibraryDTO> foundDiseasesLibrary =
                diseasesLibraryManager.findByDiseasesCategoriesCode(diseasesCategoriesDTO.getCategoryCode());
        model.addAttribute("diseasesLibrary", foundDiseasesLibrary);
        model.addAttribute("message", message);


        DiseaseDTO diseaseDTO = new DiseaseDTO();
        model.addAttribute("disease", diseaseDTO);

        return "DiseaseAddFourthStep";
    }


    @PostMapping("/add")
    public String addDisease(RedirectAttributes redirectAttributes, Model model,
                             @ModelAttribute(name = "visitFound") VisitDTO visitDTO,
                             @ModelAttribute(value = "selectedCategory")
                                     DiseasesCategoriesDTO diseasesCategoriesDTO,
                             @ModelAttribute(name = "disease") DiseaseDTO diseaseDTO,
                             BindingResult bindingResult) {


        Map<Boolean, List<String>> resultMap = diseaseManager.save(diseaseDTO, bindingResult);
        if (resultMap.containsKey(false)) {
            redirectAttributes.addFlashAttribute("selectedCategory", diseasesCategoriesDTO);
            redirectAttributes.addFlashAttribute("visitFound", visitDTO);
            redirectAttributes.addFlashAttribute("message", resultMap.get(false));
            return "redirect:/api/disease/searchDiseasesForSelectedCategory";
        } else {
            redirectAttributes.addFlashAttribute("visitFound", visitDTO);
            redirectAttributes.addFlashAttribute("message", resultMap.get(true));
            return "redirect:/api/disease/findPatientDiseasesForVisit";
        }
    }
}



