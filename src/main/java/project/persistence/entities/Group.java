package project.persistence.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Torfi on 11/12/2016.
 */
@Entity
@Table(name = "groups")
public class Group {
    @Id
    private String name;

    @ManyToMany
    @JoinTable(
            name = "user_group",
            joinColumns = @JoinColumn(name="groupname",
                    referencedColumnName = "name"),
            inverseJoinColumns = @JoinColumn(name="username",
                    referencedColumnName = "username")
            )
    private List<User> users;

    public Group() {
    }

    public Group(String name, ArrayList<User> users) {
        this.name = name;
        this.users = users;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
    public void addUser(User user) {
        if(users == null) users = new ArrayList<User>();
        users.add(user);
    }
}
