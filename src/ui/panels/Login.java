package ui.panels;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import database.LoginHandler;
import util.ResourceLoader;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField_email;
    private JTextField textField_password;
    private JLabel lblImage;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
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
    public Login() {
    	setResizable(false);
        setAlwaysOnTop(true);
        setTitle("Admin Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 360);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 51));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        String imagePath = "resources/images/torch.png";
        ImageIcon imageIcon = ResourceLoader.loadImage(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(131, 180, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(image);

        lblImage = new JLabel(scaledImageIcon);
        lblImage.setBackground(Color.BLACK);
        lblImage.setBounds(10, 30, 99, 280);
        contentPane.add(lblImage);

        JLabel lblNewLabel = new JLabel("Email:");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel.setBounds(113, 110, 93, 14);
        contentPane.add(lblNewLabel);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setForeground(new Color(255, 255, 255));
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPassword.setBounds(113, 159, 93, 14);
        contentPane.add(lblPassword);

        textField_email = new JTextField();
        textField_email.setBounds(113, 128, 260, 20);
        contentPane.add(textField_email);
        textField_email.setColumns(10);

        textField_password = new JTextField();
        textField_password.setColumns(10);
        textField_password.setBounds(113, 176, 260, 20);
        contentPane.add(textField_password);

        JButton btn_Login = new JButton("Login");
        btn_Login.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String email = textField_email.getText();
                String password = textField_password.getText();
                LoginHandler.loginActionPerformed(Login.this, email, password);
        	}
        });
        btn_Login.setBounds(200, 226, 89, 23);
        contentPane.add(btn_Login);

        
        JLabel lblNewLabel_1 = new JLabel("BICOL UNIVERSITY - COLLEGE OF SCIENCE");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(10, 26, 414, 31);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("INFORMATION TECHNOLOGY DEPARTMENT");
        lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 11));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setForeground(new Color(255, 255, 51));
        lblNewLabel_2.setBounds(10, 54, 414, 14);
        contentPane.add(lblNewLabel_2);
    }
}
