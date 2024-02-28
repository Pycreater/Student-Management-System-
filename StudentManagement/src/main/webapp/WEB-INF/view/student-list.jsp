<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    
    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="/StudentManagement/URLToReachResources/css/style.css">

</head>
<body>
<div align="center">

	<h1>Students </h1>
	<form action="/StudentManagement/showAddStudentPage">
	<input type="submit" value="ADD">
	</form>

		<table border="1">
		<thead>
			<th>Id</th>
			<th>Name</th>
			<th>Mobile</th>
			<th>Country</th>
		</thead>
		<c:forEach var="student" items="${students}">
		<tr>	
			<td>${student.id}</td>
			<td>${student.name} </td>
			<td>${student.mobile} </td>
			<td>${student.country} </td> 
			<td><a href="/StudentManagement/updateStudent?userId=${student.id}">Update</a></td>
			<td><a href="/StudentManagement/deleteStudent?userId=${student.id}" onclick="if(!(confirm('Are you sure,you want to delete this Student')))return false">Delete</a></td>
		</tr>
		</c:forEach>
		</table>
		
		<img alt="" src="">
</div>
</body>
</html>