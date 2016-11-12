
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8" />

<link href="css/layout.css" rel="stylesheet" type="text/css" />
<link href="css/menu.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="images/impetus.jpg" />


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Normal User</title>


<!--  <script type="text/javascript">
	function updatesuccess() {
		alert("Profile Updated");
	}
</script>  -->

<script type="text/javascript">
	function namevalid() {
		var n = document.getElementById("userfname").value;
		if (n == "" || n == null) {
			document.getElementById("namereq").style.visibility = "visible";
			return false;

		}

		else {

			document.getElementById("namereq").style.visibility = "hidden";
			return true;

		}
	}

	function loginvalid() {
		var l = document.getElementById("userloginid").value;
		if (l == "" || l == null)

		{
			document.getElementById("loginreq").style.visibility = "visible";

			return false;
		}

		else {
			document.getElementById("loginreq").style.visibility = "hidden";
			return true;

		}
	}

	function matchpassword() {

		var p1 = document.getElementById("userpassword").value;
		var p2 = document.getElementById("confuserpassword").value;

		if (p1 == "" || p1 == null) {
			document.getElementById("passreq").style.visibility = "visible";
			return false;

		}

		if (p1 != p2) {
			document.getElementById("passreq").style.visibility = "hidden";

			document.getElementById("notmatch").style.visibility = "visible";

			return false;
		} else {

			document.getElementById("passreq").style.visibility = "hidden";
			document.getElementById("notmatch").style.visibility = "hidden";
			return true;
		}

	}

	function emailvalid() {
		var n = document.getElementById("useremail").value;
		var emailpath = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;

		var matchchofemail = n.match(emailpath);

		if (n == "" || n == null) {

			document.getElementById("emailreq").innerHTML = "Email Required*";
			document.getElementById("emailreq").style.visibility = "visible";
			return false;

		}

		if (matchchofemail == null)

		{
			document.getElementById("emailreq").innerHTML = "Enter valid email ID";
			document.getElementById("emailreq").style.visibility = "visible";
			return false;
		}

		else {

			document.getElementById("emailreq").style.visibility = "hidden";
			return true;

		}
	}

	function mobilenovalid() {
		var n = document.getElementById("usercontactno").value;

		var mobilenolength = n.length;

		if (n == "" || n == null) {

			document.getElementById("mobilereq").innerHTML = "Mobile No Required*";
			document.getElementById("mobilereq").style.visibility = "visible";
			return false;

		}

		else if (isNaN(n))

		{
			document.getElementById("mobilereq").innerHTML = "Alphabatic character not allowed";

			document.getElementById("mobilereq").style.visibility = "visible";
			return false;

		}

		else if (mobilenolength != 10)

		{

			document.getElementById("mobilereq").innerHTML = "Enter 10 digit mobile number allowed e.g. '0123456789'";
			document.getElementById("mobilereq").style.visibility = "visible";
			return false;

		}

		else {
			document.getElementById("mobilereq").innerHTML = "";
			document.getElementById("mobilereq").style.visibility = "hidden";
			return true;

		}

	}

	function formvalid() {
		var passresult = matchpassword();

		var loginresult = loginvalid();
		var nameresult = namevalid();

		var emailresult = emailvalid();

		var mobileresult = mobilenovalid();

		if (passresult == false || nameresult == false || loginresult == false
				|| emailresult == false || mobileresult == false) {

			return false;
		} else {

			return true;

		}

	}
</script>

</head>
<body style="background-color: wheat">
	<input name="tenantid" id="tenantid" type="hidden"
		value="${tenant.tenantid}" />


	<input name="roleid" id="roleid" type="hidden"
		value="${user.role.roleid}" />




	<div style="width: 244px; float: left">

		<img id="headerlogo" width="140px" height="50px" />


	</div>
	<div style="width: 244px; float: right;">
		<p style="font-family: sans-serif; font-size: larger; color: silver;">Welcome:${user.userfname}</p>
		<a
			style="font-family: sans-serif; font-size: large; text-decoration: none; color: white;"
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

				</ul></li>



			<li><a style="font-family: sans-serif; font-size: medium;"
				class="hsubs" href="item.html">Items</a></li>
			<li><a style="font-family: sans-serif; font-size: medium;"
				class="hsubs" href="client.html">Clients</a></li>
			<li><a style="font-family: sans-serif; font-size: medium;"
				class="hsubs" href="excel.html">Download</a>
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

			&nbsp;&nbsp;

			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<br />
			<form:form method="post" action="editprofile.html"
				onsubmit="return formvalid()" commandName="User">



				<table align="center" cellpadding="6" cellspacing="6"
					style="font-family: sans-serif; font-size: medium;">

					<tr>
						<td>User Login Id</td>
						<td><input name="userloginid" style="background-color: gray"
							type="text" readonly="readonly" onblur="loginvalid()"
							id="userloginid" value="${user.userloginid}" />
						<samp id="loginreq" style="color: #FF0000; visibility: hidden">Login
								Id Required*</samp></td>
					</tr>
					<tr>
						<td>User First Name</td>
						<td><input name="userfname" type="text" onblur="namevalid()"
							id="userfname" value="${user.userfname}" />
						<samp style="color: #FF0000; visibility: hidden" id="namereq">Name
								Required*</samp></td>
					</tr>

					<tr>
						<td>User Last Name</td>
						<td><input name="userlname" type="text"
							value="${user.userlname}" /></td>
					</tr>

					<tr>
						<td>User Password</td>
						<td><input name="userpassword" id="userpassword"
							type="password" value="${user.userpassword}" /> <samp
								id="passreq" style="color: #FF0000; visibility: hidden">Password
								Required*</samp></td>
					</tr>


					<tr>
						<td>Confirm Password</td>
						<td><input name="confuserpassword" onblur="matchpassword()"
							id="confuserpassword" type="password"
							value="${user.userpassword}" /> <samp id="notmatch"
								style="color: #FF0000; visibility: hidden">Password did
								not match*</samp></td>
					</tr>
					<tr>
						<td>User Email</td>
						<td><input name="useremail" type="text" id="useremail"
							onblur="emailvalid()" value="${user.useremail}" />
						<samp id="emailreq" style="color: #FF0000; visibility: hidden"></samp></td>
					</tr>
					<tr>
						<td>User Contact No</td>
						<td><input name="usercontactno" type="text"
							id="usercontactno" onblur="mobilenovalid()"
							value="${user.usercontactno}" />
						<samp id="mobilereq" style="color: #FF0000; visibility: hidden"></samp></td>
					</tr>


					<tr>

						<td><input name="userid" type="hidden" value="${user.userid}" />
						</td>
					</tr>

					<tr>

						<td><input name="tenant.tenantid" type="hidden"
							value="${user.tenant.tenantid}" /></td>
					</tr>
					<tr>

						<td><input name="role.roleid" type="hidden"
							value="${user.role.roleid}" /></td>
					</tr>


					<tr>
						<td>&nbsp;</td>
						<td><input name="Submit" type="submit" value="Submit" /></td>
					</tr>


				</table>
			</form:form>
</body>
</html>