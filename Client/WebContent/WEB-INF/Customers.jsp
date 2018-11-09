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
	        <tr>
	        	<td>${customer.id}</td>
	        	<td>${customer.first}</td>
	        	<td>${customer.second}</td>
	        	<td>${customer.number}</td>
	        	<td>
		        	<a href="CustomersEdit?id=${customer.id}">
	        		Edit: ${customer.id}
	        		</a>
	        	</td>
	        </tr>
	    </c:forEach>
	</table>
	
	</body>
</html>