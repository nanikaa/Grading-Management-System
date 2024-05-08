package database;

import java.sql.*;
import javax.swing.*;
import database.validation.StudentNumValidation;

public class CreateData {
	public static void insertDataIntoDatabase(String studentNum, String studentMarks, String studentCourseCode, String yearLevel, String semester) {
		boolean exists = StudentNumValidation.studentNumExists(studentNum);
		
        if (exists) {
        	try {
                Connection connection = DatabaseConnector.getConnection();
                String sql = "INSERT INTO student_record (studentRecord_studentID, studentRecord_marks, studentRecord_courseID, studentRecord_yearLvl, studentRecord_semester) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, studentNum);
                float marks = Float.parseFloat(studentMarks);
                statement.setFloat(2, marks);
                statement.setString(3, studentCourseCode);
                statement.setString(4, yearLevel);
                statement.setString(5, semester);
                
                // Execute the insert statement
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                	JOptionPane.showMessageDialog(null, "Data inserted successfully!");
                } else {
                	JOptionPane.showMessageDialog(null, "Error! Try Again. ", "Error", JOptionPane.ERROR_MESSAGE);
                }

                connection.close(); // Close the connection
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
        	JOptionPane.showMessageDialog(null, "Student Number does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

