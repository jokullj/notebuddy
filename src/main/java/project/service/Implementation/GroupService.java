package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.Group;
import project.persistence.repositories.GroupRepository;

/**
 * Created by Torfi on 11/12/2016.
 */
@Service
public class GroupService {
    GroupRepository repository;
    SessionService sessionService;

    @Autowired
    public GroupService(GroupRepository repository) {
        this.repository = repository;
        sessionService = SessionService.getSessionService();
    }

    public void createGroup(Group group) {
        repository.save(group);
    }

}
