/*********************************************
Class: Employee (Sub-class to Person and Parent to Faculty and General Staff)
	Fields:
		deptName
		employeeID
		numEmployee (static)

		Inherits from Person:-
		name
		birthYear
	Methods:
		Employee()
		Employee(String)
		Employee(String, int, String)
**********************************************/

import java.lang.*;
import java.util.*;

public class Employee extends Person implements Comparable {
	protected String deptName;
	static int numEmployees;
	protected int employeeID;

	//Constructors
	Employee() {
		super();
		numEmployees++;
		employeeID = numEmployees;
		deptName="";
	}
	Employee(String deptName) {
		super();
		numEmployees++;
		employeeID = numEmployees;
		this.deptName=deptName;
	}
	Employee(String name, int birthYear, String deptName) {
		super(name, birthYear);
		numEmployees++;
		employeeID = numEmployees;
		this.deptName=deptName;
	}

	//getters and setters (accessor/modifiers)
	String getDeptName() {
		return this.deptName;
	}
	static int getNumEmployees() {
		return numEmployees;
	}
	int getEmployeeID() {
		return employeeID;
	}
	void setDeptName (String deptName) {
		this.deptName = deptName;
	}
	/* 
	   Overrided equals() methods checks all fields of the argument object with the invoking object 
	   and returns true if all are equal otherwise returns false 
	*/
	@Override
	public boolean equals(Object obj) {
		Employee arg = (Employee) obj;
		if((this.name == arg.name) && 
			(this.birthYear == arg.birthYear) && 
			(this.deptName == arg.deptName) && 
			(this.employeeID == arg.employeeID) ) {
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
		return super.toString() + String.format(" Employee: Department: %20s | Employee Number: %3d", deptName, employeeID);
	}
	/* 
	   compareTo() method is overrided and it is implemented from Comparable interface, it isuseful
	   to find if the object position is behind or ahead of the argument object
	*/
	@Override
	public int compareTo(Object obj) {
		Employee arg = (Employee) obj;
		if(this.employeeID > arg.employeeID) {
		
			return 1;		
		}
		else if(this.employeeID < arg.employeeID) {
			return -1;
		}
		else {
			return 0;
		}
	}
}