package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.Group;
import project.persistence.entities.User;
import project.service.Implementation.GroupService;
import project.service.Implementation.SessionService;

import java.util.ArrayList;

/**
 * Created by Torfi on 11/12/2016.
 */
@Controller
public class GroupController {
    GroupService groupService;
    SessionService sessionService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
        sessionService = SessionService.getSessionService();
    }

    @RequestMapping(value = "/creategroup", method = RequestMethod.GET)
    public String createGroupForm(Model model) {
        model.addAttribute("group", new Group());
        return "creategroup";
    }

    @RequestMapping(value = "/creategroup", method = RequestMethod.POST)
    public String createGroupSubmit(@ModelAttribute Group group) {
        if(sessionService.isLoggedIn()) {
            User user = sessionService.getActiveUser();
            System.out.println(user.getUsername());
            group.addUser(user);
            groupService.createGroup(group);
            return "groupcreated";
        }
        else {
            return "nouser";
        }
    }
}
