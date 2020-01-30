package diseases.history.DHapplication.WarstwaPrezentacji;

import diseases.history.DHapplication.WarstwaBiznesowa.PatientManager;
import diseases.history.DHapplication.WarstwaBiznesowa.VisitManager;
import diseases.history.DHapplication.Pomoc.DTO.DiseaseDTO;
import diseases.history.DHapplication.Pomoc.DTO.PatientForSearchingDTO;
import diseases.history.DHapplication.Pomoc.DTO.VisitDTO;
import diseases.history.DHapplication.Pomoc.DTO.VisitSearchDTO;
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
@RequestMapping("/api/visit")
public class VisitApi {


    private VisitManager visitManager;
    private PatientManager patientManager;


    @Autowired
    public VisitApi(VisitManager visitManager, PatientManager patientManager) {
        this.visitManager = visitManager;
        this.patientManager = patientManager;
    }

    @GetMapping("/")
    public String get() {
        return "VisitAdd";
    }

    @GetMapping("/search")
    public String search() {
        return "SearchVisit";
    }

    @GetMapping("/searchVisit")
    public String search(HttpServletRequest request,
                         @ModelAttribute(value = "selectedVisit")
                                 VisitSearchDTO visitSearchDTO, Model model, RedirectAttributes redirectAttributes) {

        String pzwNumber = "1234567";
        //  (String) request.getSession().getAttribute("userName");
        visitSearchDTO.setPzwNumber(pzwNumber);

        VisitDTO visitFound = visitManager.findByPatientIdAndDoctorIdAndVisitDate(visitSearchDTO);

        if (visitFound != null) {
            model.addAttribute("visitFound", visitFound);
            return "ShowVisit";
        } else {
            redirectAttributes.addFlashAttribute("message", "Visit doesn't found");
            return "redirect:/api/visit/getAllDoctorVisits";
        }
    }

    @GetMapping("/add")
    public String addVisit(Model model) {
        VisitDTO visitDTO = new VisitDTO();
        Map<String, List<String>> mapResult = visitManager.createHelpVisit();
        model.addAttribute("visit", visitDTO);
        model.addAttribute("map", mapResult);

        return "VisitAdd";

    }

    @PostMapping("/addNewVisit")
    public String addNewVisit(@ModelAttribute("visit") VisitDTO visitDTO, BindingResult
            bindingResult, RedirectAttributes redirectAttributes) {

        Map<Boolean, List<String>> mapResult = visitManager.save(visitDTO, bindingResult);
        if (mapResult.containsKey(false)) {
            redirectAttributes.addFlashAttribute("messages", mapResult.get(false));

        } else {
            redirectAttributes.addFlashAttribute("messages", mapResult.get(true));

        }
        return "redirect:/api/visit/add";
    }

    @PostMapping("/addDiseaseToVisit")
    public String addDiseaseToVisit(@ModelAttribute(name = "visitFound") VisitDTO visitDTO,
                                    @ModelAttribute(name = "selectedDisease") DiseaseDTO diseaseDTO,
                                    Model model) {


        visitDTO = visitManager.addDiseaseToVisit(diseaseDTO, visitDTO);
        model.addAttribute("visit", visitDTO);
        return "ShowVisit";
    }


    @GetMapping("/addDisease")
    public String addDisease() {
        return "VisitAddDisease";
    }

    @GetMapping("/getAllDoctorVisits")
    public String getAllDoctorVisits(HttpServletRequest request, Model model) {
        String pzwNumber = "1234567";
        //(String) request.getSession().getAttribute("userName");

        List<PatientForSearchingDTO> patientDTOList = patientManager.
                findAllDoctorPatientsIndividualNumbers(pzwNumber);

        model.addAttribute("thisDoctorVisitsPatients", patientDTOList);

        VisitSearchDTO visitSearchDTO = new VisitSearchDTO();
        model.addAttribute("selectedVisit", visitSearchDTO);
        return "SearchVisit";

    }

}


