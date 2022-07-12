package com.service;

import java.util.List;

import com.model.Employee;

public interface EmployeeService {
	public String save(Employee employee);
	public List<Employee> getAllEmployee();
	public Employee getEmployee(String employeeId);
}
