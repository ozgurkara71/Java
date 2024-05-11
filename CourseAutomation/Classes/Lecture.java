package studentOtomation;

import java.util.concurrent.atomic.AtomicInteger;

public class Lecture 
{
	private int lectureID;
	private String lectureName;
	private static final AtomicInteger count = new AtomicInteger(1000);
	
	public int getLectureID() {
		return lectureID;
	}
	public void setLectureID() {
		this.lectureID = count.incrementAndGet() * 10;
	}
	public String getLectureName() {
		return lectureName;
	}
	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}
	//overloaded setter
	public void setLectureID(int ID) {
		this.lectureID = ID;
	}
}
