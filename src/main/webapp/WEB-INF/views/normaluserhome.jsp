<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Normal User Home</title>
<style type="text/css">
#menu ul li {
	display: inline;
	float: left;
	padding: 30px;
	;
}
</style>

<script type="text/javascript">
	function headlogo() {

		var logo = document.getElementById("tenantid").value;

		if (logo == 45) {
			document.getElementById("headerlogo").src = "images/45.png";

		} else if (logo == 46) {
			document.getElementById("headerlogo").src = "images/46.jpg";
		}
	}
</script>
</head>
<body onload="headlogo()">

	<input name="tenantid" id="tenantid" type="hidden"
		value="${tenant.tenantid}" />

	<div style="width: 244px; float: left">

		<img id="headerlogo" width="200px" height="80px"
			src="images/notuploaded.jpg" />


	</div>
	<div style="width: 244px; float: right">
		<input type="text" name="search" id="search" /> &nbsp;&nbsp;<input
			type="button" value="Search" /> <a href="logout.html">logout</a>


	</div>
	<br />
	<br />

	<div id="menu" style="width: 100%;">
		<ul>
			<li><a href="dashboard.html"> Dashboard</a></li>
			<li><a href="invoice.html">Invoice</a></li>
			<li><a href="recurringinvoice.html">Recurring Invoice</a></li>
			<li><a href="item.html">Items</a></li>
			<li><a href="client.html">Clients</a></li>





		</ul>
	</div>


</body>

</html>