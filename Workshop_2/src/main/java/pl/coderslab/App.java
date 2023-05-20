package pl.coderslab;

import pl.coderslab.entity.User;
import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.entity.UserDao;
import pl.coderslab.service.UserService;

/**
 * Hello world!
 *
 */
public class App 
{
    UserDao userDao;
    UserService userService;

    App() {
        userDao = new UserDao();
        userService = new UserService();
    }

    void bootstrap() {
        User user = new User();
        user.setName("Jola");
        user.setEmail("mail.uytyu@gmail.com");
        userService.setUserHashedPassword(user, "puste");
        user.setId(1);
        userDao.updateUser(user);
    }


    public static void main( String[] args ){
        App app = new App();
        app.bootstrap();
        //app.userDao.read(1);

    }

}
