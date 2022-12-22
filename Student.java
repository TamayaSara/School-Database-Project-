/*********************************************
Class: Student
	Fields:
	Methods:
**********************************************/

import java.lang.*;
import java.util.*;

public class Student extends Person implements Comparable {
	private static int numStudents;
	private int studentID;
	private Course[] coursesTaken;
	private int numCoursesTaken;
	private boolean isGraduate;
	private String major="undeclared";
	Student next;
	Student() {
		coursesTaken = new Course[50];
		this.numCoursesTaken = 0;
		this.isGraduate = false;
		this.studentID=++numStudents;
	}
	Student(boolean isGraduate) {
		coursesTaken = new Course[50];
		this.numCoursesTaken = 0;
		this.isGraduate = isGraduate;
		this.studentID=++numStudents;
	}
	Student(String major, boolean isGraduate) {
		coursesTaken = new Course[50];
		this.numCoursesTaken = 0;
		this.isGraduate = isGraduate;
		this.major = major;
		this.studentID=++numStudents;
	}
	Student(String name, int birthYear, String major, boolean isGraduate) {
		super(name, birthYear);
		coursesTaken = new Course[50];
		this.numCoursesTaken = 0;
		this.isGraduate = isGraduate;
		this.major = major;
		this.studentID=++numStudents;
	}
	boolean isGraduate() {
		return this.isGraduate;
	}
	int getNumCoursesTaken() {
		return numCoursesTaken;
	}
	static int getNumStudents() {
		return numStudents;
	}
	int getStudentID() {
		return studentID;
	}
	String getMajor() {
		return major;
	}
	void setIsGraduate(boolean isGraduate) {
		this.isGraduate = isGraduate;
	}
	void setMajor(String major) {
		this.major = major;
	}
	void addCourseTaken(Course course) {
		if(numCoursesTaken < 49) {
			coursesTaken[numCoursesTaken++] = course;
		}
		else {
			System.out.println("Maximum course are already taken, a new course cannot be added!");
		}
	}
	void addCoursesTaken(Course[] course) {
		
		if (course.length <= (49 - numCoursesTaken)) {
			for(int index = 0; index <course.length; index++) {
				coursesTaken[numCoursesTaken++] = course[index];
			}
		}
		else {
			System.out.println("Insufficinet space to add so many courses!");
		}
	}
	Course getCourseTaken(int index) {
		if(index <= numCoursesTaken) {
			return coursesTaken[index];
		}
		else {
			System.out.println("Invalid Index!");
			return null;
		}
	}
	String getCourseTakenAsString(int index) {
		if(index <= numCoursesTaken) {
			return coursesTaken[index].toString();
		}
		else {
			System.out.println("Invalid Index!");
			return "";
		}
	}
	String getAllCoursesTakenAsString() {
		String str="";
		int index=0;
		if (numCoursesTaken > 0) {
		for(index=0; index < numCoursesTaken-1; index++) {
			str += coursesTaken[index].toString() + ", ";	
		}
		str += coursesTaken[index].toString();
		}
		return str;
	}
	@Override
	public boolean equals(Object obj) {
		Student arg = (Student) obj;
		if ((this.name.equals(arg.name)) && 
		    (this.birthYear == arg.birthYear) &&
		    (this.studentID == arg.studentID) &&
		    (this.numCoursesTaken == arg.numCoursesTaken) &&
		    (this.isGraduate ==  arg.isGraduate) &&
		    (this.major.equals(arg.major)) &&
		    (Arrays.deepEquals(this.coursesTaken, arg.coursesTaken)) ) {
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public String toString() {
		String gradFlag="";
		if (isGraduate) gradFlag="Graduate";
		else gradFlag="Undergraduate";
			
		return super.toString() + String.format("Student: studentID: %04d | Major %20s | %14s | Number of Courses Taken: %3d | Courses Taken: %s", studentID, major, gradFlag, numCoursesTaken, getAllCoursesTakenAsString());
	}
	@Override
	public int compareTo(Object obj) {
		Student arg = (Student) obj;
		int nCreditHost = 0;
		int nCreditArg = 0;
		int index;
		for(index = 0; index < this.coursesTaken.length; index++) {
			nCreditHost += this.coursesTaken[index].getNumCredits();
		}
		for(index = 0; index < arg.coursesTaken.length; index++) {
			nCreditArg += arg.coursesTaken[index].getNumCredits();
		}
		if(nCreditHost < nCreditHost) {
			return 1;
		}
		else if (nCreditHost > nCreditHost) {
			return -1;
		}
		else {
			return 0;
		}
	}
}