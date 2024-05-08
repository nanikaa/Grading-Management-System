package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ui.MainFrame.StudentView;

public class RetrieveStudent {
	
	public static void searchActionPerformed(String studentNum) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            conn = DatabaseConnector.getConnection();
            String sql = "SELECT * FROM student WHERE id_student = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, studentNum);

            rs = ps.executeQuery();

            if (rs.next()) {
                // Retrieve student information from the database
                String studentFName = rs.getString("student_firstName");
                String studentLName = rs.getString("student_lastName");
                String studentEmail = rs.getString("student_email");

                // Create a Student object
                StudentDataHandler.handleStudentData(studentNum, studentFName, studentLName, studentEmail);
                
                // Open StudentView frame
                StudentView studentViewFrame = new StudentView();
                studentViewFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Student not found!");
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
