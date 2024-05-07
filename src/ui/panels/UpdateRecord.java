package ui.panels;

import database.UpdateData;
import ui.MainFrame.Home;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

import util.ComboBoxModels;
import util.ResourceLoader;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class UpdateRecord extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblImage;
    private JButton updateBtn;
    private static JTextField textField_studentNum;
    private static JTextField textField_marks;
    private static JComboBox<String> comboBox_courseCode;
    private static JComboBox<String> comboBox_yearLvl;
    private static JComboBox<String> comboBox_sem;
    
    private static int recordNum;
    private static String studentNum;
    private static String studentMarks;
    private static String studentCourseCode;
    private static String yearLevel;
    private static String semester;
    

    // Method to update the text field and combo boxes with selected data
    public static void updateFields(int recordID, String studentID, float marks, String courseID, String yearLvl, String sem) {      
    	recordNum = recordID;
        studentNum = studentID;
        studentMarks = Float.toString(marks); 
        studentCourseCode = courseID;
        yearLevel = yearLvl;
        semester = sem;
    }

    /**
     * Create the frame.
     */
    public UpdateRecord() {
    	setTitle("Update Record");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 480, 380);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 51));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Update Record");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(new Color(255, 255, 102));
        lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 22));
        lblNewLabel.setBounds(129, 27, 245, 31);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel("Student Number:");
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2.setBounds(129, 81, 168, 17);
        contentPane.add(lblNewLabel_2);

        textField_studentNum = new JTextField(studentNum);
        textField_studentNum.setColumns(10);
        textField_studentNum.setBounds(129, 103, 280, 20);
        contentPane.add(textField_studentNum);
        
        textField_marks = new JTextField(studentMarks);
        textField_marks.setColumns(10);
        textField_marks.setBounds(333, 155, 76, 22);
        contentPane.add(textField_marks);

        JLabel lblNewLabel_3 = new JLabel("Course Code:");
        lblNewLabel_3.setForeground(Color.WHITE);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_3.setBounds(129, 134, 190, 17);
        contentPane.add(lblNewLabel_3);

        comboBox_courseCode = new JComboBox<>(ComboBoxModels.courseCodeModel);
        comboBox_courseCode.setSelectedItem(studentCourseCode);
        comboBox_courseCode.setBounds(129, 155, 190, 22);
        contentPane.add(comboBox_courseCode);

        JLabel lblNewLabel_4 = new JLabel("Marks:");
        lblNewLabel_4.setForeground(Color.WHITE);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_4.setBounds(333, 134, 76, 17);
        contentPane.add(lblNewLabel_4);

        updateBtn = new JButton("Update");
        updateBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		studentNum = textField_studentNum.getText();
                studentMarks = textField_marks.getText();
                studentCourseCode = (String) comboBox_courseCode.getSelectedItem();
                yearLevel = (String) comboBox_yearLvl.getSelectedItem();
                semester = (String) comboBox_sem.getSelectedItem();
                
                UpdateData.updateData(recordNum, studentNum, studentMarks, studentCourseCode, yearLevel, semester);
        	}
        });
        updateBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
        updateBtn.setBounds(220, 268, 89, 31);
        contentPane.add(updateBtn);

        // Load the image and create an ImageIcon
        String imagePath = "resources/images/torch.png";
        ImageIcon imageIcon = ResourceLoader.loadImage(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(131, 180, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(image);

        // Create a JLabel to hold the image
        lblImage = new JLabel(scaledImageIcon);
        lblImage.setBackground(Color.BLACK);
        lblImage.setBounds(0, 11, 124, 303);
        contentPane.add(lblImage);
        
        JLabel lblNewLabel_5 = new JLabel("Year Level:");
        lblNewLabel_5.setForeground(Color.WHITE);
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_5.setBounds(129, 188, 140, 17);
        contentPane.add(lblNewLabel_5);
        
        comboBox_yearLvl = new JComboBox<>(ComboBoxModels.yearLevelModel);
        comboBox_yearLvl.setSelectedItem(yearLevel);
        comboBox_yearLvl.setBounds(129, 209, 140, 22);
        contentPane.add(comboBox_yearLvl);
        
        comboBox_sem = new JComboBox<>(ComboBoxModels.semesterModel);
        comboBox_sem.setSelectedItem(semester);
        comboBox_sem.setBounds(285, 209, 124, 22);
        contentPane.add(comboBox_sem);
        
        JLabel lblNewLabel_6 = new JLabel("Semester:");
        lblNewLabel_6.setForeground(Color.WHITE);
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_6.setBounds(285, 188, 110, 17);
        contentPane.add(lblNewLabel_6);
        
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