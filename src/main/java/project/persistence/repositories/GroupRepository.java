package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.persistence.entities.Group;

import java.util.List;

/**
 * Created by Torfi on 11/12/2016.
 */
public interface GroupRepository extends JpaRepository<Group, String> {
    Group save(Group group);
    void delete(Group group);
    List<Group> findAll();

    Group findOne(String name);
    boolean exists(String name);
}
