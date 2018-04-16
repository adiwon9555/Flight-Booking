/**
 * 
 */
function viewAllBooking() {
	var app = angular.module("admin_booking_app", []);
	app.controller("admin_booking_ctrl", function($scope, $http) {
		
		
		$http.get('viewAllBooking.htm').success(function(info) {
			$scope.booking_list = info;
			
		
		
		});
		
		
	});
}
var value=new Array();
function edit_row(e)
{		
	
		var row = e.parentElement.parentElement;
		
		
		for(var i=0;i<row.childElementCount-2;i++)
			{
			
				value[i]=row.children[i].innerHTML;
			}
		row.children[0].innerHTML="<input type='text' id='sid_edit' name='sid' style='width: 50px' value='"+value[0]+"' placeholder='id' readonly='readonly' required>";
		
		row.children[1].innerHTML="<select style='width: 80px' id='flight_No_edit' name='flight_No' required onchange='getCity(this)'><option value="+value[1]+">"+value[1]+"</option></select>";
		row.children[2].innerHTML="<input  type='text' id='source_Airport_edit' name='source_Airport' style='width: 115px' value='"+value[2]+"' readonly='readonly' placeholder='source_Airport' required>";
		row.children[3].innerHTML="<input type='text' id='destination_Airport_edit' name='destination_Airport' style='width: 115px' value='"+value[3]+"' readonly='readonly' placeholder='destination_Airport' required>";
		row.children[4].innerHTML="<input type='text' id='sdate_edit' name='sdate' style='width: 115px' value='"+value[4]+"' placeholder='mm/dd/yyyy' required>";
		row.children[5].innerHTML="<input type='number' id='available_seats_edit' name='available_seats' style='width:115px' value='"+value[5]+"' placeholder='available_seats' required>";
		row.children[6].innerHTML="<button style='width:127px' class='update_button' onclick=update_booking(this)>Update</button>";
		row.children[7].innerHTML="<input type='button' onclick=cancel_update(this) class='button' value='cancel' id='cancel_update'>";
		document.getElementById("flight_No_edit").focus();
		getFlight_No(row.children[1].children[0]);
		
}
function update_booking(e)
{
	var uval=new Array();
	var row = e.parentElement.parentElement;
	for(var i=0;i<row.childElementCount-2;i++)
	{
		
		uval[i]=row.children[i].children[0].value;
		
		
	}
	
	link="editBooking.htm?sid="+uval[0]+"&flight_No="+uval[1]+"&source_Airport="+uval[2]+"&destination_Airport="+uval[3]+"&sdate="+uval[4]+"&available_seats="+uval[5];
	location.href=link;
}

function cancel_update(e)
{
	var row = e.parentElement.parentElement;
	for(var i=0;i<row.childElementCount-2;i++)
	{
		
		row.children[i].innerHTML=value[i];
		
		
	}
	

	row.children[6].innerHTML="<a  href='deleteBooking.htm?sid="+value[0]+"'><button  class='button' label='delete'>delete</button></a>"
	row.children[7].innerHTML="<button class='edit_button' onclick=edit_row(this)>Edit</button>"
	
}
$(document).ready(function(){
	
	$("button.add_booking").click(function(){
		$("table#booking_reg").show();
		$("input#flight_No").focus();
	});
	
	
	$("#cancel_button").click(function(){
		$("table#booking_reg").hide();
		
		
		
	});
	
	
		$('option',"#flight_No").remove();
		$.getJSON("viewAllFlight.htm",function(data){
			
			for(i=0;i<data.length;i++)
			{
				
		
			var option='<option value='+data[i].flight_No+'>'+data[i].flight_No+'</option>';
			
			$("#flight_No").append(option);
			}
			
			
			
		
		
		
		
	});
	
	$("#flight_No").change(function(){
		$.getJSON("getFlightByNo.htm?flight_No="+$(this).val(),function(data){
			$("#source_Airport").val(data.source_Airport.airport_city);
			$("#destination_Airport").val(data.destination_Airport.airport_city);
			
			
			
			
		});
		
		
		
	});

});

function getCity(e)
{
	var x=new XMLHttpRequest();
	var flight_No=e.value;
	var row = e.parentElement.parentElement;
	var url="getFlightByNo.htm";
	x.open('POST',url,true);
	x.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	x.send("flight_No="+flight_No);
	x.onreadystatechange=function(){
		if(x.readyState==4)
			{
				var data=JSON.parse(x.responseText);
				row.children[2].children[0].value=data.source_Airport.airport_city;
				row.children[3].children[0].value=data.destination_Airport.airport_city;
				
			}
		
	}
	

}


function getFlight_No(e)
{
	e.innerHTML="";
	var x=new XMLHttpRequest();
	
	
	var url="viewAllFlight.htm";
	x.open('GET',url,true);
	x.send();
	x.onreadystatechange=function(){
	
		if (x.readyState == 4) {
			var data = JSON.parse(x.responseText);
			
			for (i = 0; i < data.length; i++) {
					
				var option=document.createElement("option");
				option.text=data[i].flight_No;
				option.value=data[i].flight_No;
				e.appendChild(option);
			}

		}
		
	}

}

