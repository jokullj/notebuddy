package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.persistence.entities.User;

import java.util.List;

/**
 * Created by Torfi on 11/10/2016.
 */
public interface UserRepository extends JpaRepository<User, String>{
    User save(User user);
    void delete(User user);
    List<User> findAll();
    User findOne(String username);
    User findByUsernameAndPassword(String username, String password);
}
