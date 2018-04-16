<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html ng-app="admin_transaction_app">
<head>
<link rel="stylesheet" href="css/admin.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body ng-controller="admin_transaction_ctrl">
<center>
<h3 style="margin-left: 30%">${temp_message}</h3>

	<table border="1px" id=transaction_table>

		<tr>
			<th style='width: 80px'>Transaction Id</th>
			<th style="width: 130px">Customer Id</th>
			<th style="width: 130px">Flight No</th>
			<th style="width: 130px">Date</th>
			<th style="width: 130px">Amount_Paid</th>
			<th style="width: 130px">Seat_No</th>
			<th style="width: 130px">Action</th>
			
		</tr>
		<tr ng-repeat="a in transaction_list">
			<td>{{a.transaction_id}}</td>
			<td>{{a.customer.id}}</td>
			<td>{{a.flight.flight_No}}</td>
			<td>{{a.sdate}}</td>
			<td>{{a.amount_paid}}</td>
			<td>{{a.seat_no}}</td>
			<td><a href="deleteTransaction.htm?transaction_id={{a.transaction_id}}" style="text-decoration:none"><button  class="button" label="delete">delete</button></a></td>
			
			
		</tr>
	</table>
	
	</form>
	<script type="text/javascript" src="javascript/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="javascript/angular-1.0.0.js"></script>
	<script type="text/javascript" src="javascript/transaction_admin.js"></script>
	<script>
	viewAllTransaction();
	
</script>
</center>
</body>
</html>