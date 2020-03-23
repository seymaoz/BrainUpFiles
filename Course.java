import java.util.*;
public class Course {
	private String courseName;
	private String courseNum;
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private ArrayList<ArrayList<Assignment>> assignmentList = new ArrayList<ArrayList<Assignment>>();
	private Professor prof;
	private Syllabus classSyllabus;
	
	Course(){
	}
	
	Course(String courseName, String courseNum, Professor prof){
		this.courseName = courseName;
		this.courseNum = courseNum;
		this.prof = prof;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseNum() {
		return courseNum;
	}

	public void setCourseNum(String courseNum) {
		this.courseNum = courseNum;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

	public ArrayList<ArrayList<Assignment>> getAssignmentList() {
		return assignmentList;
	}

	public void setAssignmentList(ArrayList<ArrayList<Assignment>> assignmentList) {
		this.assignmentList = assignmentList;
	}

	public Professor getProf() {
		return prof;
	}

	public void setProf(Professor prof) {
		this.prof = prof;
	}
	
	public Syllabus getClassSyllabus() {
		return classSyllabus;
	}

	public void setClassSyllabus(Syllabus classSyllabus) {
		this.classSyllabus = classSyllabus;
	}
	/*************************************************************************************/
	
	public void enrollStudent(String studentName){
		for(int i = 0; i < this.studentList.size(); i++){
			if(this.studentList.get(i).getUsername().equals(studentName)){
				System.out.println(studentName + " is already enrolled in " + this.courseName);
				return;
			}
		}
		this.studentList.add(new Student(studentName));
	}
	
	public void dropStudent(String studentName){
		for(int i = 0; i < this.studentList.size(); i++){
			if(this.studentList.get(i).getUsername().equals(studentName)){
				this.studentList.remove(this.studentList.get(i));
				return;
			}
		}
		System.out.println(studentName + " is not in " + this.courseName);
	}
	
	public ArrayList<Assignment> getStudentAssignments(String userStudent){
		ArrayList<Assignment> studentGrades = new ArrayList<Assignment>();
		
		for(int i = 0; i < this.assignmentList.size(); i++){
			
			if(this.assignmentList.get(i).get(0).getAssignmentName().equals(userStudent)){
				for(int j = 0; j < this.assignmentList.get(i).size(); j++){
					
					if(this.assignmentList.get(i).get(j).getStudentName().equals(userStudent)){
						studentGrades.add(this.assignmentList.get(i).get(j));
					}
				}
			}
		}
		
		return studentGrades;
	}
	
	public void gradeAssignment(String userStudent, int grade){
		for(int i = 0; i < this.assignmentList.size(); i++){
			
			if(this.assignmentList.get(i).get(0).getAssignmentName().equals(userStudent)){
				for(int j = 0; j < this.assignmentList.get(i).size(); j++){
					
					if(this.assignmentList.get(i).get(j).getStudentName().equals(userStudent)){
						this.assignmentList.get(i).get(j).setReceivedGrade(grade);
						return;
					}
				}
			}
		}
	}
	
	public void createNewAssignment(String assignmentName, char assignmentType, int maxGrade){
		ArrayList<Assignment> newAssignment = new ArrayList<Assignment>();
		newAssignment.add(new Assignment(assignmentName, assignmentType, maxGrade));
		
		this.assignmentList.add(newAssignment);
	}
	
	public double getStudentGrade(String userStudent){
		double finalGrade = 0, exams = 0, quizzes = 0, HW = 0, labs = 0, other = 0;
		
		ArrayList<Assignment> currStudAssignments = getStudentAssignments(userStudent);
			
		for(int i = 0; i < currStudAssignments.size(); i++){
			switch(this.assignmentList.get(i).get(0).getAssignmentType()){
			case 'F':
				finalGrade += (double)(currStudAssignments.get(i).getReceivedGrade()/currStudAssignments.get(i).getMaxGrade());
			case 'E':
				exams += (double)(currStudAssignments.get(i).getReceivedGrade()/currStudAssignments.get(i).getMaxGrade());
			case 'Q':
				quizzes += (double)(currStudAssignments.get(i).getReceivedGrade()/currStudAssignments.get(i).getMaxGrade());
			case 'L':
				HW += (double)(currStudAssignments.get(i).getReceivedGrade()/currStudAssignments.get(i).getMaxGrade());
			case 'H':
				labs += (double)(currStudAssignments.get(i).getReceivedGrade()/currStudAssignments.get(i).getMaxGrade());
			case 'O':
				other += (double)(currStudAssignments.get(i).getReceivedGrade()/currStudAssignments.get(i).getMaxGrade());
			}
		}
		
		double studGrade = (exams * classSyllabus.getExamWeight()/ classSyllabus.getNumExams()) 
				+ (quizzes * classSyllabus.getQuizWeight() / classSyllabus.getNumQuizes())
				+ (HW * classSyllabus.getHWWeight() / classSyllabus.getNumHW())
				+ (labs * classSyllabus.getLabWeight() / classSyllabus.getNumLabs())
				+ (other * classSyllabus.getOtherWeight() / classSyllabus.getNumOther())
				+ finalGrade * classSyllabus.getFinalWeight();
		
		
		return studGrade;
	}
	
	public double getClassAvg(){
		double sum = 0;
		for(int i = 0; i < this.studentList.size(); i++){
			sum += this.getStudentGrade(this.studentList.get(i).getStudentName());
		}
		
		return sum / this.studentList.size();
	}
}
