package database.validation;

import java.sql.*;
import database.*;

public class StudentNumValidation {
	
	public static boolean studentNumExists(String studentID) {
		boolean exists = false;
        try {
            Connection connection = DatabaseConnector.getConnection();
            String sql = "SELECT COUNT(*) FROM student WHERE id_student = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, studentID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count > 0) {
                    exists = true;
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
	}
}
