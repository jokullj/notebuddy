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
    UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    //Biður repository um að leita í gagnagrunni eftir notandanafni.
    public boolean userExists(User user) {
        User result = repository.findOne(user.getUsername());
        if(result == null) return false;
        else return true;
    }

    //Vistar nýjan notanda í gagnagrunni.
    public void createUser(User user) {
        repository.save(user);
    }

    //Biður repository um að leita í gagnagrunni eftir notandanafni og lykilorði.
    public boolean validateLogin(LoginInfo loginInfo) {
        String username = loginInfo.getUsername();
        String password = loginInfo.getPassword();

        User result = repository.findByUsernameAndPassword(username, password);

        if (result == null) return false;
        else return true;
    }
}
