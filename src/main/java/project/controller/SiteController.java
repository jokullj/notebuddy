package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.User;
import project.service.Implementation.SessionService;
import project.service.Implementation.UserService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SiteController {
    UserService userService;
    SessionService sessionService;

    public SiteController() {
        this.userService = userService;
        sessionService = SessionService.getSessionService();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/myprofile", method = RequestMethod.GET)
    public String myProfile(Model model, HttpSession session) {
        if(session.isNew()) {
            session.setAttribute("isLoggedIn", false);
            session.setAttribute("activeUser", null);
        }
        boolean login = (Boolean) session.getAttribute("isLoggedIn");
        if(!login) { return "notloggedin"; }
        User activeUser = (User)session.getAttribute("activeUser");
        List groups = activeUser.getGroups();
        model.addAttribute("groups", groups);
        //User activeUser = sessionService.getActiveUser();
        //List groups = activeUser.getGroups();
        //model.addAttribute("groups", groups);
        return "loggedIn/myprofile";
    }
}
