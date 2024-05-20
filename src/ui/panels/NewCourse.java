package ui.panels;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import database.*;
import util.ResourceLoader;
import javax.swing.JTextField;

public class NewCourse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblImage;
    private JButton btnSave;
    private JTextField textField_title;
    private JTextField textField_courseCode;
    private JTextField textField_units;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCourse frame = new NewCourse();
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
	public NewCourse() {
		setTitle("Add New Course");
		setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 520, 350);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 51));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("New Course");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(new Color(255, 255, 102));
        lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 24));
        lblNewLabel.setBounds(129, 27, 245, 31);
        contentPane.add(lblNewLabel);

        JLabel lblNew = new JLabel("Course Title:");
        lblNew.setForeground(Color.WHITE);
        lblNew.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNew.setBounds(129, 97, 168, 17);
        contentPane.add(lblNew);

        JLabel lblNewLabel_3 = new JLabel("Course Code:");
        lblNewLabel_3.setForeground(Color.WHITE);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_3.setBounds(129, 150, 190, 17);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Units:");
        lblNewLabel_4.setForeground(Color.WHITE);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_4.setBounds(358, 150, 76, 17);
        contentPane.add(lblNewLabel_4);
        
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
        
        textField_title = new JTextField();
        textField_title.setBounds(129, 119, 315, 20);
        contentPane.add(textField_title);
        textField_title.setColumns(10);
        
        textField_courseCode = new JTextField();
        textField_courseCode.setBounds(129, 171, 190, 20);
        contentPane.add(textField_courseCode);
        textField_courseCode.setColumns(10);
        
        textField_units = new JTextField();
        textField_units.setBounds(358, 171, 86, 20);
        contentPane.add(textField_units);
        textField_units.setColumns(10);
        
        btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String courseTitle = textField_title.getText();
        		String courseCode = textField_courseCode.getText();
        		int courseUnits = Integer.parseInt(textField_units.getText());
        		
        		CreateCourse.createCourse(courseTitle, courseCode, courseUnits);
        	}
        });
        btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnSave.setBounds(245, 230, 89, 31);
        contentPane.add(btnSave);
	}
}
