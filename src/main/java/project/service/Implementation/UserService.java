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

    public boolean userExists(String username) {
        return userRepository.exists(username);
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findOne(username);
    }

    public boolean validateLogin(LoginInfo loginInfo) {
        User result = userRepository.findByUsernameAndPassword(loginInfo.getUsername(), loginInfo.getPassword());
        if(result == null) return false;
        else return true;
    }
}
