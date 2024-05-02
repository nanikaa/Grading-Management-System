package util;

import javax.swing.DefaultComboBoxModel;

public class ComboBoxModels {
	public static DefaultComboBoxModel<String> yearLevelModel;
    public static DefaultComboBoxModel<String> semesterModel;
    public static DefaultComboBoxModel<String> courseCodeModel;

    static {
        yearLevelModel = new DefaultComboBoxModel<>(new String[]{"1st Year", "2nd Year", "3rd Year", "4th Year", "5th Year", "6th Year", "7th Year", "Summer Midyear"});
        semesterModel = new DefaultComboBoxModel<>(new String[]{"1st Semester", "2nd Semester"});
    }
}
