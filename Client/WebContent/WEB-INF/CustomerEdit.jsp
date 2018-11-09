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
	    <c:forEach items="${customers}" var="customer">
	        <form action="CustomersEdit" method="post">
	        	ID Number: <input type="text" name="id" value="${customer.id}" readonly="readonly"><br>
				First name: <input type="text" name="fname" value="${customer.first}"><br>
				Last name: <input type="text" name="lname" value="${customer.second}"><br>
				Phone Number: <input type="number" name="num" value="${customer.number}"><br>
				<input type="submit" value="Submit">
			</form>
	    </c:forEach>
	</table>
	
	</body>
</html>