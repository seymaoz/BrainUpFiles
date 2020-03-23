
public class Assignment {
	private int receivedGrade;
	private int maxGrade;
	private String assignmentName;
	private char assignmentType;
	private String studentName;
	
	Assignment(){
	}
	
	Assignment(String assignmentName, char assignmentType, int maxGrade){
		this.assignmentName = assignmentName;
		this.assignmentType = assignmentType;
		this.maxGrade = maxGrade;
	}

	public int getReceivedGrade() {
		return receivedGrade;
	}

	public void setReceivedGrade(int receivedGrade) {
		this.receivedGrade = receivedGrade;
	}

	public int getMaxGrade() {
		return maxGrade;
	}

	public void setMaxGrade(int maxGrade) {
		this.maxGrade = maxGrade;
	}

	public String getAssignmentName() {
		return assignmentName;
	}

	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}

	public char getAssignmentType() {
		return assignmentType;
	}

	public void setAssignmentType(char assignmentType) {
		this.assignmentType = assignmentType;
	}
	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public Assignment makeStudentAssignment(Assignment origAssignment, String studentName){
		if(origAssignment == null){
			return null;
		}
		
		Assignment studentAssignment = new Assignment(
				origAssignment.getAssignmentName(),
				origAssignment.getAssignmentType(),
				origAssignment.getMaxGrade());
		studentAssignment.setStudentName(studentName);
		
		return studentAssignment;
	}
}
