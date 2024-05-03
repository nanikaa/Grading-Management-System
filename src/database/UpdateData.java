package database;

import java.sql.*;
import javax.swing.*;

public class UpdateData {
	public static void updateData(int recordNum, String studentNum, String studentMarks, String studentCourseCode, String yearLevel, String semester) {
		try {
            Connection connection = DatabaseConnector.getConnection();
            String sql = "UPDATE student_record SET studentRecord_studentID = ?, studentRecord_marks = ?, studentRecord_courseID = ?, studentRecord_yearLvl = ?, studentRecord_semester = ? WHERE id_studentRecord = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, studentNum);
            statement.setString(2, studentMarks);
            statement.setString(3, studentCourseCode);
            statement.setString(4, yearLevel);
            statement.setString(5, semester);
            statement.setInt(6, recordNum); // Set the recordID for the WHERE clause
            
            // Execute the update statement
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
            	JOptionPane.showMessageDialog(null, "Data inserted successfully!");
            } else {
            	JOptionPane.showMessageDialog(null, "Error! Try Again. ");
            }

            connection.close(); // Close the connection
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
