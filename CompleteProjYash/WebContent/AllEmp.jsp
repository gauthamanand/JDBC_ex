<%@page import="com.model.bean.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
	<th>Employee Id</th>
	<th>Employee Name</th>
	<th>Employee department</th>
	<th>Employee Salary</th>
</tr>
	<% List<Employee> empList=(List<Employee>)session.getAttribute("AllEmployees");
	for(Employee e:empList){
	%>
	<tr>
		<td><%out.print(e.getID()); %></td>
		<td><%out.print(e.getName()); %></td>
		<td><%out.print(e.getDepartment()); %></td>
		<td><%out.print(e.getSalary()); %></td>
	</tr>
	<%} %>
	
	</table>
</body>
</html>