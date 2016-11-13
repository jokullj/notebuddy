package project.persistence.entities;

/**
 * Created by Torfi on 11/13/2016.
 */


//Temporary class to wrap information about a Group and a User, when a user tries to add a user to a group.
//A User_Group object gets created on the Model object, and passed on to the relevant Service when adding a user to a group.
public class User_Group {
    private String groupName;
    private String username;

    public User_Group() {
    }

    public User_Group(String groupName, String username) {
        this.groupName = groupName;
        this.username = username;
    }

    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
