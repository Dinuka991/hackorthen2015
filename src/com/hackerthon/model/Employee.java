package com.hackerthon.model;

public class Employee {

	public String employeeId;
	public String employeeFullName;
	public String employeeAddress;
	public String employeeFaculty;
	public String employeeDepartment;
	public String employeeDesignation;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeFullName() {
		return employeeFullName;
	}

	public void setEmployeeFullName(String employeeFullName) {
		this.employeeFullName = employeeFullName;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}


	public String getEmployeeFaculty() {
		return employeeFaculty;
	}


	public void setEmployeeFaculty(String employeeFaculty) {
		this.employeeFaculty = employeeFaculty;
	}

	public String getEmployeeDepartment() {
		return employeeDepartment;
	}

	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}




	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}
	
	
	   private static Employee instanceEmployee = new Employee();

	   
	   private Employee(){}

	   
	   public static Employee getInstance(){
	      return instanceEmployee;
	   }

    


	@Override
	public String toString() {
		
		return "Employee ID = " +  employeeId + "\n" + "FullName = " + employeeFullName + "\n" + "Address = " + employeeAddress + "\n"
				+ "Faculty Name = " + employeeFaculty + "\n" + "Department = " + employeeDepartment + "\n" + "Designation = "
				+ employeeDesignation;
	}
}
