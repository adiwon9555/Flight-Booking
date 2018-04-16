/**
 * 
 */
function viewAllCustomer() {
	var app = angular.module("admin_customer_app", []);
	app.controller("admin_customer_ctrl", function($scope, $http) {
		
		
		$http.get('viewAllCustomer.htm').success(function(info) {
			$scope.customer_list = info;
			
		
		
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
		row.children[0].innerHTML="<input type='text' id='id_edit' name='id' style='width: 50px' value='"+value[0]+"' placeholder='id' readonly='readonly' required>";
		row.children[1].innerHTML="<input type='text' id='name_edit' name='name' style='width: 80px' value='"+value[1]+"' placeholder='name' required>";
		row.children[2].innerHTML="<input type='text' id='password_edit' name='password' style='width: 80px' value='"+value[2]+"' placeholder='password' required>";
		row.children[3].innerHTML="<input type='email' id='email_edit' name='email' style='width: 105px' value='"+value[3]+"' placeholder='email' required>";
		row.children[4].innerHTML="<input type='number' id='phone_edit' name='phone' style='width: 90px' value='"+value[4]+"' placeholder='number' required>";
		row.children[5].innerHTML="<input type='text' id='address_edit' name='address' style='width: 85px' value='"+value[5]+"' placeholder='address' required>";
		row.children[6].innerHTML="<input type='number' id='age_edit' name='age' style='width: 40px' value='"+value[6]+"' placeholder='age' required>";
		row.children[7].innerHTML="<input type='date' id='dob_edit' name='dob' style='width: 125px' value='"+value[7]+"' placeholder='dob' required>";
		row.children[8].innerHTML="<input type='text' id='country_edit' name='country' style='width: 70px' value='"+value[8]+"' placeholder='country' required>";
		row.children[9].innerHTML="<input type='text' id='state_edit' name='state' style='width: 85px' value='"+value[9]+"' placeholder='state' required>";
		row.children[10].innerHTML="<input type='text' id='gender_edit' name='gender' style='width: 50px' value='"+value[10]+"' placeholder='gender' required>";
		row.children[11].innerHTML="<button class='update_button' onclick=update_customer(this)>Update</button>";
		row.children[12].innerHTML="<input type='button' onclick=cancel_update(this) class='button' value='cancel' id='cancel_update'>";
		document.getElementById("name_edit").focus();
	
}
function update_customer(e)
{
	var uval=new Array();
	var row = e.parentElement.parentElement;
	for(var i=0;i<row.childElementCount-2;i++)
	{
		
		uval[i]=row.children[i].children[0].value;
		
		
	}
	
	link="editCustomer.htm?id="+uval[0]+"&name="+uval[1]+"&password="+uval[2]+"&email="+uval[3]+"&phone="+uval[4]+"&address="+uval[5]+"&age="+uval[6]+"&dob="+uval[7]+"&country="+uval[8]+"&state="+uval[9]+"&gender="+uval[10];
	location.href=link;
}

function cancel_update(e)
{
	var row = e.parentElement.parentElement;
	for(var i=0;i<row.childElementCount-2;i++)
	{
		
		row.children[i].innerHTML=value[i];
		
		
	}
	

	row.children[11].innerHTML="<a  href='deleteCustomer.htm?id="+value[0]+"'><button  class='button' label='delete'>delete</button></a>"
	row.children[12].innerHTML="<button class='edit_button' onclick=edit_row(this)>Edit</button>"
	
}
$(document).ready(function(){
	
	$("button.add_customer").click(function(){
		$("table#customer_reg").show();
		$("input#name").focus();
	});
	
	
	$("#cancel_button").click(function(){
		$("table#customer_reg").hide();
		
	});
	
	
	
	
});



