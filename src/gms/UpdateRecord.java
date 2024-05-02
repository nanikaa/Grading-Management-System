package gms;

import javax.swing.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.util.DnsSrv.SrvRecord;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class UpdateRecord extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblImage;
    private JButton updateBtn;
    private static JTextField textField_studentNum;
    private static JTextField textField_marks;
    private static JComboBox<String> comboBox_courseCode;
    
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
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 364);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 51));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Update Record");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(new Color(255, 255, 102));
        lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 22));
        lblNewLabel.setBounds(10, 27, 414, 31);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Student Number:");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setBounds(129, 81, 168, 17);
        contentPane.add(lblNewLabel_1);

        textField_studentNum = new JTextField(studentNum);
        textField_studentNum.setColumns(10);
        textField_studentNum.setBounds(129, 103, 245, 20);
        contentPane.add(textField_studentNum);
        
        textField_marks = new JTextField(studentMarks);
        textField_marks.setColumns(10);
        textField_marks.setBounds(311, 155, 63, 22);
        contentPane.add(textField_marks);

        JLabel lblNewLabel_1_1 = new JLabel("Course Code");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1.setBounds(129, 134, 168, 17);
        contentPane.add(lblNewLabel_1_1);

        comboBox_courseCode = new JComboBox();
        comboBox_courseCode.setBounds(129, 155, 168, 22);
        contentPane.add(comboBox_courseCode);

        JLabel lblNewLabel_1_2 = new JLabel("Marks:");
        lblNewLabel_1_2.setForeground(Color.WHITE);
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2.setBounds(311, 134, 63, 17);
        contentPane.add(lblNewLabel_1_2);

        updateBtn = new JButton("Update");
        updateBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
        updateBtn.setBounds(208, 207, 89, 31);
        contentPane.add(updateBtn);

        // Load the image and create an ImageIcon
        ImageIcon imageIcon = new ImageIcon("C:/Users/Jane Martinez Pili/eclipse-workspace/Grading_Management_System/src/img/torch.png");

        // Resize the image to fit the JLabel
        Image image = imageIcon.getImage().getScaledInstance(131, 180, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(image);

        // Create a JLabel to hold the image
        lblImage = new JLabel(scaledImageIcon);
        lblImage.setBackground(Color.BLACK);
        lblImage.setBounds(0, 27, 124, 275);
        contentPane.add(lblImage);

        JButton btnNewButton_1 = new JButton("Delete this record.");
        btnNewButton_1.setForeground(new Color(204, 0, 0));
        btnNewButton_1.setBackground(new Color(0, 0, 51));
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnNewButton_1.setBounds(34, 277, 151, 20);
        contentPane.add(btnNewButton_1);
    }
}