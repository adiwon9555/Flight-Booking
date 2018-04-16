

function checkname(e)
{
var name=e.value;
var message=document.getElementById("message");

	if(name.length==0 || name.length<=4 || name.length>8)
	{
		message.innerHTML="Invalid name"
			e.focus();
	}
	else
		{
		message.innerHTML="<br>"
		e.blur();
		}
}
function checkpass(e)
{
var pass=e.value;
var passw = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;  
var message=document.getElementById("message");

	if(pass.match(passw))
	{
		message.innerHTML="<br>"
			e.blur();
			
			
	}
	else
		{
		message.innerHTML="Enter password between 6 to 20 characters which contain at least one numeric digit, one uppercase, and one lowercase letter."
			e.focus();
		}
}

function checkphone(e)
{
	
var phone=e.value;
		if(document.getElementById("eval").innerText == "Phone already exist")
		{
		
		e.focus();
		
		}
		else
			{
			message.innerHTML="<br>";
			document.getElementById("eval").innerHTML="";
				e.blur();
			}	
				
}


function checkemail(e)
{
	
var email=e.value;
var message=document.getElementById("message");
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
	if(email.match(mailformat))  
	{
		
		if(document.getElementById("eval").innerText == "Email already exist")
		{
		
		e.focus();
		
		}
		else
			{
			message.innerHTML="<br>";
			document.getElementById("eval").innerHTML="";
				e.blur();
			}	
				
			
	}
	else
		{
		message.innerHTML="Invalid email format";
			e.focus();
		}
}
function enterstate(e)
{
	
var state=document.getElementById("state");
state.style.display="inline";
if(e.value=="India")
	{
	state.innerHTML="<option>Assam</option><option>Karnataka</option><option>West Bengal</option><option>Goa</option>"
	}
if(e.value=="US")
{
	state.innerHTML="<option>Arizona</option><option>California</option><option>Las Vegas</option><option>Ohio</option>"
	}


}

function cap() {
	abc=0;
	x = Math.floor(100000 + Math.random() * 900000);
	document.getElementById("cap").innerHTML = x;
	};
function capver(e){
	var y=document.getElementById("captcha").value;
	console.log(abc);
	if(y!=x){
		message.innerHTML="<font color=red>Enter Captcha properly</font>";
		document.getElementById("captcha").innerHTML="";
		e.focus();
	
	}else{
		message.innerHTML="<font color=green>Captcha verified</font>";
		abc = 1; 
		
		e.blur();
	}
	
	
}



function validateEmailServer()
{
	
	
	var x=new XMLHttpRequest();
	var email=document.getElementById("email").value;
	var url="validate_email.htm?email="+email;
	x.open('GET',url,true);
	x.send();
	x.onreadystatechange=function(){
		if(x.readyState==4)
			{
				emailcheck=x.responseText;
				document.getElementById("eval").innerHTML="<font color=red>"+emailcheck+"</font>";
				
			}
		
		
	}

}
function validatePhoneServer(e)
{
	
	
	var x=new XMLHttpRequest();
	var phone=e.value;
	var url="validate_phone.htm";
	x.open('POST',url,true);
	x.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	x.send("phone="+phone);
	x.onreadystatechange=function(){
		if(x.readyState==4)
			{
				check=x.responseText;
				document.getElementById("eval").innerHTML="<font color=red>"+check+"</font>";
				
			}
		
		
	}

}

