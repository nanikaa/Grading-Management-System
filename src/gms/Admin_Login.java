package gms;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Admin_Login extends JFrame {

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
                    Admin_Login frame = new Admin_Login();
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
    public Admin_Login() {
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

        // Load the image and create an ImageIcon
        ImageIcon imageIcon = new ImageIcon("C:/Users/Jane Martinez Pili/eclipse-workspace/Grading_Management_System/src/img/torch.png");

        // Resize the image to fit the JLabel
        Image image = imageIcon.getImage().getScaledInstance(131, 180, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(image);

        // Create a JLabel to hold the image
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
            	EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            Home frame = new Home(); // Create an instance of Home
                            frame.setVisible(true);  // Make Home visible
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
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
