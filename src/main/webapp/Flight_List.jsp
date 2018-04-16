<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html ng-app="admin_app">
<head>
<link rel="stylesheet" href="css/admin.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body ng-controller="admin_ctrl">
	<center>
		<h3 style="margin-left: 30%">${temp_message}</h3>

		<table border="1px" id=flight_table>

			
			<tr>
				<th style='width: 80px'>Flight Number</th>
				<th style="width: 100px">Flight Name</th>
				<th style="width: 100px">Departure Time</th>
				<th style="width: 100px">Arrival Time</th>
				<th style="width: 60px">Price</th>
				<th style="width: 100px">Source City</th>
				<th style="width: 130px">Destination City</th>
				<th style="width: 400px">Running Days</th>
				<th style='width: 100px'></th>
				<th style='width: 100px'><button class="add_flight">Add</button></th>
			</tr>
			<tr ng-repeat="f in flight_list">
				<td
					style="font-family: 'Lucia Grande',' Lucia Sans ',' DejaVu Sans ',' Verdana ',' Sans-serif '; font-size: 20px;">{{f.flight_No}}</td>
				<td>{{f.flight_Name}}</td>
				<td>{{f.departure_Time}}</td>
				<td>{{f.arrival_Time}}</td>`
				<td>{{f.flight_Price}}</td>
				<td>{{f.source_Airport.airport_city}}</td>
				<td>{{f.destination_Airport.airport_city}}</td>
				<td>{{f.days}}</td>
				<td><a href="deleteFlight.htm?flight_No={{f.flight_No}}"
					style="text-decoration: none"><button class="button"
							label="delete">delete</button></a></td>
				<td><button class="button" onclick=edit_row(this)>Edit</button></td>

			</tr>
		</table>
		<form action="addFlight.htm" method="get">
			<table id="flight_reg">
				<tr>

					<td style='width: 85px'>Enter details</td>
					<td><input type="text" id="flight_Name" name="flight_Name"
						style="width: 100px" placeholder="flight_Name" required></td>
					<td><input type="time" name="departure_Time" style="width: 100px"
						placeholder="departure_Time" required></td>
					<td><input type="time" name="arrival_Time" style="width: 100px"
						placeholder="arrival_Time" required></td>
					<td><input type="number" name="flight_Price"
						style="width: 60px" placeholder="Price" required></td>
					<td><select id="source" name="source" style='width: 100px'
						required>
							<option>select source</option>
					</select></td>
					<td><select id="destination" name="destination"
						style="width: 130px" required>
							<option>destination</option>
					</select></td>
					<td style='width: 400px'>
						<input type=checkbox id="days" value="Monday" name="days" autocomplete="off">Mo 
						<input type=checkbox id="days" value="Tuesday" name="days" autocomplete="off">Tu 
						<input type=checkbox id="days" value="Wednesday" name="days" autocomplete="off">We
						<input type=checkbox value="Thursday" id="days" name="days" autocomplete="off">Th
						<input type=checkbox value="Friday" id="days" name="days" autocomplete="off">Fr
						<input type=checkbox value="Saturday" id="days" name="days" autocomplete="off">Sa
						<input type=checkbox value="Sunday" id="days" name="days" autocomplete="off">Su
						</td>
					<td><input type="submit" class="button" style="width: 100px"></td>

					<td><input type="button" class="button" value="cancel"
						id="cancel_button" style="width: 100px"></td>



				</tr>

			</table>

		</form>

		<script type="text/javascript" src="javascript/jquery-3.3.1.js"></script>
		<script type="text/javascript" src="javascript/angular-1.0.0.js"></script>
		<script type="text/javascript" src="javascript/flight_admin.js"></script>
		<script>
	viewAllFlight();
	

</script>
	</center>
</body>
</html>