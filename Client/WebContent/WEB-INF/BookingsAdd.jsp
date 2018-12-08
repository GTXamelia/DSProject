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
        <form action="BookingsAdd" method="post">
        	Car: <select id="selectedRecord" name="carID">
	            <c:forEach items="${bookings}" var="booking" varStatus="status">
	            	<option value="${booking.carID} ${booking.make} ${booking.reg} ${booking.year} ${booking.cost}">${booking.make} $${booking.cost}</option>
	            </c:forEach>
        	</select><br>
        	<input type=hidden id="thisField" name="customerID">
        	Date: <input type="date" name="sdate"> - <input type="date" name="edate"><br>
        	Customer: <select id="selectedRecord" name="custID">
	            <c:forEach items="${bookings}" var="booking" varStatus="status">
	            	<option value="${booking.customerID} ${booking.first} ${booking.second} ${booking.number}">${booking.first} ${booking.second} ${booking.number}</option>
	            </c:forEach>
        	</select><br>
			<input type="submit" value="Submit">
		</form>
	</body>
</html>