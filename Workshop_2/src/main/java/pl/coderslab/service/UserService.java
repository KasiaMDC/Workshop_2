package pl.coderslab.service;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.entity.User;

public class UserService {
    public void setUserHashedPassword(User user, String password) {
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        user.setPassword(hashed);
    }

    public boolean checkUserPassword(User user, String password) {
        return BCrypt.checkpw(password, user.getPassword());
    }
}