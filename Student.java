import java.util.*;
public class Student extends User{
	private ArrayList<Course> courseList = new ArrayList<Course>();
	private double GPA;
	private String studentName;
	
	Student() {
	}
	
	Student(String name){
		this.setUsername(name);
	}
	
	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double gPA) {
		GPA = gPA;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

}
