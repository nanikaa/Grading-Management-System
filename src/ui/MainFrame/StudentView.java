package ui.MainFrame;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

import database.*;
import model.user.*;
import util.ComboBoxModels;

public class StudentView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable firstSem;
	private JTable secondSem;
	
    private String studentID;
    private String studentFName;
    private String studentLName;
    private String studentYearLvl;
    private String studentSem;
    
    static Student studentData = StudentDataHandler.getStudentData();
    private JLabel lbl_YearLvl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentView frame = new StudentView();
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
	public StudentView() {
		studentID = studentData.getStudentID();
		studentFName = studentData.getFirstName();
		studentLName = studentData.getLastName();
		
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Student");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 760, 680);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Student Number:");
		lblNewLabel_1.setForeground(new Color(245, 255, 250));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1.setBounds(41, 42, 145, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lbl_StudentNum = new JLabel(studentID);
		lbl_StudentNum.setForeground(Color.WHITE);
		lbl_StudentNum.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_StudentNum.setBounds(196, 43, 185, 14);
		contentPane.add(lbl_StudentNum);
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setForeground(new Color(245, 255, 250));
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_2.setBounds(41, 68, 145, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lbl_Name = new JLabel(studentLName + ", "+ studentFName);
		lbl_Name.setForeground(Color.WHITE);
		lbl_Name.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_Name.setBounds(196, 69, 185, 14);
		contentPane.add(lbl_Name);
		
		lbl_YearLvl = new JLabel("");
		lbl_YearLvl.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_YearLvl.setForeground(new Color(245, 255, 250));
		lbl_YearLvl.setFont(new Font("Dialog", Font.BOLD, 14));
		lbl_YearLvl.setBounds(41, 143, 128, 22);
		contentPane.add(lbl_YearLvl);
		
		JLabel lblNewLabel_3 = new JLabel("- 1st Semester");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setForeground(new Color(245, 255, 250));
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_3.setBounds(109, 143, 128, 22);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("GWA:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setForeground(new Color(245, 255, 250));
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_4.setBounds(240, 143, 53, 22);
		contentPane.add(lblNewLabel_4);
		
		JLabel lbl_firstSemGWA1 = new JLabel("");
		lbl_firstSemGWA1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_firstSemGWA1.setForeground(new Color(245, 255, 250));
		lbl_firstSemGWA1.setFont(new Font("Dialog", Font.BOLD, 14));
		lbl_firstSemGWA1.setBounds(287, 143, 53, 22);
		contentPane.add(lbl_firstSemGWA1);
		
		firstSem = new JTable();
		firstSem.setForeground(new Color(255, 255, 102));
		firstSem.setGridColor(new Color(0, 0, 51));
		firstSem.setBackground(new Color(0, 0, 51));
		firstSem.setRowHeight(24);
		firstSem.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		firstSem.setEnabled(false);
		firstSem.setBounds(41, 181, 660, 181);
		contentPane.add(firstSem);
		
		secondSem = new JTable();
		secondSem.setForeground(new Color(255, 255, 102));
		secondSem.setGridColor(new Color(0, 0, 51));
		secondSem.setBackground(new Color(0, 0, 51));
		secondSem.setRowHeight(24);
		secondSem.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		secondSem.setEnabled(false);
		secondSem.setBounds(41, 431, 660, 181);
		contentPane.add(secondSem);
		
		JComboBox<String> comboBoxYearLvl = new JComboBox<String>(ComboBoxModels.yearLevelModel);
		comboBoxYearLvl.setBounds(382, 141, 319, 22);
	    contentPane.add(comboBoxYearLvl);
	    
	    studentYearLvl = "1st Year";
		studentSem = "1st Semester";
		
		DefaultTableModel tableModel = RetrieveStudentMarks.retrieveStudentMarksPerSem(studentYearLvl, studentSem, studentID);
		firstSem.setModel(tableModel);
		
		studentYearLvl = "1st Year";
		studentSem = "2nd Semester";
		
		DefaultTableModel tableModel2 = RetrieveStudentMarks.retrieveStudentMarksPerSem(studentYearLvl, studentSem, studentID);
		secondSem.setModel(tableModel2);
		
	    comboBoxYearLvl.addItemListener(new ItemListener() {
	        public void itemStateChanged(ItemEvent e) {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	                // Get the selected year level from the combo box
	                String selectedYear = comboBoxYearLvl.getSelectedItem().toString();
	                System.out.println("Selected Year: " + selectedYear);
	                // Update the studentYearLvl variable
	                studentYearLvl = selectedYear;
	                studentSem = "1st Semester";
	                String studentSem2 = "2nd Semester";
	                
	                // Fetch data for the selected year level and semester
	                DefaultTableModel tableModel = RetrieveStudentMarks.retrieveStudentMarksPerSem(studentYearLvl, studentSem, studentID);
	                DefaultTableModel tableModel2 = RetrieveStudentMarks.retrieveStudentMarksPerSem(studentYearLvl, studentSem2, studentID);
	                	
	                if (tableModel.getRowCount() == 0) {
	                    System.out.println("No data found for the selected criteria.");
	                    firstSem.setModel(new DefaultTableModel());
	                } else {
	                    // Set the new table model to the firstYear1 table
	                	firstSem.setModel(tableModel);
	                	secondSem.setModel(tableModel2);
	                	lbl_YearLvl = new JLabel(studentYearLvl);
	                    
	                    // Redraw the table
	                	firstSem.revalidate();
	                	firstSem.repaint();
	                	secondSem.revalidate();
	                	secondSem.repaint();
	                }
	            }
	        }
	    });
	   
	    
	    /*TableColumnModel columnModel = firstYear1.getColumnModel(); 
	    columnModel.getColumn(0).setPreferredWidth(25); 
        columnModel.getColumn(1).setPreferredWidth(300); 
        columnModel.getColumn(2).setPreferredWidth(5);
        columnModel.getColumn(3).setPreferredWidth(10);*/
	}
}
