package com.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Employee;
import com.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	public String save(Employee employee) {
		// Open a connection
		Connection conn = null;
		PreparedStatement pstmt = null;
		String msg ="Failure";
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gnhp", "root", "root");			
			pstmt = conn.prepareStatement("insert into satyamemployee (name,gender,salary) values(?,?,?)");
			//pstmt.setInt(1, 6);
			pstmt.setString(1, employee.getName());
			pstmt.setString(2, employee.getGender());
			pstmt.setString(3, employee.getSalary());
			
			int count = pstmt.executeUpdate();
			System.out.println("Number of record modified = "+count);
			msg ="Success";
		} catch (SQLException e) {
			e.printStackTrace();
			msg = "Failure";
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return msg;
	}

	public List<Employee> getAllEmployee() {
		// Open a connection
				Connection conn=null;
				Statement stmt = null;
				ResultSet rs = null;
				List<Employee> empList = new ArrayList<Employee>();
				try  {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gnhp", "root", "root");
					stmt = conn.createStatement();
					rs = stmt.executeQuery("select employeeId,name,gender,salary from satyamemployee");
					
					// Extract data from result set
					while (rs.next()) {
						Employee emp = new Employee();
						emp.setEmployeeId(rs.getInt("employeeId"));
						emp.setName(rs.getString("name"));
						emp.setGender(rs.getString("gender"));
						emp.setSalary(rs.getString("salary"));				
						empList.add(emp);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}finally {
					try {
						rs.close();
						stmt.close();
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
		return empList;
	}

	public Employee getEmployee(String employeeId) {
		Connection conn=null;
		Statement stmt = null;
		ResultSet rs = null;
		Employee emp = null;
		try  {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gnhp", "root", "root");
			stmt = conn.createStatement();
			String query = "select employeeId,name,gender,salary from satyamemployee where employeeId="+employeeId;
			System.out.println(query);
			rs = stmt.executeQuery(query);
			
			// Extract data from result set			
			while (rs.next()) {
				emp = new Employee();
				emp.setEmployeeId(rs.getInt("employeeId"));
				emp.setName(rs.getString("name"));
				emp.setGender(rs.getString("gender"));
				emp.setSalary(rs.getString("salary"));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
	}
}
