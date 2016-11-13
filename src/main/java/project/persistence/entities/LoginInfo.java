package project.persistence.entities;

/**
 * Created by Torfi on 11/9/2016.
 */

//Temporary class to wrap the login credentials that a user enters when trying to log in.
//A LoginInfo object gets created on the Model object, and passed on to the relevant Service when validating user login.
public class LoginInfo {

    private String username;
    private String password;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

}
