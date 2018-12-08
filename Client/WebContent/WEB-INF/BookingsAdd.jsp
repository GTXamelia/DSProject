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
        <form action="BookingsEdit" method="post">
        	<input type=hidden id="thisField" name="carID">
        	<input type=hidden id="thisField" name="customerID">
        	Date: <input type="date" name="sdate"> - <input type="date" name="edate"><br>
			First name: <input type="text" name="fname"><br>
			Last name: <input type="text" name="lname"><br>
			Phone Number: <input type="number" name="num"><br>
			Registration: <input type="text" name="reg"><br>
			Year: <input type="number" name="year"><br>
			Make: <input type="text" name="make"><br>
			Cost: <input type="text" name="cost"><br>
			<input type="submit" value="Submit">
		</form>
	
	</body>
</html>