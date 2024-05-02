package gms;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import dao.DatabaseConnector;

import java.awt.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;

    // Variables to store selected row data
    //private String selectedRecordNumber;
    private float selectedMarks;
    private String selectedCourseID;
    private String selectedStudentID;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Home frame = new Home();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    
 // Method to update the UI components in UpdateRecord
    private void updateUIInUpdateRecord() {
        // Pass the selected data to the method in UpdateRecord
        UpdateRecord.updateFields(selectedStudentID, selectedMarks, selectedCourseID);
    }
    
    public Home() {
        setAlwaysOnTop(true);
        setResizable(false);
        setTitle("Admin Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 832, 440);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 51));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Create the table to display the records
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(40, 112, 541, 260);
        contentPane.add(scrollPane);

        // Connect to the database and retrieve the latest 100 records
        try {
            Connection connection = DatabaseConnector.getConnection();
            String sql = "SELECT * FROM student_record ORDER BY timestamp_column DESC LIMIT 100";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Define your custom column names
            String[] customColumnNames = {"Record Number", "Marks", "Course ID", "Student ID"/* Add more custom names as needed */};

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
            table.setModel(tableModel);

         // Add ListSelectionListener to detect row selection
            table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) { // Make sure the selection has stabilized
                        int selectedRow = table.getSelectedRow();
                        if (selectedRow != -1) { // If a row is selected
                            // Retrieve data from selected row
                            //selectedRecordNumber = table.getValueAt(selectedRow, 0).toString();
                            //selectedMarks = table.getValueAt(selectedRow, 1).toString();
                            selectedMarks = Float.parseFloat(table.getValueAt(selectedRow, 1).toString());
                            selectedCourseID = table.getValueAt(selectedRow, 2).toString();
                            selectedStudentID = table.getValueAt(selectedRow, 3).toString();
                            
                            // Call method to update UI components in UpdateRecord
                            updateUIInUpdateRecord();
                        }
                    }
                }
            });

            JButton btn_delete = new JButton("Delete Record");
            btn_delete.setFont(new Font("Tahoma", Font.PLAIN, 14));
            btn_delete.setBounds(613, 297, 158, 46);
            contentPane.add(btn_delete);

            JButton btn_update = new JButton("Update Record");
            btn_update.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
                    // Display the UpdateRecord JFrame
                    UpdateRecord updateRecordFrame = new UpdateRecord();
                    updateRecordFrame.setVisible(true);
                    dispose();
                }
            });
            
            btn_update.setFont(new Font("Tahoma", Font.PLAIN, 14));
            btn_update.setBounds(613, 240, 158, 46);
            contentPane.add(btn_update);

            JButton btn_add = new JButton("New Record");
            btn_add.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // insert code here for Add New Record
                }
            });
            btn_add.setFont(new Font("Tahoma", Font.PLAIN, 14));
            btn_add.setBounds(613, 183, 158, 46);
            contentPane.add(btn_add);

            JLabel lblNewLabel = new JLabel("GRADING MANAGEMENT SYSTEM");
            lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 24));
            lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
            lblNewLabel.setForeground(new Color(255, 255, 102));
            lblNewLabel.setBounds(40, 37, 541, 51);
            contentPane.add(lblNewLabel);

            connection.close(); // Close the connection
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
