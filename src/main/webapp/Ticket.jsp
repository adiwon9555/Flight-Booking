
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html ng-app="ticket_app">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="css/bootstrap.min.css">
	<link rel="stylesheet"
	href="css/practice.css">
<script
	src="js/jquery.min.js"></script>
<script
	src="js/bootstrap.min.js"></script>
<script	src="js/angular.js"></script>
<!-- <script src="assets/js/controllers.js"></script> -->


<style>
/* body
{
	background-image: url("images/blue.jpg");
	background-repeat: no-repeat;
	background-size:100% 100%;
} */
 
 
 table {
  border-radius: 25px;
 border: 2px solid black;

    padding: 5px;
    text-align: left;
    width:40%;
    height:10%;
}
 /* th, td {
    border: 1px solid black;
    border-collapse: collapse;

} */
th, td {border-radius: 25px;
    padding: 5px;
    text-align: left;    
}
 
 
 header {
    padding: 1em;
    color: white;
    background-color: black;
    clear: left;
    text-align: center;
}
 div {   
    width: 600px;
  
    padding: 20px;
 margin: 20px;
} 
 
         
</style> 
</head>
<body ng-controller="ticket_ctrl">
<center>

<h1>Ticket Confirmation</h1>

<div>




<tr><table    class="table table-striped"   style="margin-top:5%; margin-left:-20%;width: 800px;border-radius: 25px;" bgcolor="white" style="width:100%">


<tr>
<td><b>Flight-No:<b> </td><td>${transaction_details.flight.flight_No}</td><td><b>Flight-Name:</b> </td><td>${transaction_details.flight.flight_Name }</td>
</tr>

<tr>
<td><b>From:</b> </td><td>${transaction_details.flight.source_Airport.airport_city}</td><td><b>To:</b> </td><td>${transaction_details.flight.destination_Airport.airport_city}</td>
</tr>

<tr>
<td><b>Date:</b> </td><td>${transaction_details.sdate}</textarea></td><td><b>Class:</b> </td><td>Economy</td>
</tr>
<tr>
<td><b>Boarding Point:</b> </td><td>${transaction_details.flight.source_Airport.airport_city}</td><td><b>Reservation-upto:</b></td><td>${transaction_details.flight.destination_Airport.airport_city}</td>
</tr>

</table>
</tr>




</table>
<br>







<tr>
<table  bgcolor="white"   class="table" border="1px"  style=" margin-left:-20%; width: 800px;" style="width:100%">
  <tr>
    <th>Name</th>
    <th>Age</th> 
    <th>Gender</th>
    <th>Seat</th>
  </tr>
  <tr ng-repeat="f in passengers">
			<td>{{f.name}}</td>
			<td>{{f.age}}</td>
			<td>{{f.gender}}</td>
			<td>{{f.seat}}</td>
		</tr>


<tr><table  bgcolor="white"   class="table table-striped" border="1px"  style="margin-left:-20%;  width: 800px;" style="width:100%">
<tr>
<td><b>Ticket-Amount</b></td><td>${transaction_details.flight.flight_Price}</td>
</tr>

<tr>
<td><b>Service-Charges</b> </td><td>0</td>
</tr>

<tr>
<td><b>Seats Taken</b> </td><td>${transaction_details.seats_taken}</td>
</tr>

<tr>
<td><b>Total-Amount</b></td><td>${transaction_details.amount_paid}</td>
</tr>
<tr>
<c:choose>
<c:when test="${transaction_details.seats_taken <= 1}">
<td><b>Seat Number</b></td><td>${transaction_details.seat_no}</td>

</c:when>

<c:otherwise>
<td><b>Seat Numbers</b></td><td>${transaction_details.seat_no - transaction_details.seats_taken  + 1} to ${transaction_details.seat_no}</td>
</tr>
</c:otherwise>
</c:choose>

</table>
</tr>




</table>
</tr>
</div>
</form>
<a href="first1.jsp">Click here to book another ticket</a>
</center>
<script
	src="js/jquery.min.js"></script>
	<script type="text/javascript" src="javascript/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="javascript/angular-1.0.0.js"></script>
	<script type="text/javascript">
	var app = angular.module("ticket_app", []);
	app.controller("ticket_ctrl", function($scope) {
		
		$scope.passengers = ${transaction_details.passengers};
		
	});
	
	
	</script>
</body>
</html>