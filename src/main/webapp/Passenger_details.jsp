<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="helloApp">
<head>
<title>Hello AngularJS - Add Table Row Dynamically</title>
<link rel="stylesheet"
	href="css/bootstrap.min.css">
	
<script
	src="js/jquery.min.js"></script>
	
<script
	src="js/bootstrap.min.js"></script>
<script	src="js/angular.js"></script>
</head>

<body ng-controller="CompanyCtrl" style="background: rgba(76,175,80,0.0)">
<div id="wrapper">
<div id="y" style="position: absolute;margin-left:1%;">
<h3 style="margin-left:70%;"><center>Passenger Details</center></h3>
<br>
<table  class="table table-striped" id="passenger_table" border="1px"  style="margin-top:3%; margin-left:40%; width: 800px;overflow: hidden">
 
	<tr>
		<th>Name
		</th>
		<th>Age
		</th>
		<th>Gender
		</th>
		<th>Prefered seat
		</th>
		<th>Action
		</th>
	</tr>

	<tr ng-repeat="company in companies">
		<td><span ng-bind="company.name"></span>
		</td>
		<td><span ng-bind="company.age"></span>
		</td>
		<td><span ng-bind="company.gender"></span>
		</td>
		<td><span ng-bind="company.seat"></span>
		</td>
		<td><input type="button" value="Remove" class="btn btn-primary" ng-click="removeRow(company.name)"/>
		</td>
		
	</tr>
</table>
<div id="div_total"  style=" margin-left:39% ;display: none;"  >
		<label class="btn btn-secondary"  style=" margin-left:2%; width: 300px;"><a style="float:left" id="total">Total fare = <i>{{total}} * {{fare}}</i> = <b>{{total_fare}}</b> </a></label>
	</div>
	
	<div  style="  margin-left:46%;margin-top:5%" >
		<a id="aconfirm" href="" target="_top"><label  class="btn btn-primary"   style=" margin-left:18%; width: 400px;"><b><i>Confirm and pay</i><b></label></a>
	</div>
	
	
	</div>


	</div>
	<div style="position:absolute;padding-right:30px;padding-top:20px;padding-left:10px; margin-top:1px ;margin-left: 1%;background: rgba(0,0,1,0.6);color: white;border-radius: 15px">
	<div id="x" >

	<form   class="form-horizontal" id="add_form" role="form" ng-submit="addRow()" >
	<h3 >Enter your details</h3>
	<br>
	<div class="form-group" >
		<label class="col-md-2 control-label">Name</label>
		<div class="col-md-4">
			<input type="text"  class="form-control" style="width: 500%" name="name" required	ng-model="name" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-md-2 control-label">Age</label>
		<div class="col-md-4">
			<input type="number" style="width: 300%" required class="form-control" name="age"
				ng-model="age" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-md-2 control-label">Gender</label>
		<div class="col-md-4">
		<select  style="width: 400%"   class="form-control" id="gender" name="gender" ng-dropdown required  ng-model="gender">
						<option ng-options value="">Select gender</option>
						<option ng-options value="male">Male</option>
						<option ng-options value="female">Female</option>
						<option ng-options value="other">Other</option>
				</select>
			
		</div>
	</div>
	<div class="form-group">
		<label class="col-md-2 control-label" >Prefered Seat</label>
		<div class="col-md-4">
		<select  style="width: 500%"  class="form-control"  id="gender" name="seat"   ng-model="seat" ng-dropdown required>
		                <option ng-options value="">Select</option>
						<option ng-options value="window_seat">Window seat</option>
						<option ng-options value="other">Other seat</option>
				</select>
			
		</div>
	</div>
	
	<div class="form-group">								
		<div style="padding-left:70%">
			<input type="submit" value="Submit"  id="submit"  class="btn btn-primary"/>
		</div>
	</div>
</form>

</div>
</div>
</div>
<script type="text/javascript">
var count=0;
var helloApp = angular.module("helloApp", []);
helloApp.controller("CompanyCtrl", function($scope) {
	
$scope.companies = [];
$scope.addRow = function(){		
	$scope.companies.push({ 'name':$scope.name, 'age': $scope.age, 'gender':$scope.gender, 'seat':$scope.seat });
	$scope.name='';
	$scope.age='';
	$scope.gender='';
	$scope.seat='';
	var com=eval($scope.companies);
	var com2=JSON.stringify(com);
	var count=com.length;
	var fare=${flight.flight_Price};
	$scope.fare=fare;
	$scope.total=count;
	$scope.total_fare=count*fare;
	document.getElementById("div_total").style.display="block";
	/* document.getElementById("total").innerHTML="Total="+count; */
	if(count >0 )
		{
		var acf=document.getElementById("aconfirm");
		acf.href="toPayment.htm?passengers="+com2+"&flight_No=${flight.flight_No}&amount_paid="+count*fare+"&sdate=${sdate}&available_seats=${available_seats}";
		
		}
	if(count == ${available_seats} )
		{
			var sub=document.getElementById("submit");
			sub.value="Seats full";
			sub.disabled=true;
		}
};

$scope.removeRow = function(name){
	
	var index = -1;		
	var comArr = eval( $scope.companies );
	var count=comArr.length;
	
	for( var i = 0; i < comArr.length; i++ ) {
		if( comArr[i].name === name ) {
			index = i;
			break;
		}
	}
	if( index === -1 ) {
		alert( "Something gone wrong" );
	}
	count--;
	$scope.companies.splice( index, 1 );	
	var fare=${flight.flight_Price};
	$scope.fare=fare;
	$scope.total=count;
	$scope.total_fare=count*fare;	
	/* document.getElementById("total").innerHTML="Total="+count; */
	
	if(count <= 0 )
		{
		var acf=document.getElementById("aconfirm");
		acf.href="";
		document.getElementById("div_total").style.display="none";
		}
	
	if(count < ${available_seats} )
		{
			var sub=document.getElementById("submit");
			sub.value="Submit";
			sub.disabled=false;
		}
};

});



</script>


</body>
</html>
