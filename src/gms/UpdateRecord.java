package gms;

import javax.swing.*;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import util.ComboBoxModels;

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
    
    private static String studentNum;
    private static String studentMarks;
    private static String studentCourseCode;
    

    // Method to update the text field and combo boxes with selected data
    public static void updateFields(String studentID, float marks, String courseID) {      
        //comboBox_marks.setSelectedItem(marks);
        //textField_studentNum.setText(studentID);
        
        studentNum = studentID;
        studentMarks = Float.toString(marks); 
        studentCourseCode = courseID;
        
        System.out.println("New Student ID: " + studentNum);
        System.out.println("New Marks: " + studentMarks);
        System.out.println("New Course ID: " + studentCourseCode);
        		
    }

    /**
     * Create the frame.
     */
    public UpdateRecord() {
    	setTitle("Update Record");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        JLabel lblNewLabel_1 = new JLabel("Student Number:");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setBounds(129, 81, 168, 17);
        contentPane.add(lblNewLabel_1);

        textField_studentNum = new JTextField(studentNum);
        textField_studentNum.setColumns(10);
        textField_studentNum.setBounds(129, 103, 280, 20);
        contentPane.add(textField_studentNum);
        
        textField_marks = new JTextField(studentMarks);
        textField_marks.setColumns(10);
        textField_marks.setBounds(333, 155, 76, 22);
        contentPane.add(textField_marks);

        JLabel lblNewLabel_1_1 = new JLabel("Course Code:");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1.setBounds(129, 134, 190, 17);
        contentPane.add(lblNewLabel_1_1);

        comboBox_courseCode = new JComboBox<>(ComboBoxModels.courseCodeModel);
        comboBox_courseCode.setBounds(129, 155, 190, 22);
        contentPane.add(comboBox_courseCode);

        JLabel lblNewLabel_1_2 = new JLabel("Marks:");
        lblNewLabel_1_2.setForeground(Color.WHITE);
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2.setBounds(333, 134, 76, 17);
        contentPane.add(lblNewLabel_1_2);

        updateBtn = new JButton("Update");
        updateBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
        updateBtn.setBounds(230, 269, 89, 31);
        contentPane.add(updateBtn);

        // Load the image and create an ImageIcon
        ImageIcon imageIcon = new ImageIcon("C:/Users/Jane Martinez Pili/Grading-Management-System/src/img/torch.png");

        // Resize the image to fit the JLabel
        Image image = imageIcon.getImage().getScaledInstance(131, 180, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(image);

        // Create a JLabel to hold the image
        lblImage = new JLabel(scaledImageIcon);
        lblImage.setBackground(Color.BLACK);
        lblImage.setBounds(0, 11, 124, 303);
        contentPane.add(lblImage);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Year Level:");
        lblNewLabel_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1_1.setBounds(129, 188, 140, 17);
        contentPane.add(lblNewLabel_1_1_1);
        
        comboBox_yearLvl = new JComboBox<>(ComboBoxModels.yearLevelModel);
        comboBox_yearLvl.setBounds(129, 209, 140, 22);
        contentPane.add(comboBox_yearLvl);
        
        comboBox_sem = new JComboBox<>(ComboBoxModels.semesterModel);
        comboBox_sem.setBounds(285, 209, 124, 22);
        contentPane.add(comboBox_sem);
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("Semester:");
        lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1_1_1.setBounds(285, 188, 110, 17);
        contentPane.add(lblNewLabel_1_1_1_1);
    }
}