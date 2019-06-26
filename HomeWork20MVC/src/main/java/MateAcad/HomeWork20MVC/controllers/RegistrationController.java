package MateAcad.HomeWork20MVC.controllers;

import MateAcad.HomeWork20MVC.entities.Role;
import MateAcad.HomeWork20MVC.entities.User;
import MateAcad.HomeWork20MVC.services.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.Map;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RegistrationController {

    private final UserServiceImpl userService;

    @GetMapping("/registration")
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user)
                .setViewName("registration");
        return modelAndView;
    }

    @PostMapping("/registration")
    public String addUser(@NotNull User user, Map<String, Object> model) {
        User userDataBase = userService.getByUserName(user.getUsername());

        if (userDataBase != null) {
            model.put("message", "User exists!");
            return "registration";
        }


        user.setRoles(Collections.singleton(Role.USER));
        userService.saveUser(user);

        return "redirect:/login";
    }
}
