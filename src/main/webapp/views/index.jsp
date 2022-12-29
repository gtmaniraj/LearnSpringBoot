<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>MVC using Spring Boot</title>

</head>
<body>
	<h2>Update Employee</h2>
	<form action="/con/update" method="Post">

		<input type="number" placeholder="Id to be updated" name="id" /> <input
			type="text" placeholder="Employee name" name="name"> <input
			type="text" placeholder="Designation" name="designation"> <input
			type="text" placeholder="Address" name="address"> <input
			type="number" placeholder="Salary" name="salary">
		<button type="submit" value="update" name="update">Update
			Employee</button>

	</form>
	<h2>Search Employee</h2>
	<form action="/con/search" method="Post">
		<input type="text" placeholder="Employee name" name="name">
		<button type="submit" value="search" name="search">search</button>
	</form>

	<h1>Employee List</h1>
	<table border="1">
		<thead>
			<tr>
				<th>Employee Id</th>
				<th>Employee Name</th>
				<th>Designation</th>
				<th>Address</th>
				<th>Salary</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="emp" items="${model}">
				<form action="/con/delete/${emp.id}" method="Post">
				
				<tr>

					<td><c:out value="${emp.id}" /></td>
					<td><c:out value="${emp.name}" /></td>
					<td><c:out value="${emp.designation}" /></td>
					<td><c:out value="${emp.address}" /></td>
					<td><c:out value="${emp.salary}" /></td>
					<td>
						<button type="submit" name="delete">delete</button>
					</td>

				</tr>

				</form>
			</c:forEach>
		</tbody>
	</table>
	<h2>Save Employee</h2>
	<form action="/con/save" method="POST">
		<input type="text" placeholder="Employee Name" name="name"> <input
			type="text" placeholder="Designation" name="designation"> <input
			type="text" placeholder="Address" name="address"> <input
			type="number" placeholder="Salary" name="salary">
		<button type="submit" value="save" name="save">Save Course</button>
	</form>



</body>
</html>