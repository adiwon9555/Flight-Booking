<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<!--
	Author: W3layouts
	Author URL: http://w3layouts.com
	License: Creative Commons Attribution 3.0 Unported
	License URL: http://creativecommons.org/licenses/by/3.0/
-->

<!DOCTYPE html>
<html ng-app="admin_app">
<head>

<!-- <script>
function preventBack(){
window.history.forward();
}

setTimeout("preventBack()",0);
window.onunload=function(){null};
</script> -->
<script type="text/javascript" src="javascript/GetSet.js"></script>
<!-- <link rel="stylesheet" href="css/admin.css">
 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
/*modal_start*/
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

/* Set a style for all buttons */
button {
    background-color: #a1a1a1;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #a1a1a1;
}

.container {
    padding: 16px;
}

span.psw {
    float: right;
    padding-top: 16px;
}

/* The Modal (background) */
 .modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    overflow: auto; /* Enable scroll if needed */
   
    padding-top: 60px;
} 
.modal-backdrop
{
opacity:0.8  !important;
}



/* The Close Button (x) */
.close {
    position: absolute;
    right: 25px;
    top: 0;
    color: #000;
    font-size: 35px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: red;
    cursor: pointer;
}

/* Add Zoom Animation */
.animate {
    -webkit-animation: animatezoom 0.6s;
    animation: animatezoom 0.6s
}

@-webkit-keyframes animatezoom {
    from {-webkit-transform: scale(0)} 
    to {-webkit-transform: scale(1)}
}
    
@keyframes animatezoom {
    from {transform: scale(0)} 
    to {transform: scale(1)}
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}



/*modal_end*/
body {margin: 0;
  font-size: 28px;
	 background:images/plane.png; 
	background-repeat:no-repeat;
	background-size: 100%;
	font-family: 'Open Sans', sans-serif;
	background-attachment: fixed;
    background-position: center;
}
.header {
  background-color: #f1f1f1;
  padding: 10px;
  text-align: center;
}

#navbar {
  overflow: hidden;
  background-color: #333;
}

#navbar a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

#navbar a:hover {
  background-color: #ddd;
  color: black;
}


.content {
  padding: 16px;
}

.sticky {
  position: fixed;
  top: 0;
  width: 100%
}

.sticky + .content {
  padding-top: 60px;
}


.navbar {
    overflow: hidden;
    background-color: #333;
    font-family: Arial;
}

