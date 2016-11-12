<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8" />

<link href="css/layout.css" rel="stylesheet" type="text/css" />
<link href="css/menu.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="images/impetus.jpg" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<style type="text/css">
body {

	width: 100%;
	height: 30%;
	/* background-image: url('images/background.jpg'); */
}

button {
	background-color: #336666;
}

#menu {
	margin-left: 20px;
	width: 100%;
	font-family: sans-serif;
	height: 60px;
}

#menu ul li {
	display: inline;
	float: left;
	padding: 20px;
	margin-left: -42px;
}
</style>

<script type="text/javascript">
	function headlogo() {

		var logo = document.getElementById("tenantid").value;
		var rolid = document.getElementById("roleid").value;

		//alert(logo);

		//headerlogo

		{
			document.getElementById("headerlogo").src = "images/${tenant.tenantid}.jpg";

		}

		if (rolid == 3) {
			document.getElementById("edittanent").style.visibility = "hidden";
			document.getElementById("uploadclient").style.visibility = "hidden";
			document.getElementById("manageuser").style.visibility = "hidden";

		}
	}
</script>
</head>
<body style="background-color: wheat" onload="headlogo()">



	<input name="tenantid" id="tenantid" type="hidden"
		value="${tenant.tenantid}" />


	<input name="roleid" id="roleid" type="hidden"
		value="${user.role.roleid}" />




	<div style="width: 244px; float: left">

		<img id="headerlogo" width="140px" height="50px" />


	</div>
	<div style="width: 244px; float: right;">
		<p style="font-family: sans-serif; font-size: larger; color: black;">Welcome:${user.userfname}</p>
		<a
			style="font-family: sans-serif; font-size: large; text-decoration: none; color: blue;"
			href="logout.html">Logout</a>


	</div>
	<br />
	<br />

	<div class="container">

		<ul id="nav">
			<li><a style="font-family: sans-serif; font-size: medium;"
				href="dashboard.html">Dashboard</a></li>
			<li><a style="font-family: sans-serif; font-size: medium;"
				class="hsubs" href="#">Invoices</a>
				<ul class="subs">
					<li><a style="font-family: sans-serif; font-size: medium;"
						href="invoice.html">Create Invoices</a></li>
					<li><a style="font-family: sans-serif; font-size: medium;"
						class="hsubs" href="recurringinvoice.html">Create Recurring
							Invoice</a></li>
					<li><a style="font-family: sans-serif; font-size: medium;"
						href="invoicelist.html">View All Invoices</a></li>
					<li><a style="font-family: sans-serif; font-size: medium;"
						href="unpaidinvoicelist.html">View Unpaid Invoices</a></li>
					<li><a style="font-family: sans-serif; font-size: medium;"
						href="searchinvoice.html">Search Invoices</a></li>
					<li><a style="font-family: sans-serif; font-size: medium;"
						class="hsubs" href="excel.html">Download Invoices</a>
				</ul></li>



			<li><a style="font-family: sans-serif; font-size: medium;"
				class="hsubs" href="item.html">Items</a></li>
			<li><a style="font-family: sans-serif; font-size: medium;"
				class="hsubs" href="client.html">Clients</a></li>

			<li><a style="font-family: sans-serif; font-size: medium;"
				class="hsubs" href="updateprofile.html">Update Profile</a>
			<li id="edittanent" style="visibility: visible"><a
				style="font-family: sans-serif; font-size: medium;" class="hsubs"
				href="#">Admin Tasks</a>



				<ul class="subs">
					<li id="edittanent" style="visibility: visible"><a
						style="font-family: sans-serif; font-size: medium;" class="hsubs"
						href="edittenant.html?tenantId=${tenant.tenantid}">Edit Tenant
							Info</a></li>

					<li id="uploadclient" style="visibility: visible"><a
						style="font-family: sans-serif; font-size: medium;" class="hsubs"
						href="uploadclient.html">Upload Clients XML File</a></li>

					<li id="manageuser" style="visibility: visible"><a
						style="font-family: sans-serif; font-size: medium;" class="hsubs"
						href="normaluser.html">Normal Users</a></li>

				</ul></li>

			<div id="lavalamp"></div>
</body>

</html>