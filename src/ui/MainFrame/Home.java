package ui.MainFrame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import database.RetrieveRecords;
import database.SearchRecord;
import ui.panels.*;
import util.ResourceLoader;

import java.awt.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JLabel lblImage;
    private JButton btnDelete;
    private JButton btnUpdate;

    // Variables to store selected row data
    private int selectedRecordNumber;
    private float selectedMarks;
    private String selectedCourseID;
    private String selectedStudentID;
    private String selectedYearLvl;
    private String selectedSem;
    private JTextField textField_search;

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
        setResizable(false);
        setTitle("Admin Home");
        setBounds(100, 100, 832, 510);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 51));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Create the table to display the records
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(216, 175, 553, 238);
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
                        
                        // Enable buttons
                        btnDelete.setEnabled(true);
                        btnUpdate.setEnabled(true);
                        
                        // Call method to update UI components in UpdateRecord
                        updateUIInUpdateRecord();
                    } else {
                        // If no row is selected, disable buttons
                    	btnDelete.setEnabled(false);
                    	btnUpdate.setEnabled(false);
                    }
                }
            }
        });

        btnDelete = new JButton("Delete Record");
        btnDelete.setEnabled(false); // Initially disable the button
        btnDelete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                // Display the DeleteRecord JFrame
                DeleteRecord deleteRecordFrame = new DeleteRecord();
                deleteRecordFrame.setVisible(true);
                dispose();
            }
        });
        btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnDelete.setBounds(42, 310, 130, 46);
        contentPane.add(btnDelete);

        btnUpdate = new JButton("Update Record");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                // Display the UpdateRecord JFrame
                UpdateRecord updateRecordFrame = new UpdateRecord();
                updateRecordFrame.setVisible(true);
                dispose();
            }
        });
        
        btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnUpdate.setBounds(42, 253, 130, 46);
        contentPane.add(btnUpdate);

        JButton btn_add = new JButton("New Record");
        btn_add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	// Display the AddRecord JFrame
                AddRecord addRecordFrame = new AddRecord();
                addRecordFrame.setVisible(true);
            }
        });
        btn_add.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_add.setBounds(42, 196, 130, 46);
        contentPane.add(btn_add);

        JLabel lblNewLabel = new JLabel("GRADING MANAGEMENT SYSTEM");
        lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 28));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(new Color(255, 255, 102));
        lblNewLabel.setBounds(216, 35, 553, 51);
        contentPane.add(lblNewLabel);
        
        JButton btn_add_1 = new JButton("Enroll New User");
        btn_add_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		NewUser newUserPanel = new NewUser();
                newUserPanel.getFrame().setVisible(true);
                dispose();
        	}
        });
        btn_add_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_add_1.setBounds(42, 367, 130, 46);
        contentPane.add(btn_add_1);
        
        JButton btn_search = new JButton("View Student");
        btn_search.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		SearchStudent searchFrame = new SearchStudent();
        		searchFrame.setVisible(true);
        	}
        });
        btn_search.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btn_search.setBounds(42, 139, 130, 46);
        contentPane.add(btn_search);
        
        textField_search = new JTextField();
        textField_search.setBounds(492, 139, 178, 25);
        contentPane.add(textField_search);
        textField_search.setColumns(10);
        
        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String searchValue = textField_search.getText();
        		DefaultTableModel searchTableModel = SearchRecord.searchRecord(searchValue);

                // Set the obtained table model to your JTable
                table.setModel(searchTableModel);
        	}
        });
        btnSearch.setBounds(680, 139, 89, 25);
        contentPane.add(btnSearch);
        
     // Load the image and create an ImageIcon
        String imagePath = "resources/images/circuits.png";
        ImageIcon imageIcon = ResourceLoader.loadImage(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(image);

        // Create a JLabel to hold the image
        lblImage = new JLabel(scaledImageIcon);
        lblImage.setBackground(Color.BLACK);
        lblImage.setBounds(75, 35, 65, 65);
        contentPane.add(lblImage);
    }
}
