package database;

import java.sql.*;
import javax.swing.*;
import model.user.*;

public class DeleteData {
	//private static String password;
	
	static User newUser = LoginHandler.getLoggedInUser(); 
	
	public static void deleteData(int recordNum, String password) {
		String pass = newUser.getPassword();
		if (password.equals(pass)) {
			try {
	            Connection connection = DatabaseConnector.getConnection();
	            String sql = "DELETE FROM student_record WHERE id_studentRecord = ?";
	            PreparedStatement statement = connection.prepareStatement(sql);
	            statement.setInt(1, recordNum); // Set the recordID for the WHERE clause
	            
	            // Execute the update statement
	            int rowsDeleted = statement.executeUpdate();
	            if (rowsDeleted > 0) {
	            	JOptionPane.showMessageDialog(null, "Data deleted successfully!");
	            } else {
	            	JOptionPane.showMessageDialog(null, "Error! Try Again. ");
	            }

	            connection.close(); // Close the connection
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
		} 
		else {
			JOptionPane.showMessageDialog(null, "Wrong Password! Try Again. ");
		}
    }
}
