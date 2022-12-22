/*********************************************
Class: Course
	Fields: 
		isGraduateCourse
		courseNum
		courseDept
		numCredits
	Methods:
		Course(boolean, int, String, int)
		isGraduateCourse()
		getCourseNum()
		getCourseDept()
		getNumCredits()
		getCoursename()
		
		//Overrided methods
		equals()
		toString()
		compareTo()
**********************************************/

import java.lang.*;
import java.util.*;

public class Course implements Comparable {
	//Fields
	private boolean isGraduateCourse;
	private int courseNum;
	private String courseDept;
	private int numCredits;
	Course next;
	// Constructor
	Course(boolean isGraduate, int cNum, String cDept, int nCredits) {
		isGraduateCourse = isGraduate;
		courseNum = cNum;
		courseDept = cDept;
		numCredits = nCredits;
	}
	// Returns true/false depending upon whether course is graduate or undergraduate
	boolean isGraduateCourse() {
		return isGraduateCourse;
	}
	// Returns course number
	int getCourseNum() {
		return courseNum;
	}
	// Returns Course department
	String getCourseDept() {
		return courseDept;
	}
	// Returns total credits
	int getNumCredits() {
		return numCredits;
	}
	// Returns course name
	String getCourseName() {
		if (isGraduateCourse) {
			return "G" + courseDept+courseNum;
		}
		else {
			return "U" + courseDept+courseNum;
		}
	}
	/* 
	   Overrided equals() methods checks
	   All fields of the argument object with the invoking object and returns true if all
	   are equal otherwise returns false 
	*/
	@Override
	public boolean equals(Object obj) {
		Course arg = (Course) obj;
		if ((this.isGraduateCourse == arg.isGraduateCourse) && 
			(this.courseNum == arg.courseNum) &&
			(this.numCredits == arg.numCredits) &&
			(this.courseDept.equals(arg.courseDept))) {
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
		String cType;
		if (isGraduateCourse) cType = "Graduate";
		else cType = "Undergraduate";

		return String.format("Course: %3s-%3d | Number of Credits: %02d | "+cType, courseDept, courseNum, numCredits);
	}
	/* 
	   compareTo() method is overrided and it is implemented from Comparable interface, it isuseful
	   to find if the object position is behind or ahead of the argument object
	*/
	@Override public int compareTo(Object obj) {
		Course arg = (Course) obj;
		if (this.courseNum > arg.courseNum) {
			return 1;
		}
		else if (this.courseNum < arg.courseNum) {
			return -1;
		}
		else {
			return 0;
		}
	}

}