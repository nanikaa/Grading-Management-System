package ui.panels;

import java.awt.*;
import javax.swing.*;

import util.ComboBoxModels;
import util.ResourceLoader;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import database.CreateUser;
import ui.MainFrame.Home;

public class NewUser {

	private JFrame frmEnrollNewUser;
	private JTextField textField_email;
	private JPasswordField passwordField_pass;
	private JTextField textField_firstName;
	private JTextField textField_lastName;
	private JTextField textField_studentNumber;
	private JComboBox<String> comboBox_role;
	
	private String firstName;
	private String lastName;
	private String studentNumber;
	private String email;
	private String password;
	private String role;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUser window = new NewUser();
					window.frmEnrollNewUser.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEnrollNewUser = new JFrame();
		frmEnrollNewUser.setTitle("Enroll New User");
		frmEnrollNewUser.getContentPane().setBackground(new Color(0, 0, 51));
		frmEnrollNewUser.setBounds(100, 100, 440, 550);
		frmEnrollNewUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEnrollNewUser.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New User");
		lblNewLabel.setForeground(new Color(255, 255, 102));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 25, 387, 39);
		frmEnrollNewUser.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Email:");
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2.setBounds(134, 201, 168, 17);
        frmEnrollNewUser.getContentPane().add(lblNewLabel_2);

        // Load the image and create an ImageIcon
        String imagePath = "resources/images/torch.png";
        ImageIcon imageIcon = ResourceLoader.loadImage(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(image);

        // Create a JLabel to hold the image
        JLabel lblImage = new JLabel(scaledImageIcon);
        lblImage.setBackground(Color.BLACK);
        lblImage.setBounds(10, 46, 116, 429);
        frmEnrollNewUser.getContentPane().add(lblImage);
        
        textField_email = new JTextField();
        textField_email.setBounds(134, 220, 225, 20);
        frmEnrollNewUser.getContentPane().add(textField_email);
        textField_email.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Password:");
        lblNewLabel_3.setForeground(Color.WHITE);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_3.setBounds(134, 301, 168, 17);
        frmEnrollNewUser.getContentPane().add(lblNewLabel_3);
        
        passwordField_pass = new JPasswordField();
        passwordField_pass.setColumns(10);
        passwordField_pass.setBounds(134, 323, 225, 20);
        frmEnrollNewUser.getContentPane().add(passwordField_pass);
        
        JLabel lblNewLabel_4 = new JLabel("Role:");
        lblNewLabel_4.setForeground(Color.WHITE);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_4.setBounds(134, 354, 168, 17);
        frmEnrollNewUser.getContentPane().add(lblNewLabel_4);
        
        comboBox_role = new JComboBox<>(ComboBoxModels.userRole);
        comboBox_role.setBounds(134, 375, 225, 22);
        frmEnrollNewUser.getContentPane().add(comboBox_role);
        
        JButton btnNewButton = new JButton("Enroll");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		firstName = textField_firstName.getText();
        		lastName = textField_lastName.getText();
        		studentNumber = textField_studentNumber.getText();
        		email = textField_email.getText();
        		password = new String(passwordField_pass.getPassword());
                role = (String) comboBox_role.getSelectedItem();
                
        		CreateUser.createUser(firstName, lastName, studentNumber, email, password, role);
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnNewButton.setBounds(200, 432, 89, 30);
        frmEnrollNewUser.getContentPane().add(btnNewButton);
        
        JLabel lblNewLabel_6 = new JLabel("First Name:");
        lblNewLabel_6.setForeground(Color.WHITE);
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_6.setBounds(134, 98, 168, 17);
        frmEnrollNewUser.getContentPane().add(lblNewLabel_6);
        
        textField_firstName = new JTextField();
        textField_firstName.setColumns(10);
        textField_firstName.setBounds(134, 120, 225, 20);
        frmEnrollNewUser.getContentPane().add(textField_firstName);
        
        JLabel lblNewLabel_5 = new JLabel("Last Name:");
        lblNewLabel_5.setForeground(Color.WHITE);
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_5.setBounds(134, 151, 168, 17);
        frmEnrollNewUser.getContentPane().add(lblNewLabel_5);
        
        textField_lastName = new JTextField();
        textField_lastName.setColumns(10);
        textField_lastName.setBounds(134, 170, 225, 20);
        frmEnrollNewUser.getContentPane().add(textField_lastName);
        
        textField_studentNumber = new JTextField();
        textField_studentNumber.setColumns(10);
        textField_studentNumber.setBounds(134, 270, 225, 20);
        frmEnrollNewUser.getContentPane().add(textField_studentNumber);
        
        JLabel lblNewLabel_2_1 = new JLabel("Student Number:");
        lblNewLabel_2_1.setForeground(Color.WHITE);
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2_1.setBounds(134, 250, 168, 17);
        frmEnrollNewUser.getContentPane().add(lblNewLabel_2_1);
        
        frmEnrollNewUser.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Home homeFrame = new Home();
                homeFrame.setExtendedState(JFrame.NORMAL);
                homeFrame.setVisible(true);
            }
        });
	}
	
	public JFrame getFrame() {
        return frmEnrollNewUser;
    }
}
