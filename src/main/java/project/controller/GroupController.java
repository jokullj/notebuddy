package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.Group;
import project.persistence.entities.User;
import project.persistence.entities.User_Group;
import project.service.Implementation.GroupService;
import project.service.Implementation.SessionService;
import project.service.Implementation.UserService;

/**
 * Created by Torfi on 11/12/2016.
 */
@Controller
public class GroupController {
    GroupService groupService;
    UserService userService;
    SessionService sessionService;

    @Autowired
    public GroupController(GroupService groupService, UserService userService) {
        this.groupService = groupService;
        this.userService = userService;
        sessionService = SessionService.getSessionService();
    }

    @RequestMapping(value = "/creategroup", method = RequestMethod.GET)
    public String createGroupForm(Model model) {
        model.addAttribute("group", new Group());
        return "creategroup";
    }

    //This method delegates the task of creating a new group to the groupService class.
    @RequestMapping(value = "/creategroup", method = RequestMethod.POST)
    public String createGroupSubmit(@ModelAttribute Group group) {
        //If the user isn't logged in, or if a group with the chosen group name already exists,
        //then do nothing, but inform the user that the group creation failed.
        if(!sessionService.isLoggedIn()) { return "nouser"; }
        if(groupService.groupExists(group.getName())) { return "groupexists"; }

        //If user is logged in and the chosen group name is available, create the group.
        User user = sessionService.getActiveUser();
        group.addUser(user);
        groupService.saveGroup(group);
        return "groupcreated";
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public String addUserToGroupForm(Model model) {
        model.addAttribute("user_group", new User_Group());
        return "adduser";
    }

    //This method handles the task of adding a user to a group.
    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String addUserToGroupSubmit(@ModelAttribute User_Group user_group, Model model) {
        //First handle three erroneous cases, that is: user isn't logged in, group doesn't exist,
        //user to be added doesn't exist. If any of those cases come up, then do nothing,
        //but inform the user that adding a user to a group failed.
        if(!sessionService.isLoggedIn()) { return "nouser"; }
        if(!groupService.groupExists(user_group.getGroupName())) {
            model.addAttribute("groupName", user_group.getGroupName());
            return "groupnotexists"; }
        if(!userService.userExists(user_group.getUsername())) {
            model.addAttribute("username", user_group.getUsername());
            return "usernotexists";
        }

        //If the user is logged in, and the group and user to be added both exist, then add the user to the group.
        User user = userService.getUserByUsername(user_group.getUsername());
        Group group = groupService.getGroupByName(user_group.getGroupName());
        group.addUser(user);
        groupService.saveGroup(group);
        return "useradded";
    }
}
