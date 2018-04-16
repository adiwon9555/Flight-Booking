function nameValidation()
{
	var letters=/^[A-Za-z]+[\s|,|-]{0,1}?[A-Za-z]+$/;
	if(document.getElementById("a").value.match(letters))
		{
		document.getElementById("namediv").style.display = "none";
		document.getElementById("passdiv").disabled = false;
		}
	else
	{
		document.getElementById("namediv").style.display = "block";
		document.getElementById("namediv").innerHTML="Enter a valid Name";
		document.getElementById("a").focus();
		document.getElementById("a").value="";
		setTimeout(function () {
	        document.getElementById('namediv').style.display='none';
	    }, 2000);
	}
}
function passValidation()
{
	var letters=/^(?=.+[a-z])(?=.+[A-Z])(?=.+\d)(?=.+[!@#$%^&*])[a-zA-z\d!@#$%^&*]{8,16}$/;
	s=document.getElementById("b");
	if(s.value.match(letters))
	{
		if(s.value.length >=8 )
		{
			document.getElementById("passdiv").style.display = "none";
		}
		else
		{
			document.getElementById("passdiv").style.display = "block";
			document.getElementById("passdiv").innerHTML="Password should be atleast of 8 characters";
		}
	}
	else
	{
		document.getElementById("passdiv").style.display = "block";
		document.getElementById("passdiv").innerHTML="Password should contain 1 upper case letter,1 lower case letter,1 Digit and 1 special character";
		document.getElementById("b").focus();
		document.getElementById("b").value="";
		setTimeout(function () {
	        document.getElementById('passdiv').style.display='none';
	    }, 2000);
	}	
}

function emailValidation()
{
	var letters=/[\w-]+@([\w-]+\.)+[\w-]+/;
	if(document.getElementById("c").value.match(letters))
	{
		document.getElementById("emaildiv").style.display = "none";
	}
	else
	{
		document.getElementById("emaildiv").style.display = "block";
		document.getElementById("emaildiv").innerHTML="Enter a valid email Id";
		document.getElementById("c").focus();
		document.getElementById("c").value="";
		setTimeout(function () {
	        document.getElementById('emaildiv').style.display='none';
	    }, 2000);
	}
}
function passValidation()
{
	var letters=/^(?=.+[a-z])(?=.+[A-Z])(?=.+\d)(?=.+[!@#$%^&*])[a-zA-z\d!@#$%^&*]{8,16}$/;
	s=document.getElementById("b");
	if(s.value.match(letters))
	{
		if(s.value.length >=8 )
		{
			document.getElementById("passdiv").style.display = "none";
		}
		else
		{
			document.getElementById("passdiv").style.display = "block";
			document.getElementById("passdiv").innerHTML="Password should be atleast of 8 characters";
		}
	}
	else
	{
		document.getElementById("passdiv").style.display = "block";
		document.getElementById("passdiv").innerHTML="Password should contain 1 upper case letter,1 lower case letter,1 Digit and 1 special character";
		document.getElementById("b").focus();
		document.getElementById("b").value="";
		setTimeout(function () {
	        document.getElementById('passdiv').style.display='none';
	    }, 2000);
	}	
}
function checkDate(){
    var idate = document.getElementById("date"),
        resultDiv = document.getElementById("datewarn"),
        dateReg = /(0[1-9]|[12][0-9]|3[01])[\/](0[1-9]|1[012])[\/]201[4-9]|20[2-9][0-9]/;

    if(dateReg.test(idate.value)){
        if(isFutureDate(idate.value)){
            resultDiv.innerHTML = "Entered date is a future date";
            resultDiv.style.color = "red";
        } else {
            resultDiv.innerHTML = "It's a valid date";
            resultDiv.style.color = "green";
        }
    } else {
        resultDiv.innerHTML = "Invalid date!";
        resultDiv.style.color = "red";
    }
}