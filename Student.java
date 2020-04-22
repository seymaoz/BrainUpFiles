// lastly upgraded 
import java.util.*;
public class Student extends User{
	private ArrayList<Course> courseList = new ArrayList<Course>();
	private double GPA;
	private String studentName;
	
	Student() {
	}
	
	//All of the getters & setters 
	
	//to get the Student name
	Student(String name){
		this.setUsername(name);
	}
	
	// to get the courselist from ArrayList<Course>
	public ArrayList<Course> getCourseList() {
		return courseList;
	}
	
	// to get the courselist from course's ArrayList
	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}
	
	//to get the GPA (as double)
	public double getGPA() {
		return GPA;
	}
	
	//to set the GPA with passing gPA
	public void setGPA(double gPA) {
		GPA = gPA;
	}

	//to get the studentName
	public String getStudentName() {
		return studentName;
	}

	//to set the studentName
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

}
