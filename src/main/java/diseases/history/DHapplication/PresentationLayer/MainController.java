package diseases.history.DHapplication.PresentationLayer;

import diseases.history.DHapplication.BusinessLayer.PatientManager;
import diseases.history.DHapplication.Objects.DTO.PatientForRegistrantDTO;
import diseases.history.DHapplication.Objects.DTO.VisitDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller

public class MainController {

    public void setSessionUserName(HttpServletRequest request, Principal principal) {
        request.getSession().setAttribute("userName", principal.getName());
    }

    @Autowired
    PatientManager patientManager;

    @GetMapping("/doctor")
    public String loginDoctor(HttpServletRequest request, Principal principal) {
        setSessionUserName(request, principal);
        return "DoctorHomePage";
    }


    @GetMapping("/registrant")
    public String loginRegistrant() {
        return "RegistrantHomePage";
    }


    @GetMapping("/searchVisit")
    public String searchVisit() {
        return "redirect:/api/visit/getAllDoctorVisits";
    }


    @GetMapping("/searchPatient")
    public String searchPatient() {


        return "redirect:/api/patient/getAllPatients";

    }

    @GetMapping("/addDisease")
    public String addDisease(@ModelAttribute(name = "visit") VisitDTO visitDTO, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("visit", visitDTO);
        return "redirect:/api/disease/searchClassifications";
    }


    @GetMapping("/addPatient")
    public String addPatient(Model model, @ModelAttribute(value = "message") String message) {
        PatientForRegistrantDTO patientForRegistrantDTO = new PatientForRegistrantDTO();
        model.addAttribute("patient", patientForRegistrantDTO);
        model.addAttribute("message", message);
        return "AddPatient";
    }

    @GetMapping("/addVisit")
    public String addVisit() {
        return "redirect:/api/visit/add";
    }
}
