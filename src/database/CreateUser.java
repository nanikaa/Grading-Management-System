package database;

import java.sql.*;
import javax.swing.*;

public class CreateUser {
    public static void createUser(String studentNum, String firstName, String lastName, String email, String password, String role) {
        Connection connection = null;
        PreparedStatement statementUser = null;
        PreparedStatement statementStudent = null;

        try {
            connection = DatabaseConnector.getConnection();
            connection.setAutoCommit(false); // Start the transaction

            // Insert into users table
            String insertUserQuery = "INSERT INTO users (email, password, role) VALUES (?, ?, ?)";
            statementUser = connection.prepareStatement(insertUserQuery);
            statementUser.setString(1, email);
            statementUser.setString(2, password);
            statementUser.setString(3, role);
            int rowsInsertedUser = statementUser.executeUpdate();

            // Insert into student table if the role is "Student"
            if (rowsInsertedUser > 0 && "Student".equals(role)) {
                String insertStudentQuery = "INSERT INTO student (id_student, student_firstName, student_lastName, student_email) VALUES (?, ?, ?, ?)";
                statementStudent = connection.prepareStatement(insertStudentQuery);
                statementStudent.setString(1, studentNum);
                statementStudent.setString(2, firstName);
                statementStudent.setString(3, lastName);
                statementStudent.setString(4, email);
                int rowsInsertedStudent = statementStudent.executeUpdate();

                if (rowsInsertedStudent <= 0) {
                    throw new SQLException("Failed to insert into student table");
                }
            }

            // Commit the transaction if all operations are successful
            connection.commit();
            JOptionPane.showMessageDialog(null, "Data inserted successfully!");
        } catch (SQLException ex) {
            // Rollback the transaction if an exception occurs
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Error! Try Again. ");
            ex.printStackTrace();
        } finally {
            // Close resources in the finally block
            try {
                if (statementUser != null) {
                    statementUser.close();
                }
                if (statementStudent != null) {
                    statementStudent.close();
                }
                if (connection != null) {
                    connection.setAutoCommit(true); // Restore auto-commit mode
                    connection.close();
                }
            } catch (SQLException closeEx) {
                closeEx.printStackTrace();
            }
        }
    }
}

