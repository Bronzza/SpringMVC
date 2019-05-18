package MateAcad.HomeWork20MVC.controllers;

import MateAcad.HomeWork20MVC.entities.Programmer;
import MateAcad.HomeWork20MVC.services.ProgrammerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AppController {
    @Autowired
    private ProgrammerService service;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Programmer> allProgrammers = service.getAllProgrammers();
        model.addAttribute("allProgrammers", allProgrammers);
        return "index";
    }

    @RequestMapping("/new")
    public String createNewStudentForm(@Valid Model model) {
        Programmer programmer = new Programmer();
        model.addAttribute("programmer", programmer);
        return "programmer";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProgrammer(@ModelAttribute("programmer") Programmer programmer) {
        service.saveProgrammer(programmer);
        return "redirect:/";
    }

    @RequestMapping("/update/{id}")
    public ModelAndView editStudentForm(@Valid @PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("update_programmer");
        Programmer programmer = service.findProgrammerById(id);
        modelAndView.addObject("programmer", programmer);
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String deleteStudent(@PathVariable(name = "id") Long id) {
        service.deleteProgrammerById(id);
        return "redirect:/";
    }
}
