package database;

import java.sql.*;
import javax.swing.table.*;

public class RetrieveStudentMarks {
    public static DefaultTableModel retrieveStudentMarksPerSem(String year, String semester, String studentNumber) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        DefaultTableModel tableModel = new DefaultTableModel();

        try {
            // Get connection
            connection = DatabaseConnector.getConnection();
            // Prepare SQL statement
            String sql = "SELECT * FROM student_record WHERE studentRecord_studentID = ? & studentRecord_yearLvl = ? & studentRecord_semester = ? ";
            statement = connection.prepareStatement(sql);
            statement.setString(1, studentNumber);
            statement.setString(2, year);
            statement.setString(3, semester);
            // Execute query
            resultSet = statement.executeQuery();

            // Retrieve metadata
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Add columns to table model
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                // Use custom column names if available, otherwise use original column labels
                String columnName = metaData.getColumnLabel(columnIndex);
                tableModel.addColumn(columnName);
            }

            // Add rows to table model
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getObject(i);
                }
                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resultSet, statement, and connection
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return tableModel;
    }
}
