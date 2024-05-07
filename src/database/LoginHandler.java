package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

import model.user.User;
import model.user.Student;
import ui.MainFrame.Home;
import ui.MainFrame.StudentView;

public class LoginHandler {
	private static User newUser;
	private static Student newStudent;
	
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
                System.out.println("Role: " + newUser.getRole());
                
                if (newUser.getRole().equalsIgnoreCase("Admin")) {
                    // User is admin
                    Home homeFrame = new Home();
                    homeFrame.setVisible(true);
                    loginFrame.dispose();
                } else {
                    // User is a student
                    String query = "SELECT * FROM student WHERE student_email = ? ";
                    ps = conn.prepareStatement(query);
                    ps.setString(1, email);
                    rs = ps.executeQuery(); // Execute the second query

                    if (rs.next()) {
                        // Retrieve student information from the database
                        String studentID = rs.getString("id_student");
                        String studentFName = rs.getString("student_firstName");
                        String studentLName = rs.getString("student_lastName");

                        // Create a Student object
                        newStudent = new Student(studentID, studentFName, studentLName, userEmail);
                        System.out.println("Email: " + newStudent.getEmail());
                        System.out.println("First Name: " + newStudent.getFirstName());
                        System.out.println("Student ID: " + newStudent.getStudentID());

                        // Open StudentView frame
                        StudentView studentViewFrame = new StudentView();
                        studentViewFrame.setVisible(true);
                    } else {
                        // Student data not found
                        JOptionPane.showMessageDialog(null, "Student data not found");
                    }

                    loginFrame.dispose(); // Close the login frame
                }
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
	
	public static Student getStudentData() {
		return newStudent;
	}
}
