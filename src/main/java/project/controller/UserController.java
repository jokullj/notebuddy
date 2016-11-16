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

import javax.servlet.http.HttpSession;

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

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    //This method delegates the task of creating a new user to the userService class.
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupSubmit(@ModelAttribute User user) {
        //If the chosen username already exists, do nothing but inform the user that the signup failed.
        if(userService.userExists(user.getUsername())) {
            return "signupfailed-uae";
        }
        //If the chosen username doesn't exist, create a new user.
        else {
            userService.createUser(user);
            return "signupcomplete";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model) {
        model.addAttribute("loginInfo", new LoginInfo());
        return "login";
    }

    //This method delegates the task of logging in a user to the userService class.
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginSubmit(@ModelAttribute LoginInfo loginInfo, Model model,
                              HttpSession session) {
        //If the submitted username and password match, then log the user in.
        if(userService.validateLogin(loginInfo)) {

            session.setAttribute("isLoggedIn", true);
            session.setAttribute("activeUser", userService.getUserByUsername(loginInfo.getUsername()));
            model.addAttribute("user", session.getAttribute("activeUser"));
            //sessionService.setLoggedIn(true);
            //sessionService.setActiveUser(userService.getUserByUsername(loginInfo.getUsername()));
            //model.addAttribute("user", sessionService.getActiveUser());
            return "loginSuccess";
        }
        //If the submitted username and password don't match, do nothing but inform the user that the login failed.
        else return "loginUnsuccess";
    }
}