package ui.panels;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import database.RetrieveStudent;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchStudent extends JFrame {

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
					SearchStudent frame = new SearchStudent();
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
	public SearchStudent() {
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("Search Student");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchStudent = new JLabel("Search Student");
		lblSearchStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchStudent.setForeground(new Color(255, 255, 102));
		lblSearchStudent.setFont(new Font("Arial Narrow", Font.BOLD, 22));
		lblSearchStudent.setBounds(10, 30, 414, 31);
		contentPane.add(lblSearchStudent);
		
		JLabel lblNewLabel_2 = new JLabel("Student Number:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(45, 95, 168, 17);
		contentPane.add(lblNewLabel_2);
		
		textField_studentNum = new JTextField();
		textField_studentNum.setBounds(45, 118, 343, 20);
		contentPane.add(textField_studentNum);
		textField_studentNum.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentID = textField_studentNum.getText();
				RetrieveStudent.searchActionPerformed(studentID);
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSearch.setBounds(299, 184, 89, 31);
		contentPane.add(btnSearch);
	}
}
