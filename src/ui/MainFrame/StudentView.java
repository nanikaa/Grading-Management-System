package ui.MainFrame;

import java.awt.EventQueue;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

import database.*;
import model.user.*;

public class StudentView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable firstYear1;
	private JTable firstYear2;
	
    private String studentID;
    private String studentFName;
    private String studentLName;
    private String studentYearLvl;
    private String studentSem;
    
    
    static Student studentData = StudentDataHandler.getStudentData();

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
		setBounds(100, 100, 760, 650);
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
		
		JLabel lblNewLabel_3 = new JLabel("1st Year - 1st Semester");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setForeground(new Color(245, 255, 250));
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_3.setBounds(41, 143, 209, 22);
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
		lbl_firstSemGWA1.setBounds(287, 143, 53, 14);
		contentPane.add(lbl_firstSemGWA1);
		
		JLabel lbl_firstSemGWA2 = new JLabel("");
		lbl_firstSemGWA2.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_firstSemGWA2.setForeground(new Color(245, 255, 250));
		lbl_firstSemGWA2.setFont(new Font("Dialog", Font.BOLD, 14));
		lbl_firstSemGWA2.setBounds(628, 143, 53, 14);
		contentPane.add(lbl_firstSemGWA2);
		
		firstYear1 = new JTable();
		firstYear1.setForeground(new Color(255, 255, 102));
		firstYear1.setGridColor(new Color(0, 0, 51));
		firstYear1.setBackground(new Color(0, 0, 51));
		firstYear1.setRowHeight(24);
		firstYear1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		firstYear1.setEnabled(false);
		
		studentYearLvl = "1st Year";
		studentSem = "1st Semester";
		
		firstYear1.setBounds(41, 181, 660, 181);
		contentPane.add(firstYear1);
		
		DefaultTableModel tableModel = RetrieveStudentMarks.retrieveStudentMarksPerSem(studentYearLvl, studentSem, studentID);
	    firstYear1.setModel(tableModel);
	    
	    
	    TableColumnModel columnModel = firstYear1.getColumnModel(); 
	    int columnCount = columnModel.getColumnCount();
	    System.out.println("Col count: " + columnCount);
	    columnModel.getColumn(0).setPreferredWidth(25); 
        columnModel.getColumn(1).setPreferredWidth(300); 
        columnModel.getColumn(2).setPreferredWidth(5);
        columnModel.getColumn(3).setPreferredWidth(10);
        
        studentSem = "2nd Semester";
        
        firstYear2 = new JTable();
        firstYear2.setForeground(new Color(255, 255, 102));
        firstYear2.setGridColor(new Color(0, 0, 51));
        firstYear2.setBackground(new Color(0, 0, 51));
        firstYear2.setRowHeight(24);
        firstYear2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        firstYear2.setEnabled(false);
		
		firstYear2.setBounds(41, 395, 660, 181);
		contentPane.add(firstYear2);
		
		DefaultTableModel tableModel2 = RetrieveStudentMarks.retrieveStudentMarksPerSem(studentYearLvl, studentSem, studentID);
		firstYear2.setModel(tableModel2);
	    
	    
	    TableColumnModel columnModel2 = firstYear2.getColumnModel(); 
	    System.out.println("Col count: " + columnCount);
	    columnModel2.getColumn(0).setPreferredWidth(25); 
        columnModel2.getColumn(1).setPreferredWidth(300); 
        columnModel2.getColumn(2).setPreferredWidth(5);
        columnModel2.getColumn(3).setPreferredWidth(10);
	    
	    JComboBox<String> comboBox = new JComboBox<String>();
	    comboBox.setBounds(382, 141, 319, 22);
	    contentPane.add(comboBox);
	}
}
