package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Employee;
import com.service.EmployeeService;
import com.service.impl.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EmployeeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if("VIEW".equalsIgnoreCase(action)){
			String employeeId = request.getParameter("employeeId");
			EmployeeService empService = new EmployeeServiceImpl();
			Employee emp = empService.getEmployee(employeeId);
			System.out.println(emp);
		    request.setAttribute("employee", emp);
		    request.getRequestDispatcher("viewemployee.jsp").forward(request, response);
			
		}else{		
			EmployeeService empService = new EmployeeServiceImpl();
			List<Employee> employeeList = empService.getAllEmployee(); 
			System.out.println(employeeList);
		    request.setAttribute("users", employeeList);
		    request.getRequestDispatcher("ViewAllEmployee.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("fname"));
		System.out.println(request.getParameter("lname"));
		System.out.println(request.getParameter("gender"));
		System.out.println(request.getParameter("dob"));
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("salary"));
		
		Employee employee = new Employee();
		employee.setName(request.getParameter("fname"));
		employee.setGender(request.getParameter("gender"));
		employee.setSalary(request.getParameter("salary"));
		
		EmployeeService empService = new EmployeeServiceImpl();
		String msg = empService.save(employee);
		
		PrintWriter writer = response.getWriter();
		String htmlRespone = "<html>";
		htmlRespone += "<h2>Welcome " + request.getParameter("fname") + " to the Web World with Java</h2>";
		htmlRespone += "<h2>Data Saved ::" + msg + "</h2>";
		htmlRespone += "</html>";
		 
		writer.println(htmlRespone);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}
}
