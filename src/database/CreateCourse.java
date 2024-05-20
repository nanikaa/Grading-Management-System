package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class CreateCourse {
	
	public static void createCourse (String title, String code, int units) {
		try {
            Connection connection = DatabaseConnector.getConnection();
            String sql = "INSERT INTO course (id_course, course_name, course_units) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, code);
            statement.setString(2, title);
            statement.setInt(3, units);
            
            // Execute the insert statement
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
            	JOptionPane.showMessageDialog(null, "Course created successfully!");
            } else {
            	JOptionPane.showMessageDialog(null, "Error! Try Again. ", "Error", JOptionPane.ERROR_MESSAGE);
            }

            connection.close(); // Close the connection
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
	}
}
