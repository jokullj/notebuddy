package project.persistence.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Torfi on 11/10/2016.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    private String username;
    private String password;

    //The User class has a many-to-many relationship with the Group class, as defined here.
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "users", cascade = CascadeType.ALL)
    private List<Group> groups;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password= password;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public List<Group> getGroups() {
        return groups;
    }

}
