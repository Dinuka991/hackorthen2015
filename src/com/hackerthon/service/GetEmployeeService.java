package com.hackerthon.service;

import org.xml.sax.SAXException;
import java.sql.Connection;
import java.util.logging.Logger;
import java.sql.DriverManager;
import javax.xml.parsers.ParserConfigurationException;
import java.sql.PreparedStatement;
import javax.xml.xpath.XPathExpressionException;
import com.hackerthon.common.UtilTRANSFORM;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.sql.Statement;
import com.hackerthon.common.UtilQ;
import java.io.IOException;
import com.hackerthon.model.Employee;
import com.hackerthon.model.Employee;

import java.util.ArrayList;
import java.util.Map;
import com.hackerthon.common.UtilC;

public class GetEmployeeService extends UtilC {

	private  ArrayList<Employee> el = new ArrayList<Employee>();

	private static Connection con;

	private static Statement stat;

	private PreparedStatement pStat;

	 private static GetEmployeeService instance = new GetEmployeeService();

	 public static GetEmployeeService getInstance(){
	      return instance;
	   }

		private  GetEmployeeService() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"),
						p.getProperty("password"));
			} catch (Exception e) {
			} 
		}
	

	public void xxmlForEmployee() {

		try {
			int s = UtilTRANSFORM.XMLXPATHS().size();
			for (int i = 0; i < s; i++) {
				Map<String, String> l = UtilTRANSFORM.XMLXPATHS().get(i);
				 Employee objectEmployee = Employee.getInstance();
				objectEmployee.setEmployeeId(l.get("XpathEmployeeIDKey"));
				objectEmployee.setEmployeeFullName(l.get("XpathEmployeeNameKey"));
				objectEmployee.setEmployeeAddress(l.get("XpathEmployeeAddressKey"));
				objectEmployee.setEmployeeFaculty(l.get("XpathFacultyNameKey"));
				objectEmployee.setEmployeeDepartment(l.get("XpathDepartmentKey"));
				objectEmployee.setEmployeeDesignation(l.get("XpathDesignationKey"));
				el.add(objectEmployee);
				System.out.println(objectEmployee.toString() + "\n");
			}
		} catch (Exception e) {
		}
	}

	public void createEmployeeTable() {
		try {
			stat = con.createStatement();
			stat.executeUpdate(UtilQ.Q("q2"));
			stat.executeUpdate(UtilQ.Q("q1"));
		} catch (Exception e) {
		}
	}

	public void addEmployee() {
		try {
			pStat = con.prepareStatement(UtilQ.Q("q3"));
			con.setAutoCommit(false);
			for(int i = 0; i < el.size(); i++){
				Employee emp = el.get(i);
				pStat.setString(1, emp.getEmployeeId());
				pStat.setString(2, emp.getEmployeeFullName());
				pStat.setString(3, emp.getEmployeeAddress());
				pStat.setString(4, emp.getEmployeeFaculty());
				pStat.setString(5, emp.getEmployeeDepartment());
				pStat.setString(6, emp.getEmployeeDesignation());
				pStat.addBatch();
			}
			pStat.executeBatch();
			con.commit();
		} catch (Exception e) {
		}
	}

	public void getEmployeeId(String eid) {
    
		 Employee object = Employee.getInstance();
		try {
			pStat = con.prepareStatement(UtilQ.Q("q4"));
			pStat.setString(1, eid);
			ResultSet R = pStat.executeQuery();
			while (R.next()) {
				object.setEmployeeId(R.getString(1));
				object.setEmployeeFullName(R.getString(2));
				object.setEmployeeAddress(R.getString(3));
				object.setEmployeeFaculty(R.getString(4));
				object.setEmployeeDepartment(R.getString(5));
				object.setEmployeeDesignation(R.getString(6));
				
			
			}
			ArrayList<Employee> l = new ArrayList<Employee>();
			l.add(object);
			outputEmployee(l);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deleteEmployee(String eid) {

		try {
			pStat = con.prepareStatement(UtilQ.Q("q6"));
			pStat.setString(1, eid);
			pStat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void displayEmployee() {

		ArrayList<Employee> el = new ArrayList<Employee>();
		try {
			pStat = con.prepareStatement(UtilQ.Q("q5"));
			ResultSet r = pStat.executeQuery();
			while (r.next()) {
				 Employee object = Employee.getInstance();
			
					object.setEmployeeId(r.getString(1));
					object.setEmployeeFullName(r.getString(2));
					object.setEmployeeAddress(r.getString(3));
					object.setEmployeeFaculty(r.getString(4));
					object.setEmployeeDepartment(r.getString(5));
					object.setEmployeeDesignation(r.getString(6));
					
				 
				 el .add(object);
			}
		} catch (Exception e) {
		}
		outputEmployee(el);
	}
	
	public void outputEmployee(ArrayList<Employee> l){
		
		System.out.println("Employee ID" + "\t\t" + "Full Name" + "\t\t" + "Address" + "\t\t" + "Faculty Name" + "\t\t"
				+ "Department" + "\t\t" + "Designation" + "\n");
		System.out.println("============================================================================="
				+ "===================================");
		for(int i = 0; i < l.size(); i++){
			Employee emp = l.get(i);
			System.out.println(emp.getEmployeeId() + "\t" + emp.getEmployeeFullName() + "\t\t"
					+ emp.getEmployeeAddress() + "\t" + emp.getEmployeeFaculty() + "\t" + emp.getEmployeeDepartment() + "\t"
					+ emp.getEmployeeDesignation() + "\n");
			System.out.println("--------------------------------------------------------------------------------------------"
					+ "--------------------");
		}
		
	}
}
