/**
 * 
 */
function viewAllAirport() {
	var app = angular.module("admin_airport_app", []);
	app.controller("admin_airport_ctrl", function($scope, $http) {
		$http.get('viewAllAirport.htm').success(function(data) {
			$scope.airport_list = data;
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
		row.children[0].innerHTML="<input type='number' id='airport_id_edit' name='airport_id' style='width: 80px' placeholder='airport_id' value='"+value[0]+"' readonly='readonly'>";
		row.children[1].innerHTML="<input type='text' id='airport_name_edit' name='airport_name' style='width: 132px' placeholder='airport_name' value='"+value[1]+"' required>";
		row.children[2].innerHTML="<input type='text' id='airport_short_name_edit' name='airport_short_name' style='width: 60px' placeholder='short_name' value='"+value[2]+"' required>";
		row.children[3].innerHTML="<input type='text' id='airport_city_edit' name='airport_city' style='width: 80px' placeholder='airport_city' value='"+value[3]+"' required>";
		row.children[4].innerHTML="<button class='update_button'  onclick=update_airport(this)>Update</button>";
		row.children[5].innerHTML="<input type='button'  onclick=cancel_update(this) class='button' value='cancel' id='cancel_update'>";
		document.getElementById("airport_name_edit").focus();
	
}
function update_airport(e)
{
	var uval=new Array();
	var row = e.parentElement.parentElement;
	for(var i=0;i<row.childElementCount-2;i++)
	{
		
		uval[i]=row.children[i].children[0].value;
		
		
	}
	
	link="editAirport.htm?airport_id="+uval[0]+"&airport_name="+uval[1]+"&airport_short_name="+uval[2]+"&airport_city="+uval[3];
	location.href=link;
}

function cancel_update(e)
{
	var row = e.parentElement.parentElement;
	for(var i=0;i<row.childElementCount-2;i++)
	{
		
		row.children[i].innerHTML=value[i];
		
		
	}
	

	row.children[4].innerHTML="<a  href='deleteAirport.htm?airport_id="+value[0]+"'><button  class='button' label='delete'>delete</button></a>"
	row.children[5].innerHTML="<button  class='edit_button' onclick=edit_row(this)>Edit</button>"
	
}
$(document).ready(function(){
	
	$("button.add_airport").click(function(){
		$("table#airport_reg").show();
		$("input#airport_name").focus();
	});
	
	
	$("#cancel_button").click(function(){
		$("table#airport_reg").hide();
		
	});
	
	
	
});

