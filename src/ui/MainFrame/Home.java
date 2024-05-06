package ui.MainFrame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import database.RetrieveRecords;
import ui.panels.UpdateRecord;
import ui.panels.DeleteRecord;

import java.awt.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;

    // Variables to store selected row data
    private int selectedRecordNumber;
    private float selectedMarks;
    private String selectedCourseID;
    private String selectedStudentID;
    private String selectedYearLvl;
    private String selectedSem;

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
        UpdateRecord.updateFields(selectedRecordNumber, selectedStudentID, selectedMarks, selectedCourseID, selectedYearLvl, selectedSem);
        DeleteRecord.updateFields(selectedRecordNumber, selectedStudentID, selectedMarks, selectedCourseID, selectedYearLvl, selectedSem);
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
            // Call the retrieveLatestRecords() method from the RetrieveRecords class
            DefaultTableModel tableModel = RetrieveRecords.retrieveLatestRecords();

            // Set the obtained table model to your JTable
            table.setModel(tableModel); 

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's requirements
        }
        
     // Add ListSelectionListener to detect row selection
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // Make sure the selection has stabilized
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) { // If a row is selected
                        // Retrieve data from selected row
                    	
                    	selectedRecordNumber = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
                        selectedMarks = Float.parseFloat(table.getValueAt(selectedRow, 1).toString());
                        selectedCourseID = table.getValueAt(selectedRow, 2).toString();
                        selectedStudentID = table.getValueAt(selectedRow, 3).toString();
                        selectedYearLvl = table.getValueAt(selectedRow, 4).toString();
                        selectedSem = table.getValueAt(selectedRow, 5).toString();
                        
                        // Call method to update UI components in UpdateRecord
                        updateUIInUpdateRecord();
                    }
                }
            }
        });

        JButton btn_delete = new JButton("Delete Record");
        btn_delete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                // Display the UpdateRecord JFrame
                DeleteRecord deleteRecordFrame = new DeleteRecord();
                deleteRecordFrame.setVisible(true);
                dispose();
            }
        });
        btn_delete.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_delete.setBounds(613, 226, 158, 46);
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
        btn_update.setBounds(613, 169, 158, 46);
        contentPane.add(btn_update);

        JButton btn_add = new JButton("New Record");
        btn_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // insert code here for Add New Record
            }
        });
        btn_add.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_add.setBounds(613, 112, 158, 46);
        contentPane.add(btn_add);

        JLabel lblNewLabel = new JLabel("GRADING MANAGEMENT SYSTEM");
        lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 24));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(new Color(255, 255, 102));
        lblNewLabel.setBounds(40, 37, 541, 51);
        contentPane.add(lblNewLabel);
        
        JButton btn_add_1 = new JButton("Enroll New User");
        btn_add_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_add_1.setBounds(613, 326, 158, 46);
        contentPane.add(btn_add_1);
    }
}