.navbar a {
    float: left;
    font-size: 16px;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

.dropdown {
    
    overflow: hidden;
}

.dropdown .dropbtn {
    font-size: 16px;    
    border: none;
    outline: none;
    color: white;
    padding: 14px 16px;
    background-color: inherit;
    font: inherit;
    margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
    background-color: gray;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
   width: 107px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    float: none;
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {
    background-color: #ddd;
}

.dropdown:hover .dropdown-content {
    display: block;
}
</style>




 
      <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
     
    
	<title>Flight Ticket Booking a Flat Responsive Widget Template :: w3layouts</title>
	<link rel="stylesheet" href="css/abc.css">
	<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300italic,300,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
	<link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Flight Ticket Booking  Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	
		
		
		
</head>
<body ng-controller="admin_ctrl" background="images/plane.png">



<div id="id01" class="modal fade"  style="width:80%;margin-left: 10%;margin-right: 10%; border: none;" aria-hidden="true" aria-labelledby="exampleModalLabel" tabindex="-1" role="dialog">
  
  <form class="modal-content animate" action="/action_page.php">
    

    <div class="container" style="background-color:#f1f1f1">
    <center>
       <p id="exampleModalLabel" style="font-size:150%"><b>My Bookings</b></p>
     </center>
     <br>
      <table border="1px solid black"  id=flight_table >

	
		<tr>
			<th style='width: 80px'>Transaction ID</th>
			<th>Customer Name</th>
			<th>Flight Name</th>
			<th>Source city </th>
			<th>Destination city</th>
			<th style="width: 60px">Date</th>
			<th>Amount paid</th>
			<th>Seat number</th>
			<th style='width: 130px'>Seat(s) taken</th>
			<th>Actions</th>
			<!-- <th style='width: 120px'><button class="add_flight">Add</button></th> -->
		</tr>
		<tr ng-repeat="f in flight_list">
			<td style="font-family:'Lucia Grande','Lucia Sans','DejaVu Sans','Verdana','Sans-serif'; font-size:20px;">{{f.flight_No}}</td>
			<td>{{f.flight_Name}}</td>
			<td>{{f.flight_Time}}</td>
			<td>{{f.flight_Price}}</td>
			<td>{{f.source_Airport.airport_city}}</td>
			<td>{{f.destination_Airport.airport_city}}</td>
			<td><a href="deleteFlight.htm?flight_No={{f.flight_No}}" style="text-decoration:none"><button class="button" label="delete">delete</button></a></td>
			<td><button class="button" onclick=edit_row(this)>Edit</button></td>
			<td></td>
			<td></td>
			
		</tr>
	</table>
	
    </div>

    <div class="container" style="background-color:#e8f4f3" style="width:80%">
      <center>
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn" data-dismiss="modal">Cancel</button>
      </center>
    </div>
  </form>
</div>






<div id="navbar">


  <a class="active" href="javascript:void(0)">Home</a>
  <a href="javascript:void(0)" onclick="document.getElementById('id01').style.display='block'" style="width:auto;">My Bookings</a>
  <a href="javascript:void(0)">Contact Us</a> 
 
  
  <div class="dropdown" style="float: right;margin-right: 50px">
  
  <button class="dropbtn">Hi ${user.name}
      <i class="fa fa-caret-down"></i>
    </button>

  <div class="dropdown-content" >
    <a href="#" style="color: black;">My profile</a>
    <a href="logout.htm" style="color: black;">Sign out</a>
    
  </div>
</div>

  
</div>

<br><br>




	<div class="main-agileinfo" align="center">
		<div class="sap_tabs">			
			<div id="horizontalTab">
				<ul class="resp-tabs-list">
					
					<li class="resp-tab-item"><span>Flight Ticket Booking</span></li>
								
				</ul>	
				<div class="clearfix"> </div>	
				
				<div class="resp-tabs-container">
					
					<div class="tab-1 resp-tab-content roundtrip">
						<form action="Booking.jsp" method="post">
							<div class="from">
							<br>
								<h3>From</h3>
								<input type="hidden" name="first" value="first">
								<input list="source"  style="padding: 10px 0; font-size: 15px" class ="city1" placeholder="Type Departure City" name="source" required=""  onkeydown="getCity(this)" autocomplete="off">
<datalist id="source"  >
</datalist>
								
								
								<!-- <input type="text" name="city" class="city1" placeholder="Type Departure City" required=""> -->
							</div>
							<div class="to">
							<br>
								<h3>To</h3>
								
								<input list="destination" style="padding: 10px ; font-size: 15px" class="city2" placeholder="Type Destination City" required="" name="destination"   onkeydown="getCity(this)" autocomplete="off">
<datalist id="destination"  >


</datalist>
								
								
							<!-- 	<input type="text" name="city" class="city2" placeholder="Type Destination City" required=""> -->
							</div>
							<div class="clear"></div>
							<div class="date" style="margin-left: 12%;margin-top: 4%">
								<div class="depart">
									<h3>Depart</h3>
									 <input type = "date" style="width: 105% ; font-size: 170%;" name=date> 
									<span class="checkbox1">
										<label class="checkbox"></label>
									</span>
								</div>
								<!-- <div class="return">
									<h3>Return</h3>
									<input  id="datepicker1" name="Text" type="text" value="mm/dd/yyyy" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'mm/dd/yyyy';}" required="">
									<span class="checkbox1">
										<label class="checkbox"><input type="checkbox" name="" checked=""><i> </i>Flexible with date</label>
									</span>
								</div> -->
								<div class="clear"></div>
							</div>
						<div class="numofppl" style="margin-left: 62%;margin-top: -15%">
								<h3 style="margin-left: -60%;">Class</h3>
								<select id="w3_country1" onchange="change_country(this.value)" class="">
									<option value="null">Economy</option>  
									<!-- <option value="null">Premium Economy</option>   
									<option value="null">Business</option>   
									<option value="null">First class</option>    -->						
								</select>

							</div>
							<!-- <div class="clear"></div>
							<div class="numofppl" >
								<div class="adults">
									<h3>Passenger(s)</h3>
									<div class="quantity"> 
										<div class="quantity-select">                           
											<div class="entry value-minus">&nbsp;</div>
											<div class="entry value"><span>1</span></div>
											<div class="entry value-plus active">&nbsp;</div>
										</div>
									</div>
								</div> -->
								
								<div class="clear"></div>
							</div>
							<div class="clear"></div>
							<input type="submit"  value="Search Flights">
						</form>						
					</div>		
					
					
				</div>						
			</div>
		</div>
	</div>
	
	<!--script for portfolio-->
		<script src="js/jquery.min.js"> </script>
		<script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
		<script type="text/javascript">
			$(document).ready(function () {
				$('#horizontalTab').easyResponsiveTabs({
					type: 'default', //Types: default, vertical, accordion           
					width: 'auto', //auto or any width like 600px
					fit: true   // 100% fit in a container
				});
			});		
		</script>
		<!--//script for portfolio-->
				<!-- Calendar -->
				<link rel="stylesheet" href="css/jquery-ui.css" />
				<script src="js/jquery-ui.js"></script>
				  <script>
						  $(function() {
							$( "#datepicker,#datepicker1,#datepicker2,#datepicker3" ).datepicker();
						  });
				  </script>
			<!-- //Calendar -->
			<!--quantity-->
									<script>
									$('.value-plus').on('click', function(){
										var divUpd = $(this).parent().find('.value'), newVal = parseInt(divUpd.text(), 10)+1;
										divUpd.text(newVal);
									});

									$('.value-minus').on('click', function(){
										var divUpd = $(this).parent().find('.value'), newVal = parseInt(divUpd.text(), 10)-1;
										if(newVal>=1) divUpd.text(newVal);
									});
									</script>
								<!--//quantity-->
						<!--load more-->
								<script>
	$(document).ready(function () {
		size_li = $("#myList li").size();
		x=1;
		$('#myList li:lt('+x+')').show();
		$('#loadMore').click(function () {
			x= (x+1 <= size_li) ? x+1 : size_li;
			$('#myList li:lt('+x+')').show();
		});
		$('#showLess').click(function () {
			x=(x-1<0) ? 1 : x-1;
			$('#myList li').not(':lt('+x+')').hide();
		});
	});
</script>



<script>
window.onscroll = function() {myFunction()};

var navbar = document.getElementById("navbar");
var sticky = navbar.offsetTop;

function myFunction() {
  if (window.pageYOffset >= sticky) {
    navbar.classList.add("sticky")
  } else {
    navbar.classList.remove("sticky");
  }
}



var modal = document.getElementById('id01');

//When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
 if (event.target == modal) {
     modal.style.display = "none";
 }
}

</script>





 <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>


<!-- //load-more -->

</body>
</html>