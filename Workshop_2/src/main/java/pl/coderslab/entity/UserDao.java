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

    public void delete(int userId){
        try (Connection conn = DbUtil.connectWorkshop2()) {
            PreparedStatement ps = conn.prepareStatement(DELETE_USER_QUERY);
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("User couldn't be deleted");
            e.printStackTrace();
        }
    }
}
