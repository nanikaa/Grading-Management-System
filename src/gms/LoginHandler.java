package gms;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dao.DatabaseConnector;

public class LoginHandler {
	public static void loginActionPerformed(JFrame loginFrame, String email, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnector.getConnection(); // Assuming DatabaseConnector is correctly set up
            String sql = "SELECT * FROM admin_users WHERE admin_email = ? AND admin_password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if (rs.next()) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            Home frame = new Home(); // Create an instance of Home
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
}
