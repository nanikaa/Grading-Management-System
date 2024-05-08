package database;

import model.user.Student;

public class StudentDataHandler {
	private static Student newStudent;
	
	public static void handleStudentData(String studentNum, String studentFName, String studentLName, String studentEmail) {
		newStudent = new Student(studentNum, studentFName, studentLName, studentEmail);
	}
	
	public static Student getStudentData() {
		return newStudent;
	}
}
