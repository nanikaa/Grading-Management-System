package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SearchRecord {
	public static DefaultTableModel searchRecord(String searchVal) {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        conn = DatabaseConnector.getConnection();
	        String sql = "SELECT * FROM student_record WHERE studentRecord_studentID = ? OR studentRecord_courseID = ? ORDER BY timestamp_column DESC";
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, searchVal);
	        ps.setString(2, searchVal);

	        rs = ps.executeQuery();

	        // Define your custom column names
	        String[] customColumnNames = {"Record Num", "Student ID", "Course ID", "Marks", "Year Level", "Semester"};

	        // Populate the table model with data
	        DefaultTableModel tableModel = new DefaultTableModel();
	        ResultSetMetaData metaData = rs.getMetaData();
	        int columnCount = metaData.getColumnCount();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            // Use custom column names if available, otherwise use original column labels
	            String columnName = (columnIndex <= customColumnNames.length) ? customColumnNames[columnIndex - 1] : metaData.getColumnLabel(columnIndex);
	            // Skip adding timestamp_column to the table model columns
	            if (!metaData.getColumnLabel(columnIndex).equals("timestamp_column")) {
	                tableModel.addColumn(columnName);
	            }
	        }
	        while (rs.next()) {
	            Object[] row = new Object[columnCount];
	            int rowIdx = 0;
	            for (int i = 1; i <= columnCount; i++) {
	                // Skip adding the value to the row if it corresponds to the timestamp_column
	                if (!metaData.getColumnLabel(i).equals("timestamp_column")) {
	                    row[rowIdx++] = rs.getObject(i);
	                }
	            }
	            tableModel.addRow(row);
	        }
	        return tableModel;
	    } catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error executing SQL query: " + ex.getMessage());
	        ex.printStackTrace();
	        // Return an empty table model in case of an error
	        return new DefaultTableModel();
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
