package project.persistence.entities;

/**
 * Created by Torfi on 11/9/2016.
 */

//Hlutverk þessa klasa er að halda utan um þær innskráningarupplýsingar sem að notandi slær inn.
//Hlutur af taginu LoginInfo er settur á Model-ið þegar notandi fer inná /login URL.
//Þær upplýsingar sem notandi slær inn á /login URLi eru síðan geymdar í LoginInfo hlutnum.
//LoginInfo hlutnum er síðan ýtt áfram yfir á viðeigandi Service klasa.
public class LoginInfo {

    private String username;
    private String password;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

}
