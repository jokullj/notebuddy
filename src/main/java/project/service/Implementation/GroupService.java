package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.Group;
import project.persistence.entities.User;
import project.persistence.repositories.GroupRepository;
import project.persistence.repositories.UserRepository;

/**
 * Created by Torfi on 11/12/2016.
 */
@Service
public class GroupService {
    GroupRepository groupRepository;
    //UserRepository userRepository;
    SessionService sessionService;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
        //this.userRepository = userRepository;
        sessionService = SessionService.getSessionService();
    }

    public void saveGroup(Group group) {
        groupRepository.save(group);
    }

    public boolean groupExists(String name) {
        return groupRepository.exists(name);
    }

    public Group getGroupByName(String name) { return groupRepository.findOne(name); }

    public void addUserToGroup(Group group, User user) {
        //if(groupRepository)
    }

}
