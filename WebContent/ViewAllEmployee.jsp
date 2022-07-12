<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Employee</title>
</head>
<body>
<h1 style="background-color:DodgerBlue;">View All Employees</h1>
<table border="1">
       <tr>
       	<td>Employee ID</td>
           <td>Name</td>
           <td>Gender</td>
           <td>Salary</td>
		   <td>View</td>
		   <td>Delete</td>
		   <td>Update</td>
       </tr>
    <c:forEach items="${users}" var="user">
        <tr>
        	<td>${user.employeeId}</td>
            <td>${user.name}</td>
            <td>${user.gender}</td>
            <td>${user.salary}</td>
			<td><a href="employee?action=VIEW&employeeId=${user.employeeId}">View</a></td>
			<td><input type="button" value="Delete"/></td>
			<td><input type="button" value="Update"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>