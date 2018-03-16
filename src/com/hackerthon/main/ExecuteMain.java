package com.hackerthon.main;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import com.hackerthon.common.UtilTRANSFORM;
import com.hackerthon.service.GetEmployeeService;
import com.hackerthon.service.GetEmployeeService;

public class ExecuteMain {

	public static void main(String[] args) {

		GetEmployeeService object = GetEmployeeService.getInstance();

		try {
			UtilTRANSFORM.rEQUESTtRANSFORM();
			object.xxmlForEmployee();
			object.createEmployeeTable();
			object.addEmployee();
			object.getEmployeeId("EMP10004");
			object.displayEmployee();
		} catch (Exception e) {
		}

	}

}
