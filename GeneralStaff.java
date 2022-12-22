/*********************************************
Class: GeneralStaff (sub-class of Employee)
	Fields:
		duty
	Methods:
		GeneralStaff()
		GeneralStaff(String duty)
		GeneralStaff(String deptName, String duty)
		GeneralStaff(String name, int birthYear, String deptName, String duty)
		getDuty()

		//overrided
		equals()
		toString()
**********************************************/

import java.lang.*;
import java.util.*;

public class GeneralStaff extends Employee {
	private String duty;
	GeneralStaff next;
	// Overloaded contructors
	GeneralStaff() {
		this.duty = "";
	}
	GeneralStaff(String duty) {
		this.duty = duty;
	}
	GeneralStaff(String deptName, String duty) {
		super(deptName);
		this.duty = duty;
	}
	GeneralStaff(String name, int birthYear, String deptName, String duty) {
		super(name, birthYear, deptName);
		this.duty = duty;
	}
	// Returns duty string
	String getDuty() {
		return duty;
	}
	@Override
	public boolean equals(Object obj) {
		GeneralStaff arg = (GeneralStaff) obj;
		if((this.name == arg.name) && 
			(this.birthYear == arg.birthYear) && 
			(this.deptName == arg.deptName) && 
			(this.employeeID == arg.employeeID) &&
			(this.duty == arg.duty)) {
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public String toString() {
		return super.toString() + String.format("General Staff: Duty: %10s", duty);
	}
}