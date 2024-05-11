package alll;

public class last {
	//Student
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
	
	//Lecture
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
	
	//MainPage
	//typedef info: OZGUR KARA/21 - 22/CRAM SCHOOL OTOMATION
	//31/12/22 01.26 Friday

	package studentOtomation;

	import java.util.ArrayList;
	import java.util.Scanner;
	import java.util.StringTokenizer;

	//import javax.swing.plaf.basic.BasicSplitPaneDivider;

	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;

	public class MainPage 
	{
		static Scanner kb = new Scanner(System.in);
		public static void main(String[] args) 
		{
			ArrayList<Student> Students = new ArrayList<Student>();
			ArrayList<Lecture> Lectures = new ArrayList<Lecture>();
			File learners = new File("student.txt");
			File lessons = new File("lecture.txt");
			int choosen;
			startOfFile(learners, lessons, Lectures, Students);
			while(1 == 1)
			{
				System.out.println("--------------------- Main Menu -----------------------");
				System.out.println("1 - Add Lecture\n2 - Display Lecture\n3 - Search Lecture\n4 - Delete Lecture\n5 - Add Student\n6 - Search Student\n"
						+ "7 - Delete Student\n8 - Display Student\n9 - Dislay Students in Detail\n10 - Calculate Cost Which Students Will Pay\n"
						+ "11 - Exit");
				System.out.println("Enter your choice: ");
				choosen = kb.nextInt();
				if(choosen ==  1)
				{
					addLecture(Lectures);
				}
				else if(choosen == 2)
				{
					displayLecture(Lectures);
				}
				else if(choosen == 3)
				{
					searchLecture(Lectures);
				}
				if(choosen == 4)
				{
					deleteLecture(Lectures, Students);
				}
				else if(choosen == 5)
				{
					addStudent(Lectures, Students);
				}
				else if(choosen == 6)
				{
					searchStudent(Students);
				}
				else if(choosen == 7)
				{
					deleteStudent(Students);
				}
				else if(choosen == 8)
				{
					displayStudent(Students);
				}
				else if(choosen == 9)
				{
					detailedDisplay(Lectures, Students);
				}
				else if(choosen == 10)
				{
					calculateCost(Students);
				}
				else if(choosen == 11)
				{
					writeToStudentFile(Students);
					writeToLectureFile(Lectures);
					break;
				}
				else
				{
					//System.out.println("Wrong keystroke! Try again.");
				}
			}	
			
		}
		
		static void startOfFile(File learners, File lessons, ArrayList<Lecture> Lectures, ArrayList<Student> Students)//This function opens a file if file doesn't exists. 
		//Else, saves ingredients of file and clears it to next data input.
		{
			String line;
			String[] parts;
			try
			{
				if(!learners.exists())
				{
					learners.createNewFile();
				}
				else
				{
					FileReader stdRd = new FileReader("student.txt");
					BufferedReader bstdRd = new BufferedReader(stdRd);
					line = bstdRd.readLine();
					Student studentFromFile = null;//we set it null beacuse we don't want to error(may not have been initialized) in else
					while(line != null)
					{
						if(line.startsWith("+"))//enter if line starts with "+"
						{
							studentFromFile = new Student();
							parts = line.split("\\+");
							parts = parts[1].split("\\%");
							studentFromFile.setStudentID(Integer.parseInt(parts[0]));
							studentFromFile.setStudentNameSurname(parts[1]);
							studentFromFile.setStudentAge(Integer.parseInt(parts[2]));
							Students.add(studentFromFile);
						}
						else
						{
							Lecture lectureFromStudentFile = new Lecture();
							parts = line.split("\\*");
							parts = parts[1].split("\\%");
							lectureFromStudentFile.setLectureID(Integer.parseInt(parts[0]));//sends this parameter to overloaded setter method
							lectureFromStudentFile.setLectureName(parts[1]);
							studentFromFile.lecturesRecieved.add(lectureFromStudentFile);//it is mistake that we declare this obj inside if. we can't 
							//use it inside else. because of that we will declare outside of if and we will set it in if.
						}
						line = bstdRd.readLine();
					}
					stdRd.close();
					bstdRd.close();
				}
					
				if(!lessons.exists())
				{
					lessons.createNewFile();
				}
				else
				{
					FileReader lctRd = new FileReader("lecture.txt");
					BufferedReader blctRd = new BufferedReader(lctRd);
					while(blctRd.ready())
					{
						line = blctRd.readLine();
						parts = line.split("\\%");
						Lecture lectureFromFile = new Lecture();
						lectureFromFile.setLectureID();
						lectureFromFile.setLectureName(parts[1]);
						Lectures.add(lectureFromFile);
					}
					lctRd.close();
					blctRd.close();
				}
				
			}
			catch(IOException error)
			{
				error.printStackTrace();
			}
		}
		
