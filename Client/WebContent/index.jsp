<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Booking Service</title>
</head>

<body>
	<h1>Car Hire Booking Service</h1>
	
	
	<table>
		<tr>
			<td>
				<form action= "Customers" method="get">
					<input type="submit" value="Get all Customers"/>
				</form>
			</td>
			<td>
				<form action= "Cars" method="get">
					<input type="submit" value="Get all Cars"/>
				</form>
			</td>
			<td>
				<form action= "Bookings" method="get">
					<input type="submit" value="Get all Bookings"/>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>