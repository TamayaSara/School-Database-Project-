/*********************************************
Class: Faculty (chalid class of Employee)
	Fields:
		coursesTaught // an array
		numcoursesTaught
		istenured
	Methods:
		Faculty()
		Faculty(boolean)
		Faculty(String, boolean)
		Faculty(String, int, String, boolen)

		isTenured()
		getNumCoursestaught()
		setIstenured()
		addCourseTaught(Course course) 
		addCoursesTaught(Course[] course)
		getCourseTaught(int index)

		//overrided
		equals()
		toString()
		compareTo()
**********************************************/

import java.lang.*;
import java.util.*;

public class Faculty extends Employee implements Comparable{
	private Course[] coursesTaught;
	private int numCoursesTaught=0;
	private boolean isTenured;
	Faculty next;
	//Constructor
	Faculty() {
		coursesTaught = new Course[100];
		this.numCoursesTaught = 0;
		this.isTenured = false;
	}
	Faculty(boolean isTenured) {
		this.coursesTaught = new Course[100];
		this.numCoursesTaught = 0;
		this.isTenured = isTenured;
	}
	Faculty(String deptName, boolean isTenured) {
		super(deptName);
		this.coursesTaught = new Course[100];
		this.numCoursesTaught = 0;
		this.isTenured = isTenured;
	}
	Faculty(String name, int birthYear, String deptName, boolean isTenured) {
		super(name, birthYear, deptName);
		this.coursesTaught = new Course[100];
		this.numCoursesTaught = 0;
		this.isTenured = isTenured;
	}
	// Return true or false depening on type of faculty
	boolean isTenured() {
		return this.isTenured;
	}
	int getNumCoursesTaught() {
		return numCoursesTaught;
	}
	void setIstenured(boolean isTenured) {
		this.isTenured = isTenured;
	}
	// Method to add a new course to coursesTaught
	void addCourseTaught(Course course) {
		if(numCoursesTaught < 99) {
			coursesTaught[numCoursesTaught++] = course;
		}
		else {
			System.out.println("Course limit crossed, unable to add a new course!");
		}
	}
	void addCoursesTaught(Course[] course) {
		if( course.length <= (99 - numCoursesTaught)) {
			for(int index=0; index < course.length; index++) {
				coursesTaught[numCoursesTaught++] = course[index];
			}
		}
		else {
			System.out.println("No sufficient space to add so much courses!");
		}
	}
	Course getCourseTaught(int index) {
		if(index <= numCoursesTaught) {
			return coursesTaught[index];
		}
		else {
			System.out.println("Invalid Index");
			return null;
		}
	}
	String getCourseTaughtAsString(int index) {
		if(index <= numCoursesTaught) {
			return coursesTaught[index].toString();
		}
		else {
			System.out.println("Invalid Index");
			return "";
		}
	}
	String getAllCoursesTaughtAsString() {
		String courses = "";
		int index=0;
		if(numCoursesTaught > 0) {
		for(index = 0; index < this.numCoursesTaught-1; index++) {
			courses += coursesTaught[index].toString() + ", ";
		} 
		courses += coursesTaught[index].toString();
		}
		return courses;
	}
	/* 
	   Overrided equals() methods checks all fields of the argument object with the invoking object 
	   and returns true if all are equal otherwise returns false 
	*/
	@Override
	public boolean equals(Object obj) {
		Faculty arg = (Faculty) obj; //sfaculty object created
		if((this.name == arg.name) && 
			(this.birthYear == arg.birthYear) && 
			(this.deptName == arg.deptName) && 
			(this.employeeID == arg.employeeID) &&
			(this.numCoursesTaught == arg.numCoursesTaught) &&
			(this.isTenured == arg.isTenured) &&
			(Arrays.deepEquals(this.coursesTaught, arg.coursesTaught))) {
			return true;
		}
		else {
			return false;
		}
	}
	/* 
	   Overrided toString() method returns the string output of content of the object
	   with a desired format 
	*/
	@Override
	public String toString() {
		return super.toString() + String.format(" Faculty: %11s | Number of Courses taught: %3d | Courses Taught %s", isTenured(), numCoursesTaught, getAllCoursesTaughtAsString());
	}
	/* 
	   compareTo() method is overrided and it is implemented from Comparable interface, it isuseful
	   to find if the object position is behind or ahead of the argument object
	*/
	@Override
	public int compareTo(Object obj) {
		Faculty arg = (Faculty) obj;
		if (this.numCoursesTaught > arg.numCoursesTaught) {
			return -1;
		}
		else if(this.numCoursesTaught < arg.numCoursesTaught) {
			return 1;
		}
		else {
			return 0;
		}
		
	}
}