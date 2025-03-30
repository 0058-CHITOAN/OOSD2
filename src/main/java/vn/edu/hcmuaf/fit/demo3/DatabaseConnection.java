package vn.edu.hcmuaf.fit.demo3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/qnbvvnd?serverTimezone=UTC";
    private static final String USER = "root"; // Thay bằng username của bạn
    private static final String PASSWORD = "1234"; // Thay bằng password của bạn

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}