package database;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

import model.user.User;
import ui.MainFrame.Home;

public class LoginHandler {
	private static User newUser;
	
	public static void loginActionPerformed(JFrame loginFrame, String email, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnector.getConnection(); // Assuming DatabaseConnector is correctly set up
            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if (rs.next()) {
                // Retrieve user information from the database
                int userId = rs.getInt("id_user");
                String userEmail = rs.getString("email");
                String userRole = rs.getString("role");

                // Create a User object
                newUser = new User(userId, userEmail, password, userRole);
                
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            Home frame = new Home(); // Pass the user object to Home
                            frame.setVisible(true);  // Make Home visible
                            loginFrame.dispose();   // Dispose login window
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                
            } else {
                JOptionPane.showMessageDialog(null, "Invalid email or password");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error connecting to the database: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
	
	public static User getLoggedInUser() {
        return newUser;
    }
}
