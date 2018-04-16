<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html ng-app="admin_airport_app">
<head>
<link rel="stylesheet" href="css/admin.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body ng-controller="admin_airport_ctrl">
<center>
<h3 style="margin-left: 30%">${temp_message}</h3>

	<table border="1px" id=airport_table>

		<tr class="noborder">
			<!-- <td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td> -->
		</tr>
		<tr>
			<th style='width: 80px'>Airport Number</th>
			<th style="width: 130px">Airport Name</th>
			<th style="width: 130px">Short Name</th>
			<th style="width: 130px">Airport City</th>
			<th style="width: 130px"></th>
			<th style='min-width: 120px'><button class="add_airport" >Add</button></th>
		</tr>
		<tr ng-repeat="a in airport_list">
			<td>{{a.airport_id}}</td>
			<td>{{a.airport_name}}</td>
			<td>{{a.airport_short_name}}</td>
			<td>{{a.airport_city}}</td>
			<td><a href="deleteAirport.htm?airport_id={{a.airport_id}}" style="text-decoration:none"><button  class="button" label="delete">delete</button></a></td>
			<td><button class="button" onclick=edit_row(this)>Edit</button></td>
			
		</tr>
	</table>
	<form action="addAirport.htm" method="get">
		<table id="airport_reg">
			<tr>

				<td>Enter details</td>
				<td><input type="text" id="airport_name" name="airport_name"
					style="width: 130px" placeholder="airport_name" required></td>
				<td><input type="text" style="width: 130px" name="airport_short_name"
					placeholder="short_name" required></td>
				<td><input type="text" name="airport_city" 
					style="width: 130px" placeholder="airport_city" required></td>
				<td><input type="submit" class="button" style="width: 127px"></td>
				
				<td><input type="button" class="button" value="cancel" id="cancel_button" style="width: 117px"></td>



			</tr>
		</table>
	</form>
	<script type="text/javascript" src="javascript/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="javascript/angular-1.0.0.js"></script>
	<script type="text/javascript" src="javascript/airport_admin.js"></script>
	<script>
	viewAllAirport();
	
</script>
</center>
</body>
</html>