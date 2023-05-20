package pl.coderslab.entity;

import pl.coderslab.DbUtil;

import java.sql.*;
import java.util.Arrays;

public class UserDao {

    private static final String CREATE_USER_QUERY =
            "INSERT INTO users(email,username, password) VALUES (?, ?, ?)";
    private static final String UPDATE_USER_QUERY =
            "update users set email = ?, username = ?, password = ? where id = ?";
    private static final String READ_USER_QUERY_ID = "select * from users where id = ?";
    private static final String READ_USER_QUERY_USERNAME = "select * from users where username = ?";
    private static final String READ_USER_QUERY_EMAIL = "select * from users where email = ?";
    private static final String DELETE_USER_QUERY = "delete from users where id = ?";
    private static final String FIND_ALL_USER_QUERY = "select * from users";
    private static final String DELETE_ALL_USER_QUERY = "delete from users";

    public void updateUser(User user) {
        try (Connection conn = DbUtil.connectWorkshop2()) {
            PreparedStatement ps = conn.prepareStatement(UPDATE_USER_QUERY);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("User couldn't be added");
            e.printStackTrace();
        }
    }
}
