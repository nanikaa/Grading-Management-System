package ui.panels;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import util.ComboBoxModels;
import util.ResourceLoader;

import java.awt.Color;

public class NewUser {

	private JFrame frmEnrollNewUser;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_3;

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
		frmEnrollNewUser.setBounds(100, 100, 440, 490);
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
        Image image = imageIcon.getImage().getScaledInstance(131, 180, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(image);

        // Create a JLabel to hold the image
        JLabel lblImage = new JLabel(scaledImageIcon);
        lblImage.setBackground(Color.BLACK);
        lblImage.setBounds(0, 11, 131, 429);
        frmEnrollNewUser.getContentPane().add(lblImage);
        
        textField = new JTextField();
        textField.setBounds(134, 220, 225, 20);
        frmEnrollNewUser.getContentPane().add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Password:");
        lblNewLabel_3.setForeground(Color.WHITE);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_3.setBounds(134, 251, 168, 17);
        frmEnrollNewUser.getContentPane().add(lblNewLabel_3);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(134, 273, 225, 20);
        frmEnrollNewUser.getContentPane().add(textField_1);
        
        JLabel lblNewLabel_4 = new JLabel("Role:");
        lblNewLabel_4.setForeground(Color.WHITE);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_4.setBounds(134, 304, 168, 17);
        frmEnrollNewUser.getContentPane().add(lblNewLabel_4);
        
        JComboBox comboBox = new JComboBox<>(ComboBoxModels.userRole);
        comboBox.setBounds(134, 325, 225, 22);
        frmEnrollNewUser.getContentPane().add(comboBox);
        
        JButton btnNewButton = new JButton("Enroll");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnNewButton.setBounds(195, 376, 89, 30);
        frmEnrollNewUser.getContentPane().add(btnNewButton);
        
        JLabel lblNewLabel_6 = new JLabel("First Name:");
        lblNewLabel_6.setForeground(Color.WHITE);
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_6.setBounds(134, 98, 168, 17);
        frmEnrollNewUser.getContentPane().add(lblNewLabel_6);
        
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(134, 120, 225, 20);
        frmEnrollNewUser.getContentPane().add(textField_4);
        
        JLabel lblNewLabel_5 = new JLabel("Last Name:");
        lblNewLabel_5.setForeground(Color.WHITE);
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_5.setBounds(134, 151, 168, 17);
        frmEnrollNewUser.getContentPane().add(lblNewLabel_5);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(134, 170, 225, 20);
        frmEnrollNewUser.getContentPane().add(textField_3);
	}
}
