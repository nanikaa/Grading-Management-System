package util;

import javax.swing.DefaultComboBoxModel;

import database.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ComboBoxModels {
    public static DefaultComboBoxModel<String> yearLevelModel;
    public static DefaultComboBoxModel<String> semesterModel;
    public static DefaultComboBoxModel<String> courseCodeModel;
    public static DefaultComboBoxModel<String> tableViews;
    public static DefaultComboBoxModel<String> userRole;

    static {
        yearLevelModel = new DefaultComboBoxModel<>(new String[]{"1st Year", "2nd Year", "3rd Year", "Summer Midyear", "4th Year", "5th Year", "6th Year", "7th Year"});
        semesterModel = new DefaultComboBoxModel<>(new String[]{"1st Semester", "2nd Semester"});
        userRole = new DefaultComboBoxModel<>(new String[]{"Student", "Admin"});
        courseCodeModel = new DefaultComboBoxModel<>();
        loadCourseCodesFromDatabase();
    }

    private static void loadCourseCodesFromDatabase() {
        String sql = "SELECT id_course FROM course";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                courseCodeModel.addElement(rs.getString("id_course"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error loading course codes from database: " + e.getMessage());
        }
    }
}
