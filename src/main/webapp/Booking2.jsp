<%String source=request.getParameter("source");
String destination=request.getParameter("destination");
String date=request.getParameter("date");
String first=request.getParameter("first");
session.setAttribute("source", source);
session.setAttribute("destination", destination);
session.setAttribute("date", date);
session.setAttribute("first", first);

%>
<frameset border="0" rows="20% , 80%">

		<frame src="Booking_header.jsp" name="Booking_header" scrolling="no" noresize="noresize">
	    </frame>


	<frameset cols="13%,77%">
		<frame src="Booking_menu.jsp" name="Booking_menu" scrolling="no" noresize="noresize">
		</frame>
		<frame src="Booking_table.jsp" name="Booking_content" noresize="noresize">
		</frame>


	</frameset>




</frameset>

<script type="text/javascript" src="javascript/angular-1.0.0.js"></script>

<script type="text/javascript" src="javascript/jquery-3.3.1.js"></script>
