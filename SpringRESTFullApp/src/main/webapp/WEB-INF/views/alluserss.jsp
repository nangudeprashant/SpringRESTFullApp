<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>User List</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>


<body>
	<h2>List of Users</h2>	
	<table>
		<c:forEach items="${employees}" var="employee">
			<tr>
			<td>${employee.id}</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<%-- <a href="<c:url value='/new' />">Add New Employee</a> --%>
</body>
</html>