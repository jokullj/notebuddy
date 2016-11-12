package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.LoginInfo;
import project.persistence.entities.User;
import project.service.Implementation.SessionService;
import project.service.Implementation.UserService;

/**
 * Created by Torfi on 11/10/2016.
 */
@Controller
public class UserController {
    UserService userService;
    SessionService sessionService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
        sessionService = SessionService.getSessionService();
    }

    //signup.jsp sýn er birt þegar farið er inn á /signup URLið.
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    //Reynt að búa til nýjan user, þegar notandi sendir POST request á /signup URLi.
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupSubmit(@ModelAttribute User user) {
        if(userService.userExists(user)) {
            //Ef að valið notandanafn er nú þegar til, er signupfailed-uae.jsp (useralreadyexists) sýnin birt.
            return "signupfailed-uae";
        }
        else {
            //Ef að valið notandanafn er ekki til, er nýr user búinn til og signupcomplete.jsp sýnin birt.
            userService.createUser(user);
            return "signupcomplete";
        }
    }

    //login.jsp sýn er birt þegar farið er inn á /login URLið.
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model) {
        model.addAttribute("loginInfo", new LoginInfo());
        return "login";
    }

    //Reynt að skrá notanda inn, þegar notandi sendir POST request á /login URLi.
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginSubmit(@ModelAttribute LoginInfo loginInfo, Model model) {
        //Ef að notandanafn og lykilorð er til í gagnagrunni þá er loginSuccess.jsp sýnin birt.
        if(userService.validateLogin(loginInfo)) {
            model.addAttribute("user", sessionService.getActiveUser());
            return "loginSuccess";
        }
        //Ef að notandanafnið og lykilorðið finnst ekki í gagnagrunni þá er loginUnsuccess.jsp sýnin birt.
        else return "loginUnsuccess";
    }
}
