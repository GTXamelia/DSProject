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
	    <c:forEach items="${bookings}" var="booking">
	        <form action="CustomersEdit" method="post">
	        	ID Number: <input type="text" name="id" value="${booking.id}" readonly="readonly"><br>
				First name: <input type="text" name="fname" value="${booking.first}"><br>
				Last name: <input type="text" name="lname" value="${booking.second}"><br>
				Phone Number: <input type="number" name="num" value="${booking.number}"><br>
				<input type="submit" value="Submit">
			</form>
	    </c:forEach>
	</table>
	
	</body>
</html>