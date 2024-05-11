package studentOtomation;

import java.util.ArrayList;

public class Student 
{
	private int studentID;
	private String studentNameSurname;
	private int studentAge;
	public ArrayList<Lecture> lecturesRecieved = new ArrayList<Lecture>();
	
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getStudentNameSurname() {
		return studentNameSurname;
	}
	public void setStudentNameSurname(String studentNameSurname) {
		this.studentNameSurname = studentNameSurname;
	}
	public int getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
}
