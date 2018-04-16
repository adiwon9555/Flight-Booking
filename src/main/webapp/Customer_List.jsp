<%@ page isELIgnored="false" pageEncoding="ISO-8859-1"%>

<html ng-app="admin_customer_app">
<head>
<link rel="stylesheet" href="css/admin.css" />
<script type="text/javascript" src="javascript/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="javascript/angular-1.0.0.js"></script>
	<script type="text/javascript" src="javascript/customer_admin.js"></script>
	
</head>
<body ng-controller="admin_customer_ctrl">
<center>
<h3 style="margin-left: 30%">${temp_message}</h3>


	<table border="1px" id=customer_table>

		<tr class="noborder">
			<!-- <td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td> -->
		</tr>
		<tr>
			<th style='width: 50px'>Id</th>
			<th>Customer Name</th>
			<th>Password</th>
			<th style="width: 115px">Email</th>
			<th style="width: 90px">Phone</th>
			<th style="width: 85px">Address</th>
			<th style="width: 40px">Age</th>
			<th style="width: 125px">DOB</th>
			<th  style="width: 70px">Country</th>
			<th style="width: 90px">State</th>
			<th style="width: 60px">Gender</th>
			<th style="width: 130px"></th>
			<th style="width: 120px"><button class="add_customer","button">Add</button></th>
		</tr>
		<tr ng-repeat="f in customer_list">
			<td>{{f.id}}</td>
			<td>{{f.name}}</td>
			<td>{{f.password}}</td>
			<td>{{f.email}}</td>
			<td>{{f.phone}}</td>
			<td>{{f.address}}</td>
			<td>{{f.age}}</td>
			<td>{{f.dob}}</td>
			<td>{{f.country}}</td>
			<td>{{f.state}}</td>
			<td>{{f.gender}}</td>
			<td><a href="deleteCustomer.htm?id={{f.id}}" style="text-decoration:none"><button class="button" label="delete">delete</button></a></td>
			<td><button class="button" onclick=edit_row(this)>Edit</button></td>
			
		</tr>
	</table>
	<form action="addCustomer.htm" method="get">
		<table id="customer_reg">
			<tr>
				<td style='width: 50px'>Enter details </td>
				<td><input type="text" id="name" name="name"
					style="width: 110px" placeholder="name" required></td>
				<td><input type="text" name="password" style="width: 67px"
					placeholder="password" required></td>
				<td><input type="email" name="email" 
					style="width: 115px" placeholder="email" required></td>
				<td><input type="number" name="phone" style="width: 90px"
					placeholder="phone" required></td>
				<td><input type="text" name="address" style="width: 85px" 
					 placeholder="address" required></td>
				<td><input type="number" name="age" style="width: 40px"  
					 placeholder="age" required></td>
				<td><input type="date" name="dob" style="width: 125px"
					placeholder="dob" required></td>
				<td><input type="text" name="country"  style="width: 70px"
					 placeholder="country" required></td>
					<td><input type="text" name="state" style="width: 90px"
					placeholder="state" required></td>
				<td><input type="text" name="gender" style="width: 60px" 
					 placeholder="gender" required></td>	
				
				<td><input style="width: 127px" type="submit" class="button" style="width: 85px" ></td>
				
				<td><input style="width: 117px" type="button" class="button" value="cancel" id="cancel_button" style="width: 67px" ></td>

			</tr>
			
		</table>
	</form>
	<script>
	viewAllCustomer();

</script>
</center>
</body>
</html>