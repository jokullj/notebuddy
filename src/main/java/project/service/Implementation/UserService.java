package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.LoginInfo;
import project.persistence.entities.User;
import project.persistence.repositories.UserRepository;

/**
 * Created by Torfi on 11/10/2016.
 */
@Service
public class UserService {
    UserRepository userRepository;
    SessionService sessionService;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        sessionService = SessionService.getSessionService();
    }

    //Biður repository um að leita í gagnagrunni eftir notandanafni.
    public boolean userExists(String username) {
        return userRepository.exists(username);
    }

    //Vistar nýjan notanda í gagnagrunni.
    public void createUser(User user) {
        userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findOne(username);
    }

    //Biður repository um að leita í gagnagrunni eftir notandanafni og lykilorði.
    public boolean validateLogin(LoginInfo loginInfo) {
        String username = loginInfo.getUsername();
        String password = loginInfo.getPassword();

        User result = userRepository.findByUsernameAndPassword(username, password);

        if (result == null) return false;
        else {
            sessionService.setLoggedIn(true);
            sessionService.setActiveUser(new User(username, password));
            return true;
        }
    }
}
