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
				First name: <input type="text" name="fname" value="${booking.first}"><br>
				Last name: <input type="text" name="lname" value="${booking.second}"><br>
				Date: <input type="date" name="sdate" value="${booking.dateStart}"> - <input type="date" name="edate" value="${booking.dateEnd}"><br>
				Phone Number: <input type="number" name="num" value="${booking.number}"><br>
				Registration: <input type="text" name="reg" value="${booking.reg}"><br>
				Year: <input type="number" name="reg" value="${booking.year}"><br>
				Make: <input type="text" name="make" value="${booking.make}"><br>
				Cost: <input type="text" name="cost" value="${booking.cost}"><br>
				<input type="submit" value="Submit">
			</form>
	    </c:forEach>
	</table>
	
	</body>
</html>