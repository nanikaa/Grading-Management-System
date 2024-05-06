package ui.MainFrame;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class StudentView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable firstYear1;
	private JTable firstYear2;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentView frame = new StudentView();
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
	public StudentView() {
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 539);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Student Number:");
		lblNewLabel_1.setForeground(new Color(245, 255, 250));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1.setBounds(41, 42, 145, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lbl_StudentNum = new JLabel((String) null);
		lbl_StudentNum.setForeground(Color.WHITE);
		lbl_StudentNum.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_StudentNum.setBounds(196, 43, 185, 14);
		contentPane.add(lbl_StudentNum);
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setForeground(new Color(245, 255, 250));
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_2.setBounds(41, 68, 145, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lbl_Name = new JLabel((String) null);
		lbl_Name.setForeground(Color.WHITE);
		lbl_Name.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_Name.setBounds(196, 69, 185, 14);
		contentPane.add(lbl_Name);
		
		JLabel lblNewLabel_3 = new JLabel("1st Year - 1st Semester");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setForeground(new Color(245, 255, 250));
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_3.setBounds(41, 143, 209, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("GWA:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setForeground(new Color(245, 255, 250));
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_4.setBounds(240, 143, 53, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lbl_firstSemGWA1 = new JLabel("");
		lbl_firstSemGWA1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_firstSemGWA1.setForeground(new Color(245, 255, 250));
		lbl_firstSemGWA1.setFont(new Font("Dialog", Font.BOLD, 14));
		lbl_firstSemGWA1.setBounds(287, 143, 53, 14);
		contentPane.add(lbl_firstSemGWA1);
		
		JLabel lblNewLabel_5 = new JLabel("1st Year - 2nd Semester");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setForeground(new Color(245, 255, 250));
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_5.setBounds(382, 143, 209, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("GWA:");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6.setForeground(new Color(245, 255, 250));
		lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_6.setBounds(581, 143, 53, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lbl_firstSemGWA2 = new JLabel("");
		lbl_firstSemGWA2.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_firstSemGWA2.setForeground(new Color(245, 255, 250));
		lbl_firstSemGWA2.setFont(new Font("Dialog", Font.BOLD, 14));
		lbl_firstSemGWA2.setBounds(628, 143, 53, 14);
		contentPane.add(lbl_firstSemGWA2);
		
		firstYear1 = new JTable();
		firstYear1.setBounds(41, 168, 299, 194);
		contentPane.add(firstYear1);
		
		firstYear2 = new JTable();
		firstYear2.setBounds(382, 168, 299, 194);
		contentPane.add(firstYear2);
	}
}
