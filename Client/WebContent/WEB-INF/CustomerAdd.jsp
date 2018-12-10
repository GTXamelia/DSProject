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
	

        <form action="CustomerAdd" method="post">
			First name: <input type="text" name="fname"><br>
			Last name: <input type="text" name="lname"><br>
			Phone Number: <input type="number" name="num"><br>
			<input type="submit" value="Submit">
		</form>

	<a href="/Web-Client"> Homepage </a>

</body>
</html>