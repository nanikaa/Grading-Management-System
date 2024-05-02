package gms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class AddRecord extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_studentNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRecord frame = new AddRecord();
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
	public AddRecord() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 338);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setForeground(new Color(0, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Record");
		lblNewLabel.setForeground(new Color(255, 255, 102));
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 29, 304, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student Number:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(40, 87, 168, 17);
		contentPane.add(lblNewLabel_1);
		
		textField_studentNum = new JTextField();
		textField_studentNum.setBounds(40, 109, 245, 20);
		contentPane.add(textField_studentNum);
		textField_studentNum.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Course Code");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(40, 140, 168, 17);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Marks:");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(222, 140, 63, 17);
		contentPane.add(lblNewLabel_1_2);
		
		JComboBox comboBox_courseCode = new JComboBox();
		comboBox_courseCode.setBounds(40, 161, 168, 22);
		contentPane.add(comboBox_courseCode);
		
		JComboBox comboBox_marks = new JComboBox();
		comboBox_marks.setBounds(222, 161, 63, 22);
		contentPane.add(comboBox_marks);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(119, 225, 89, 31);
		contentPane.add(btnNewButton);
	}
}
