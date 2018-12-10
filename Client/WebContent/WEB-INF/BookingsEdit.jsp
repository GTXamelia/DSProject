<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Booking Edit</title>
	</head>

	<body>
	
	<table>
	    <c:forEach items="${bookings}" var="booking">
	        <form action="BookingsEdit" method="post">
	        	<input type=hidden id="thisField" name="id" value="${booking.id}">
	        	<input type=hidden id="thisField" name="carID" value="${booking.carID}">
	        	<input type=hidden id="thisField" name="customerID" value="${booking.customerID}">
	        	Date: <input type="date" name="sdate" value="${booking.dateStart}"> - <input type="date" name="edate" value="${booking.dateEnd}"><br>
				First name: <input type="text" name="fname" value="${booking.first}"><br>
				Last name: <input type="text" name="lname" value="${booking.second}"><br>
				Phone Number: <input type="number" name="num" value="${booking.number}"><br>
				Registration: <input type="text" name="reg" value="${booking.reg}"><br>
				Year: <input type="number" name="year" value="${booking.year}"><br>
				Make: <input type="text" name="make" value="${booking.make}"><br>
				Cost: <input type="text" name="cost" value="${booking.cost}"><br>
				<input type="submit" value="Submit">
			</form>
	    </c:forEach>
	</table>
	
	<a href="/Web-Client">
		Homepage
	</a>
	
	</body>
</html>