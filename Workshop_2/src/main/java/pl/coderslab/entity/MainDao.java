package pl.coderslab.entity;

import pl.coderslab.service.UserService;

public class MainDao {


    public static void main(String[] args) {
        UserService userService = new UserService();
        UserDao userDao = new UserDao();
        User user = new User();
        user.setName("arek");
        user.setEmail("arkadiusz.jozwiak@coderslab.pl");
        userService.setUserHashedPassword(user, "pusty");
        userDao.createNewUser(user);
    }
}
