/**
 * 
 */
function viewAllFlight() {
	var app = angular.module("admin_app", []);
	app.controller("admin_ctrl", function($scope, $http) {
		
		
		$http.get('viewAllFlight.htm').success(function(data) {
			$scope.flight_list = data;
		
		
		
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
		row.children[0].innerHTML="<input type='number' id='flight_No_edit' name='flight_No' style='width: 80px' placeholder='flight_No' value='"+value[0]+"' readonly='readonly'>";
		row.children[1].innerHTML="<input type='text' id='flight_Name_edit' name='flight_Name' style='width: 90px' placeholder='flight_Name' value='"+value[1]+"' required>";
		row.children[2].innerHTML="<input type='time' id='departure_Time_edit' name='departure_Time' style='width: 80px' placeholder='departure_Time' value='"+value[2]+"' required>";
		row.children[3].innerHTML="<input type='time' id='arrival_Time_edit' name='arrival_Time' style='width: 80px' placeholder='arrival_Time' value='"+value[3]+"' required>";
		row.children[4].innerHTML="<input type='number' id='flight_Price_edit' name='flight_Price' style='width: 60px' placeholder='flight_Price' value='"+value[4]+"' required>";
		row.children[5].innerHTML="<select id='source_edit' name='source' required onfocus='getCity(this)'><option value="+value[5]+">"+value[5]+"</option></select>";
		row.children[6].innerHTML="<select id='destination_edit' name='destination' required onfocus='getCity(this)'><option value="+value[6]+">"+value[6]+"</option></select>";	
		
		row.children[7].innerHTML="<input type=checkbox id='days_edit_mon' value='Monday' name='days' autocomplete='off'>Mo "+
						"<input type=checkbox id='days_edit_tue' value='Tuesday' name='days' autocomplete='off'>Tu "+
						"<input type=checkbox id='days_edit_wed' value='Wednesday' name='days' autocomplete='off'>We"+
						"<input type=checkbox value='Thursday' id='days_edit_thu' name='days' autocomplete='off'>Th"+
						"<input type=checkbox value='Friday' id='days_edit_fri' name='days' autocomplete='off'>Fr"+
						"<input type=checkbox value='Saturday' id='days_edit_sat' name='days' autocomplete='off'>Sa"+
						"<input type=checkbox value='Sunday' id='days_edit_sun' name='days' autocomplete='off'>Su";
		
		
		row.children[8].innerHTML="<button class='update_button' onclick=update_flight(this)>Update</button>";
		row.children[9].innerHTML="<input type='button' onclick=cancel_update(this) value='cancel' class='button' id='cancel_update'>";
		if(value[7].includes("Monday"))
			{
			document.getElementById("days_edit_mon").checked=true;
			}
		if(value[7].includes("Tuesday"))
		{
		document.getElementById("days_edit_tue").checked=true;
		}
		if(value[7].includes("Wednesday"))
		{
		document.getElementById("days_edit_wed").checked=true;
		}
		if(value[7].includes("Thursday"))
		{
		document.getElementById("days_edit_thu").checked=true;
		}
		if(value[7].includes("Friday"))
		{
		document.getElementById("days_edit_fri").checked=true;
		}
		
		if(value[7].includes("Saturday"))
		{
		document.getElementById("days_edit_sat").checked=true;
		}
		if(value[7].includes("Sunday"))
		{
		document.getElementById("days_edit_sun").checked=true;
		}
	
		
		document.getElementById("flight_Name_edit").focus();
	
}
function update_flight(e)
{
	var uval=new Array();
	var row = e.parentElement.parentElement;
	for(var i=0;i<row.childElementCount-3;i++)
	{
		
		uval[i]=row.children[i].children[0].value;
		
		
	}
	var arr=new Array();
	
		var i=0;
		if (row.children[7].children[0].checked == true) {
			arr[i] = "Monday";
			i++;
		}
		if (row.children[7].children[1].checked == true) {
			arr[i] = "Tuesday";
			i++;
		}
		if (row.children[7].children[2].checked == true) {
			arr[i] = "Wednesday";
			i++;
		}
		if (row.children[7].children[3].checked == true) {
			arr[i] = "Thursday";
			i++;
		}
		if (row.children[7].children[4].checked == true) {
			arr[i] = "Friday";
			i++;
		}
		if (row.children[7].children[5].checked == true) {
			arr[i] = "Saturday";
			i++;
		}
		if (row.children[7].children[6].checked == true) {
			arr[i] = "Sunday";
			i++;
		}
		


	
	
	
	link="editFlight.htm?flight_No="+uval[0]+"&flight_Name="+uval[1]+"&departure_Time="+uval[2]+"&arrival_Time="+uval[3]+"&flight_Price="+uval[4]+"&source="+uval[5]+"&destination="+uval[6]+"&days="+arr;
	location.href=link;
}

function cancel_update(e)
{
	var row = e.parentElement.parentElement;
	for(var i=0;i<row.childElementCount-2;i++)
	{
		
		row.children[i].innerHTML=value[i];
		
		
	}
	

	row.children[8].innerHTML="<a  href='deleteFlight.htm?flight_No="+value[0]+"'><button  class='button' label='delete'>delete</button></a>"
	row.children[9].innerHTML="<button class='edit_button' onclick=edit_row(this)>Edit</button>"
	
}
$(document).ready(function(){
	
	$("button.add_flight").click(function(){
		$("table#flight_reg").show();
		$("input#flight_Name").focus();
		var dl=document.getElementById("source");
		getCity(dl);
		var l=document.getElementById("destination");
		getCity(l);
	});
	
	
	$("#cancel_button").click(function(){
		$("table#flight_reg").hide();
		
	});
	
	
	
	
});



function getCity(e)
{
	var x=new XMLHttpRequest();
	var city=e.value;
	
	var url="getCity.htm";
	x.open('POST',url,true);
	x.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	x.send("city_name="+"");
	x.onreadystatechange=function(){
		if(x.readyState==4)
			{
				var clist=JSON.parse(x.responseText);
				e.innerHTML="";
				for(i=0;i<clist.length;i++)
					{
					
					var option=document.createElement("option");
					option.text=clist[i];
					option.value=clist[i];
					e.appendChild(option);
					}
				
				
			}
		
	}

}