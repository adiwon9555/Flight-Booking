<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="css/bootstrap.min.css">
<link href="js/bootstrap.min.js" rel="stylesheet">
<script type="text/javascript" src=javascript/GetSet.js></script>
<link href="css/jquery-ui.css" rel="stylesheet">
	
<script
	src="js/jquery.min.js"></script>
	

  <script src="js/jquery-ui.js"></script>
  
<style>

 d{
  color: blue;
          font-family:cursive;
       
       
         font-size: 200%;
 }
 ul.b{
 list-style-type: square;
 }
 table,th,td
{
	
	border: 0 solid black;
   
}

th,td{
	
	text-align:left;
	padding:8px;
}
 
 
 a:hover{
 color:Dodgerblue;
 }
      
         
</style>
</head>
<body style="background: rgba(0,0,0,0.0);margin-top: -2%;">


<center>
<form action="searchFlight.htm" id="myform"  method="post" target="Booking_content">
<table>

<ul class="b">
<tr>
<tr> 
<td><d>Source</d></td></tr>
<tr><td><input list="source" class='form-control' placeholder="Enter Source" name="source" required value="${source}"  onkeydown="getCity(this)" autocomplete="off">
<datalist id="source"  ></td>

</tr>


<tr><td> <d>Destination</d></td></tr>
<tr><td><input list="destination" class='form-control' placeholder="Enter Destination" name="destination" value="${destination}"  required  onkeydown="getCity(this)" autocomplete="off">
<datalist id="destination"  ></td>
</tr>
<tr>
<td><d>Date</d></td></tr>
<tr>
<td> <input type = "text" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'mm/dd/yyyy';}" required="required" class="datepicker form-control" value="${date}"  required="required" name=date> </td>
</tr>
<tr><td><input type="submit" class='btn btn-primary' value="Search">
</td>


</tr>
</tr>
<tr><td><input type="hidden" value="${first}" id="hid">
</td>


</tr>


</ul>

</table>
</form>
</center>

<script type="text/javascript">
run();
function run()
{
r=document.getElementById("hid");
source=document.getElementById("source");
destination=document.getElementById("destination");
date=document.getElementById("date");
myform=document.getElementById("myform");
if(r.value=="first")
	{
	
		r.value="f";
		myform.submit();
	}
else{
	session.removeAttribute("source");
	session.removeAttribute("destination");
	session.removeAttribute("date");
	
}
}
</script>

<script type="text/javascript">

$(document).ready(function () {
    var today = new Date();
    $('.datepicker').datepicker({
        format: 'mm-dd-yyyy',
        autoclose:true,
        startDate: "today",
        minDate: today
    }).on('changeDate', function (ev) {
            $(this).datepicker('hide');
        });


    $('.datepicker').keyup(function () {
        if (this.value.match(/[^0-9]/g)) {
            this.value = this.value.replace(/[^0-9^-]/g, '');
        }
    });
});

</script>
</body>
</html>