		static void addLecture(ArrayList<Lecture> Lectures)
		{
			System.out.println("-------------------- Adding Screen ---------------------");
			Lecture lectureToAdd = new Lecture();
			lectureToAdd.setLectureID();
			System.out.println("Enter name of lecture: ");
			lectureToAdd.setLectureName(kb.next());
			Lectures.add(lectureToAdd);
			//writeToLectureFile(Lectures);
		}
		
		static void displayLecture(ArrayList<Lecture> Lectures)
		{
			System.out.println("------------------ Displaying Screen ------------------");
			int control = 0;
			
			for(Lecture lecture : Lectures)
			{
				if(control == 0)
				{
					System.out.println("Lecture ID    Lecture Name");
					control++;
				}
				System.out.println(lecture.getLectureID() + "         " + lecture.getLectureName());
			}
		}
		
		static void writeToLectureFile(ArrayList<Lecture> Lectures)
		{
			try
			{
				FileWriter lctWrt = new FileWriter("lecture.txt");
				BufferedWriter blctWrt = new BufferedWriter(lctWrt);
				blctWrt.write("");//clears the file
				for(Lecture lecture : Lectures)
					blctWrt.write(lecture.getLectureID() + "%" + lecture.getLectureName() + "\n");
				blctWrt.flush();
				blctWrt.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		static void searchLecture(ArrayList<Lecture> Lectures)
		{
			System.out.println("------------------ Searching Screen -------------------");
			int searchControl = 0;
			String lectureToDisplay;
			
			System.out.println("Enter name of the lecture that you want to display: ");
			lectureToDisplay = kb.next();
			for(Lecture lecture : Lectures)
			{
				if(lecture.getLectureName().equals(lectureToDisplay))
				{
					System.out.println("Lecture ID    Lecture Name");
					System.out.println(lecture.getLectureID() + "         " + lecture.getLectureName());
					searchControl++;
					break;
				}
			}
			if(searchControl == 0)
			{
				System.out.println("Lecture name is false or lecture doesn't exist.");
			}
		}
		
		static void deleteLecture(ArrayList<Lecture> Lectures, ArrayList<Student> Students)
		{
			System.out.println("------------------ Deleting Screen --------------------");
			int deleteIndex = 0;
			String lectureToDelete;
			
			System.out.println("Enter name of the lecture that you want to delete: ");
			lectureToDelete = kb.next();
			for(Student student : Students)
			{
				for(Lecture lectures : student.lecturesRecieved)
				{
					if(lectures.getLectureName().equals(lectureToDelete))
					{
						System.out.println("Student(s) taking this lecture. You can not delete.");
						return;
					}
				}
			}
			for(Lecture lecture : Lectures)
			{
				if(lecture.getLectureName().equals(lectureToDelete))
				{
					Lectures.remove(deleteIndex);
					return;
				}
				deleteIndex++;
			}
			System.out.println("Wrong keystroke! Try again.");
			
		}
		
		static void addStudent(ArrayList<Lecture> Lectures, ArrayList<Student> Students)
		{
			System.out.println("-------------------- Adding Screen ---------------------");
			int count, addControl, index4ID = 0, ID;
			String lessonName;
			
			Student newOne = new Student();
			System.out.println("Enter student ID: ");
			ID = kb.nextInt();
			while(1 == 1)
			{
				addControl = 0;
				for(Student student : Students)
				{
					if(student.getStudentID() == ID)
					{
						System.out.println("This ID has already been entered. Enter different value: ");
						ID = kb.nextInt();
						addControl = 1;
					}
				}
				if(addControl == 0)
				{
					newOne.setStudentID(ID);
					break;
				}
			}
			System.out.println("Enter student name and surname(be careful about space char.): ");
			newOne.setStudentNameSurname(kb.next());
			System.out.println("Enter student age: ");
			newOne.setStudentAge(kb.nextInt());
			System.out.println("Enter how many lectures you will save for this student: ");
			count = kb.nextInt();
			for(int i = 1; i < count + 1; i++)
			{
				Lecture lesson = new Lecture();
				System.out.println("Enter " + i + ". lesson's name: ");
				lessonName = kb.next();
				for(Lecture lecture : Lectures)
				{
					if(lecture.getLectureName().equals(lessonName))
					{
						lesson.setLectureID(lecture.getLectureID());
						
					}
				}
				lesson.setLectureName(lessonName);
				newOne.lecturesRecieved.add(lesson);
			}
			Students.add(newOne);
		}
		
		static void displayStudent(ArrayList<Student> Students)
		{
			System.out.println("------------------ Displaying Screen ------------------");
			
			System.out.println("Displaying all students (ID Name Surname Age)");
			for(Student student : Students)
			{
				System.out.println(student.getStudentID() + " " + student.getStudentNameSurname() + " " + student.getStudentAge());
			}
		}
		
		static void detailedDisplay(ArrayList<Lecture> Lectures, ArrayList<Student> Students)
		{
			System.out.println("------------------ Displaying Screen ------------------");
			
			System.out.println("Displaying all students and lectures they have registered"
					+ " (ID Name Surname Age)\n"
					+ "                                                             (ID Lesson)");
			for(Student student : Students)
			{
				System.out.println(student.getStudentID() + " " + student.getStudentNameSurname() + " " + student.getStudentAge());
				for(Lecture lecture : student.lecturesRecieved)
				{
					System.out.println("     " + lecture.getLectureID() + " " + lecture.getLectureName());
				}
			}
		}
		
		static void searchStudent(ArrayList<Student> Students)
		{
			System.out.println("------------------ Searching Screen -------------------");
			String studentToDisplay;
			
			System.out.println("Enter name and surname of student who you want to display: ");
			studentToDisplay = kb.next();
			for(Student student : Students)
			{
				if(student.getStudentNameSurname().equals(studentToDisplay))
				{
					System.out.println(student.getStudentID() + " " + student.getStudentNameSurname() + " " + student.getStudentAge());
					for(Lecture lecture : student.lecturesRecieved)
					{
						System.out.println("     " + lecture.getLectureID() + " " + lecture.getLectureName());
					}
					return;
				}
			}
			System.out.println("Student could not find!");
		}
		
		static void deleteStudent(ArrayList<Student> Students)
		{
			System.out.println("------------------ Deleting Screen --------------------");
			int deleteIndex = 0, deleteID;
			
			System.out.println("Enter ID of student who you want to delete: ");
			deleteID = kb.nextInt();
			for(Student student : Students)
			{
				if(student.getStudentID() == deleteID)
				{
					Students.remove(deleteIndex);
					return;
				}
				deleteIndex++;
			}
			System.out.println("Student could not find!");
		}
		
		static void writeToStudentFile(ArrayList<Student> Students)
		{
			try
			{
			FileWriter stdWrt = new FileWriter("student.txt");
			BufferedWriter bstdWrt = new BufferedWriter(stdWrt);
			bstdWrt.write("");//clears the student file
			for(Student student : Students)
			{
				bstdWrt.write("+" + student.getStudentID() + "%" + student.getStudentNameSurname() + "%" + student.getStudentAge() + "\n");
				for(Lecture lecture : student.lecturesRecieved)
				{
					bstdWrt.write("*" + lecture.getLectureID() + "%" + lecture.getLectureName() + "\n");
				}
			}
			bstdWrt.flush();
			bstdWrt.close();
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		static void calculateCost(ArrayList<Student> Students)
		{
			System.out.println("----------------- Calculating Screen ------------------");
			int calculateID, costPerLecture = 400;
			double totCost = 0.0;
			
			System.out.println("Offers: ");
			System.out.println("Offer 1: For students who has got 2 lectures. Applies %5 discount to second lesson's price.");
			System.out.println("Offer 2: For students who has got 3 lectures. Applies %15 discount to third lesson's price.");
			System.out.println("Offer 3: For students who has got at least 4 lectures. Applies %10 discount to all lessons's price.");
			System.out.println("Cost per lecture for a month: 400 national currencies.");
			System.out.println("Enter ID of student who you want to calculate cost that (s)he will pay to cram school: ");
			calculateID = kb.nextInt();
			for(Student student : Students)
			{
				if(student.getStudentID() == calculateID)
				{
					if(student.lecturesRecieved.size() == 2)
					{
						totCost = costPerLecture + costPerLecture * 0.95;
						System.out.println("Offer 1 applied to this student. Cost per month: " + totCost + " national currencies.");
					}
					else if(student.lecturesRecieved.size() == 3)
					{
						totCost = 2 * costPerLecture + costPerLecture * 0.85;
						System.out.println("Offer 2 applied to this student. Cost per month: " + totCost + " national currencies.");
					}
					else if(student.lecturesRecieved.size() > 3)
					{
						totCost = (student.lecturesRecieved.size() * costPerLecture) * 0.90;
						System.out.println("Offer 3 applied to this student. Cost per month: " + totCost + " national currencies.");
					}
					else if(student.lecturesRecieved.size() == 1)
					{
						totCost = costPerLecture;
						System.out.println("Can not apply offer to students who has one lecture. Cost per month: " + totCost + " national currencies.");
					}
					return;
				}
			}
			System.out.println("Wrong keystroke! Try again.");
		}
		
	}

}
