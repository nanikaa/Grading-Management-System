package ui.panels;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.DeleteData;
import ui.MainFrame.Home;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class DeleteRecord extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField_password;
	
	private static String recordNum;
    private static String studentNum;
    private static String studentMarks;
    private static String studentCourseCode;
    private static String yearLevel;
    private static String semester;
    

    // Method to update the text field and combo boxes with selected data
	public static void updateFields(int recordID, String studentID, float marks, String courseID, String yearLvl, String sem) {      
    	recordNum = Integer.toString(recordID);
        studentNum = studentID;
        studentMarks = Float.toString(marks); 
        studentCourseCode = courseID;
        yearLevel = yearLvl;
        semester = sem;
    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DeleteRecord dialog = new DeleteRecord();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DeleteRecord() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Delete Record");
		setBounds(100, 100, 450, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 0, 51));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("To delete this record, enter your password to confirm.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(50, 279, 335, 35);
		contentPanel.add(lblNewLabel);
		
		textField_password = new JTextField();
		textField_password.setBounds(50, 316, 335, 20);
		contentPanel.add(textField_password);
		textField_password.setColumns(10);
		
		{
			JButton okButton = new JButton("Delete");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String password = textField_password.getText();
					int recordNumber = Integer.parseInt(recordNum);
					//System.out.println("Pass: " + password);
					DeleteData.deleteData(recordNumber, password);
				}
			});
			okButton.setBounds(217, 362, 75, 23);
			contentPanel.add(okButton);
			okButton.setActionCommand("Delete");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Home homeFrame = new Home();
                    homeFrame.setExtendedState(JFrame.NORMAL);
                    homeFrame.setVisible(true);
                    
                    dispose();
				}
			});
			cancelButton.setBounds(308, 362, 77, 23);
			contentPanel.add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}
		
		JLabel lblNewLabel_1 = new JLabel("Student Number:");
		lblNewLabel_1.setForeground(new Color(245, 255, 250));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(50, 103, 145, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lbl_StudentNum = new JLabel(studentNum);
		lbl_StudentNum.setForeground(new Color(255, 255, 255));
		lbl_StudentNum.setFont(new Font("Consolas", Font.PLAIN, 12));
		lbl_StudentNum.setBounds(205, 104, 185, 14);
		contentPanel.add(lbl_StudentNum);
		
		JLabel lblNewLabel_1_1 = new JLabel("Record Number:");
		lblNewLabel_1_1.setForeground(new Color(245, 255, 250));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(50, 46, 145, 14);
		contentPanel.add(lblNewLabel_1_1);
		
		JLabel lbl_RecordNum = new JLabel(recordNum);
		lbl_RecordNum.setForeground(new Color(255, 255, 255));
		lbl_RecordNum.setFont(new Font("Consolas", Font.PLAIN, 12));
		lbl_RecordNum.setBounds(200, 46, 185, 14);
		contentPanel.add(lbl_RecordNum);
		
		JLabel lblNewLabel_1_2 = new JLabel("Course Code:");
		lblNewLabel_1_2.setForeground(new Color(245, 255, 250));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(50, 129, 145, 14);
		contentPanel.add(lblNewLabel_1_2);
		
		JLabel lbl_CourseCode = new JLabel(studentCourseCode);
		lbl_CourseCode.setForeground(Color.WHITE);
		lbl_CourseCode.setFont(new Font("Consolas", Font.PLAIN, 12));
		lbl_CourseCode.setBounds(205, 130, 185, 14);
		contentPanel.add(lbl_CourseCode);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Year Level:");
		lblNewLabel_1_2_1.setForeground(new Color(245, 255, 250));
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2_1.setBounds(50, 154, 145, 14);
		contentPanel.add(lblNewLabel_1_2_1);
		
		JLabel lbl_yearLvl = new JLabel(yearLevel);
		lbl_yearLvl.setForeground(Color.WHITE);
		lbl_yearLvl.setFont(new Font("Consolas", Font.PLAIN, 12));
		lbl_yearLvl.setBounds(205, 155, 185, 14);
		contentPanel.add(lbl_yearLvl);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Semester:");
		lblNewLabel_1_2_1_1.setForeground(new Color(245, 255, 250));
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2_1_1.setBounds(50, 179, 145, 14);
		contentPanel.add(lblNewLabel_1_2_1_1);
		
		JLabel lbl_sem = new JLabel(semester);
		lbl_sem.setForeground(Color.WHITE);
		lbl_sem.setFont(new Font("Consolas", Font.PLAIN, 12));
		lbl_sem.setBounds(205, 180, 185, 14);
		contentPanel.add(lbl_sem);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Marks:");
		lblNewLabel_1_2_1_1_1.setForeground(new Color(245, 255, 250));
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2_1_1_1.setBounds(50, 204, 145, 14);
		contentPanel.add(lblNewLabel_1_2_1_1_1);
		
		JLabel lbl_marks = new JLabel(studentMarks);
		lbl_marks.setForeground(Color.WHITE);
		lbl_marks.setFont(new Font("Consolas", Font.PLAIN, 12));
		lbl_marks.setBounds(205, 205, 185, 14);
		contentPanel.add(lbl_marks);
		
		this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                	Home homeFrame = new Home();
                    homeFrame.setExtendedState(JFrame.NORMAL);
                    homeFrame.setVisible(true);
            }
        });
	}
}
