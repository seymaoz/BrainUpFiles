import java.util.*;
public class Professor extends User{
	private ArrayList<Course> courses = new ArrayList<Course>();
	private String profName;
	
	Professor() {
	}
	
	Professor(String profName){
		this.profName = profName;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	public String getProfName() {
		return profName;
	}

	public void setProfName(String profName) {
		this.profName = profName;
	}
}
