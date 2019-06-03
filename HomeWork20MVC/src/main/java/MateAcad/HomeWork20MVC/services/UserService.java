package MateAcad.HomeWork20MVC.services;

import MateAcad.HomeWork20MVC.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getAllUsers();

    User getByUserName(String username);

    void saveUser (User user);
}
