<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Customers</title>
	</head>

	<body>
	
	<table>
	    <c:forEach items="${cars}" var="cars">
	        <form action="CustomersEdit" method="post">
	        	ID Number: <input type="text" name="id" value="${car.id}" readonly="readonly"><br>
				<input type="submit" value="Submit">
			</form>
	    </c:forEach>
	</table>
	
	</body>
</html>