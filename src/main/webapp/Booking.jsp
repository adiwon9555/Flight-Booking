<!DOCTYPE html>
<%String source=request.getParameter("source");
String destination=request.getParameter("destination");
String date=request.getParameter("date");
String first=request.getParameter("first");
session.setAttribute("source", source);
session.setAttribute("destination", destination);
session.setAttribute("date", date);
session.setAttribute("first", first);

%>


<html>
<head>
<style>
img {
    opacity: 0.5;
    filter: alpha(opacity=50); /* For IE8 and earlier */
}
</style>
</head>
<body>
<img src="images/1.jpg" alt="Forest" width="100%" height="100%">
 
           
            <div style="position:absolute;top:0;bottom:5px;left:0px;right:0px;">
                <div style="position:relative;height:100%;width:100%;">
                     
                   
                      <iframe  src="Booking_header.jsp" name="Booking_header" scrolling="no" style="border:0px;width:100%;position:absolute;top:0px;left:0px;right:0px;height:100%;"></iframe> 
                    <iframe src="Booking_menu.jsp" name="Booking_menu" scrolling="no" style="border:0px;position:absolute;top:20%;left:0px;bottom:0px;width:20%;height:100%;"></iframe>
                    
                    
                    <div style="position:absolute;top:20%;left:20%;right:1px;bottom:0px;">
                        <iframe src="Booking_table.jsp" name="Booking_content" scrolling="no" style="border:0px;width:100%;height:100%;"></iframe>
                    </div>
                    
                </div>
            </div>
           
          
</body>
</html>
