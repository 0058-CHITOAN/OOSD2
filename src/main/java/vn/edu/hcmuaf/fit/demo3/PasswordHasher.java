package vn.edu.hcmuaf.fit.demo3;

import org.mindrot.jbcrypt.BCrypt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PasswordHasher {
    public static void main(String[] args) {
        String[] usernames = {"admin", "user1"};
        String[] passwords = {"admin123", "user123"};

        for (int i = 0; i < usernames.length; i++) {
            String username = usernames[i];
            String plainPassword = passwords[i];
            String hashedPassword = BCrypt.hashpw(plainPassword, BCrypt.gensalt());

            updatePassword(username, hashedPassword);
            System.out.println("Hashed password for " + username + ": " + hashedPassword);
        }
    }

    private static void updatePassword(String username, String hashedPassword) {
        String query = "UPDATE users SET password = ? WHERE username = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, hashedPassword);
            stmt.setString(2, username);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Updated password for " + username);
            } else {
                System.out.println("User " + username + " not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}