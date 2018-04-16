<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Source_Destination</title>
<script type="text/javascript" src="javascript/GetSet.js"></script>
</head>
<body>
<center>.
<font size='5' color='red'><b><h1>Check Flights!!</h1></b></font>
</center>

<form action="searchFlight.htm" method="post">
<!-- <table border="1px">
<tr><td>

<input list="source" placeholder="Enter Source" name="source" required  onkeydown="getCity(this)" autocomplete="off">
<datalist id="source"  >


</datalist>
</td>
</tr>
<tr><td>
<input list="destination" placeholder="Enter Destination" name="destination" required  onkeydown="getCity(this)" autocomplete="off">
<datalist id="destination"  >


</datalist>
</td>
</tr>
<tr><td>

</td>
</tr>
</table> -->

<input type="submit" value="search"> 
</form>

<br>

<br>
<h2>${message}</h2>

<br>
<center>
<table border="1px">

<tr><th>Source City</th><th>Destination City</th><th>Source Airport</th><th>Destination Airport</th><th>Flight Number</th><th>Flight Name</th><th>Departure Time</th><th>Price</th>
<c:forEach items="${flight_list}" var="r">
<tr>
<td><c:out value="${r.source_Airport.airport_city}"/></td>
<td><c:out value="${r.destination_Airport.airport_city}"/></td>
<td><c:out value="${r.source_Airport.airport_name}(${r.source_Airport.airport_short_name})"/></td>
<td><c:out value="${r.destination_Airport.airport_name}(${r.destination_Airport.airport_short_name})"/></td>
<td><c:out value="${r.flight_No}"/></td>
<td><c:out value="${r.flight_Name}"/></td>
<td><c:out value="${r.flight_Time}"/></td>
<td><c:out value="${r.flight_Price}"/></td>





</tr>
</c:forEach>


</table>





</center>
</body>
</html>