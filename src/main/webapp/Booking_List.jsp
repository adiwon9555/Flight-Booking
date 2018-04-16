<%@ page isELIgnored="false" pageEncoding="ISO-8859-1"%>

<html ng-app="admin_booking_app">
<head>
<link rel="stylesheet" href="css/admin.css" />
<script type="text/javascript" src="javascript/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="javascript/angular-1.0.0.js"></script>
	<script type="text/javascript" src="javascript/Booking_admin.js"></script>
	
</head>
<body ng-controller="admin_booking_ctrl">
<center>
<h3 style="margin-left: 30%">${temp_message}</h3>


	<table border="1px" id=booking_table>

		
		<tr>
			<th style='width: 50px'>Id</th>
			<th style="width: 80px">Flight No</th>
			<th style="width: 115px">Source City</th>
			<th style="width: 115px">Destination City</th>
			<th style="width: 115px">Date</th>
			<th style="width: 115px">Available Seats</th>
			<th style="width: 127px"></th>
			<th style="width: 120px"><button class="add_Booking","button">Add</button></th>
		</tr>
		<tr ng-repeat="f in booking_list">
			<td>{{f.sid}}</td>
			<td>{{f.flight.flight_No}}</td>
			<td>{{f.flight.source_Airport.airport_city}}</td>
			<td>{{f.flight.destination_Airport.airport_city}}</td>
			<td>{{f.sdate}}</td>
			<td>{{f.available_seats}}</td>
			<td><a href="deleteBooking.htm?sid={{f.sid}}" style="text-decoration:none"><button class="button" label="delete">delete</button></a></td>
			<td><button class="button" onclick=edit_row(this)>Edit</button></td>
			
		</tr>
	</table>
	<form action="addBooking.htm" method="get">
		<table id="booking_reg">
			<tr>
				<td style='width: 50px'>Enter details </td>
				<td>
					<select id="flight_No" name="flight_No" style="width: 80px"
						required>
							<option>select Flight</option>
					</select>
					</td>
				<td><input type="text" id="source_Airport" name="source_Airport"  readonly="readonly" style="width: 115px"
					placeholder="source_Airport" required></td>
				<td><input type="text" readonly="readonly"  name="destination_Airport"  id="destination_Airport"
					style="width: 115px" placeholder="destination_Airport" required></td>
				<td><input type="text" name="sdate"  style="width: 120px"
					placeholder="mm/dd/yyyy" required></td>
				<td><input type="number" name="available_seats" style="width: 115px" 
					 placeholder="available_seats" required></td>
				
				<td><input style="width: 127px" type="submit" class="button" style="width: 85px" ></td>
				
				<td><input style="width: 117px" type="button" class="button" value="cancel" id="cancel_button" style="width: 67px" ></td>

			</tr>
			
		</table>
	</form>
	<script>
	
	
	viewAllBooking();

</script>
</center>
</body>
</html>