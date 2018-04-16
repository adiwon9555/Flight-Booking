<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link rel="stylesheet" href="css/admin.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<center>
<h3 style="margin-left: 30%">${temp_message}</h3>

	<table border="1px" id=booking_table>

		
		<tr>
			<th style='width: 80px'>Flight Number</th>
			<th >Flight Name</th>
			<th>Departure Time</th>
			<th>Arrival Time</th>
			<th style="width: 60px">Price</th>
			<th>Available Seats</th>
			
			<th style='width: 130px'></th>
			
		</tr>
		<c:forEach items="${specific_flight_list}" var="f">
		<tr >
			
			<td style=font-size:20px;"><c:out value="${f.flight.flight_No}"/></td>
			<td><c:out value="${f.flight.flight_Name}"/></td>
			<td><c:out value="${f.flight.departure_Time}"/></td>
			<td><c:out value="${f.flight.arrival_Time}"/></td>
			<td><c:out value="${f.flight.flight_Price}"/></td>
			<td><c:out value="${f.available_seats}"/></td>
			<c:choose>
			<c:when test="${f.available_seats <= 0}">
			
			<td><button class="button" disabled="disabled" label="Seats Full">Seats Full</button></a></td>
			
			</c:when>
			
			<c:otherwise>
			<td><a href="book.htm?flight_No=${f.flight.flight_No}&available_seats=${f.available_seats}&sdate=${f.sdate}" style="text-decoration:none"><button class="button" label="Book">Book</button></a></td>
			</c:otherwise>
			
			</c:choose>
			
		</tr>
		</c:forEach>
	</table>
	
	<script type="text/javascript" src="javascript/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="javascript/angular-1.0.0.js"></script>
	<script type="text/javascript" src="javascript/book_flight.js"></script>
	<script>
	<%-- viewAllSpecificFlights(<%=source%>); --%>
	

</script>
</center>
</body>
</html>