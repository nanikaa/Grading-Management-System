package model.user;

public class Student {
	private String id;
	private String fName;
	private String lName;
    private String email;

    public Student(String id, String firstName, String lastName, String email) {
        this.id = id;
        this.fName = firstName;
        this.lName = lastName;
        this.email = email;
    }	

    // Getters and setters
    public String getStudentID() {
        return id;
    }

    public void setStudentID(String id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return fName;
    }

    public void setFirstName(String firstName) {
        this.fName = firstName;
    }
    
    public String getLastName() {
        return lName;
    }

    public void setLastName(String lastName) {
        this.lName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
