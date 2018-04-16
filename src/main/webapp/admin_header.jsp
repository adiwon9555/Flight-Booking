<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body
{
 background-image:url("images/images.jpg");
 background-repeat:no-repeat;
 background-size:100% 100%; 
}
h1   { 
          color: blue;
          text-align: center;
          text-decoration: underline;
          font-size: 500%;
      		margin-top:-0.1%;
          text-shadow: 3px 2px red;
}

a
{
font-size: 40px;
position: absolute;
font-style: italic;
}

a:hover
{
color:red;
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function preventBack(){
window.history.forward();
}

setTimeout("preventBack()",0);
window.onunload=function(){null};
</script>
</head>
<body>
<a href="logout.htm" target="_parent">Udaan</a>
<center>
<h1>Admin Page</h1>
</center>
</body>
</html>