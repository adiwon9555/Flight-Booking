/**
 * 
 */
function getCity(e)
{
	var x=new XMLHttpRequest();
	var city=e.value;
	var dl=document.getElementById(e.name);
	var url="getCity.htm";
	x.open('POST',url,true);
	x.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	x.send("city_name="+city);
	x.onreadystatechange=function(){
		if(x.readyState==4)
			{
				var clist=JSON.parse(x.responseText);
				dl.innerHTML="";
				for(i=0;i<clist.length;i++)
					{
					
					var option=document.createElement("option");
					option.value=clist[i];
					dl.appendChild(option);
					}
				
				
			}
		
	}

}
