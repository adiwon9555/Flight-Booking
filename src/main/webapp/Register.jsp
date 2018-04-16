<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
 <link rel="stylesheet" href="css/MyStyle.css">
<script type="text/javascript" src="javascript/validate.js">


</script>
<style>

body {
	background-image:url('https://ak7.picdn.net/shutterstock/videos/8966857/thumb/1.jpg');
	background-repeat: no-repeat;
   background-size:100%;
   
 
}

</style>
</head>
<body >

<center>
<h3>${message}</h3>
<font size='5' color='red'><b><h1>Registration Page</h1></b></font>
<p id="message"></p>
<p id="eval"></p>
<form action="register_profile.htm" method="post">
<table border=10>
<tr>
<td>Name:- </td><td><input type="text" id='name' autofocus="autofocus"  onblur="checkname(this)" required name='name'></td>
</tr>

<tr>
<td>Password:- </td><td><input type="password" id="password" onblur="checkpass(this)" required name="password"></td>
</tr>
<tr>
<td>Email:- </td><td><input type="email" onblur="checkemail(this)" onkeyup="validateEmailServer()" id="email" required name="email"></td>
</tr>
<tr>
<td>Address</td><td><textarea rows="3" cols="21" id="address" required name="address"></textarea></td>
</tr>
<tr>
<td>Age:</td><td> <input type="number" id="age" required name="age"></td>
</tr>
<tr>
<td>DOB:- </td><td><input type="date" id="dob" required name="dob"></td>
</tr>
<tr>
<td>Country:-</td><td><select id="country" onchange="enterstate(this)" required name="country">
			<option></option>
			<option>India</option>
			<option>US</option>
				
			
			
		</select></td>
</tr>
<tr>
<td>State:-</td><td><select id="state" required name="state" >
			
				
			
			
		</select></td>
</tr>
<tr>
<td>Gender :-</td><td> <input type="radio" name="gender" value="male" id="male">Male<input type="radio" value="female" name="gender" id='female'>Female</td>
</tr>

<tr>
<td>Phone :-</td><td> <input type="number" id="phone" onblur="checkphone(this)"  onkeyup="validatePhoneServer(this)" required name="phone"></td>
</tr>
</tr>
<tr>
<td>Captcha ---></td>
<td id="cap">1234</td>
</tr>
<tr>
<td></td>
<td><input placeholder="enter captcha" type=text id="captcha" autocomplete="off" required onblur="capver(this)"></td>
</tr>
<tr>
<td></td>
<td><input type=button value='verify captcha' onclick="capver()"></td>
</tr>

<tr>
<td>Agree</td><td><input type="checkbox" required id="agree" name="agree"></td>
</tr>
<tr>
<td><input type="submit" value="Register"  id="register" name="register"></td>
<td><input type="reset"  id="reset"  name="reset"></td>
</tr>
</table>
</form>
<script type="text/javascript">

cap();</script>
</center>
</body>
</html>