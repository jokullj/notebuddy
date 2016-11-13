package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.persistence.entities.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Torfi on 11/10/2016.
 */
public interface UserRepository extends JpaRepository<User, String>{

    //Creates a tuple in the "users" table in the database with the values from the user input parameter.
    //param user: User object consisting of a username and password, to be stored in the database.
    User save(User user);

    //Deletes a tuple in the "users" table in the database with the values from the user input parameter.
    //param user: User object consisting of a username and password, to be deleted from the database.
    void delete(User user);

    //Returns a list of all the tuples in the "users" table.
    ArrayList<User> findAll();

    //Returns a User object matching a tuple from the "users" table whose "username" column matches the username input parameter.
    //Param username: String that's used to look up with in the "users" table.
    User findOne(String username);

    boolean exists(String username);

    //Returns a User object matching a tuple from the "users" table whose "username" column matches the username input parameter,
    //and whose "password" column matches the password input paramater.
    //param username: String that's used to look up with in the "users" table, along with the password parameter.
    //param password: String that's used to look up with in the "users" table, along with the username parameter.
    User findByUsernameAndPassword(String username, String password);
}
