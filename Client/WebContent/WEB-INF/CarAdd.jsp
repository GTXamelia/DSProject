<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Customers</title>
</head>

<body>
	<form action="CarAdd" method="post">
		<input type=hidden id="thisField" name="id"> Registration: <input
			type="text" name="reg"><br> Year: <input type="number"
			name="year"><br> Make: <input type="text" name="make"><br>
		Cost: <input type="number" name="cost" step="0.01"><br> <input
			type="submit" value="Submit">
	</form>

	<a href="/Web-Client"> Homepage </a>
</body>
</html>