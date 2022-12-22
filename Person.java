/*********************************************
Class: Person (is a parent/base class to other classes like Student and Employee)
	Fields:
		name
		birthYear
	Methods:
		//Constructor
		Person()
		Person(String, int)

		getName()
		getBirthYear()
		setname()
		setBirthyear()
		
		//Overrided methods
		equals()
		toString()
		compareTo()
**********************************************/

import java.lang.*;
import java.util.*;

public class Person implements Comparable {
	protected String name;
	protected int birthYear;
	
	//Constructors
	Person() {
		name = "";
		birthYear = 0;
	}
	Person(String name, int birthYear) {
		this.name = name;
		this.birthYear = birthYear;
	}

	//getter and setter (accessors/modifiers)
	String getName() {
		return this.name;
	}
	int getBirthYear() {
		return this.birthYear;
	}
	void setName(String name) {
		this.name = name;
	}
	void setBirthYear(int year) {
		this.birthYear = year;
	}
	/* 
	   Overrided equals() methods checks all fields of the argument object with the invoking object 
	   and returns true if all are equal otherwise returns false 
	*/
	@Override
	public boolean equals(Object obj) {
		Person arg = (Person) obj;
		return (this.name.equals(arg.name) && (this.birthYear == arg.birthYear));
	}
	/* 
	   Overrided toString() method returns the string output of content of the object
	   with a desired format 
	*/
	@Override
	public String toString() {
		return String.format("Person: Name: %30s : Birth Year: %4d", name, birthYear);
	}
	/* 
	   compareTo() method is overrided and it is implemented from Comparable interface, it isuseful
	   to find if the object position is behind or ahead of the argument object
	*/
	@Override
	public int compareTo(Object obj) {
		Person arg = (Person) obj;
		if (this.birthYear > arg.birthYear) {
			return 1;	
		}
		else if (this.birthYear < arg.birthYear) {
			return -1;
		}
		else {
			return 0;
		}
	}
}