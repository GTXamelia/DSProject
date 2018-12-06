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
	    <c:forEach items="${cars}" var="car">
	        <form action="CarEdit" method="post">
	        	<input type=hidden id="thisField" name="id" value="${car.id}">
	        	Registration: <input type="text" name="reg" value="${car.reg}"><br>
	        	Year: <input type="number" name="year" value="${car.year}"><br>
	        	Make: <input type="text" name="make" value="${car.make}"><br>
	        	Cost: <input type="number" name="cost" value="${car.cost}" step="0.01"><br>
				<input type="submit" value="Submit">
			</form>
	    </c:forEach>
	</table>
	
	</body>
</html>