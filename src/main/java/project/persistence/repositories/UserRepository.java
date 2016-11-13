package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.persistence.entities.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Torfi on 11/10/2016.
 */
public interface UserRepository extends JpaRepository<User, String>{
    //Add and delete a tuple from the users table.
    User save(User user);
    void delete(User user);

    //Get all tuples, find a specifc tuple.
    ArrayList<User> findAll();
    User findOne(String username);

    //Ask if a certain user exists, ask if a certain user/password combination exists.
    boolean exists(String username);
    User findByUsernameAndPassword(String username, String password);
}
