/* Priyanka Patel
 * CS 356
 * Due: 07/05/2017
 */
public class Student {
	//different student Id to keep difference between students
	private String studentID; 
	// constructor
	public Student(String ID) { 
		this.setStudentID(ID);
	}
	// accessor methods
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
}