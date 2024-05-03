package database;

import java.sql.*;
import javax.swing.table.*;

public class RetrieveRecords {
    public static DefaultTableModel retrieveLatestRecords() throws SQLException {
        Connection connection = DatabaseConnector.getConnection();
        String sql = "SELECT * FROM student_record ORDER BY timestamp_column DESC LIMIT 100";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        // Define your custom column names
        String[] customColumnNames = {"Record Num", "Marks", "Course ID", "Student ID", "Year Level", "Semester"/* Add more custom names as needed */};

        // Populate the table model with data
        DefaultTableModel tableModel = new DefaultTableModel();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            // Use custom column names if available, otherwise use original column labels
            String columnName = (columnIndex <= customColumnNames.length) ? customColumnNames[columnIndex - 1] : metaData.getColumnLabel(columnIndex);
            // Skip adding timestamp_column to the table model columns
            if (!metaData.getColumnLabel(columnIndex).equals("timestamp_column")) {
                tableModel.addColumn(columnName);
            }
        }
        while (resultSet.next()) {
            Object[] row = new Object[columnCount];
            int rowIdx = 0;
            for (int i = 1; i <= columnCount; i++) {
                // Skip adding the value to the row if it corresponds to the timestamp_column
                if (!metaData.getColumnLabel(i).equals("timestamp_column")) {
                    row[rowIdx++] = resultSet.getObject(i);
                }
            }
            tableModel.addRow(row);
        }
        return tableModel;
    }
}
