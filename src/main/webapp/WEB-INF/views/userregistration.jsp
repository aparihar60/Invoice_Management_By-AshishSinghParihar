<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<link rel="shortcut icon" href="images/impetus.jpg" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>User Registration by Super Admin</title>


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

<body>
	<%@ include file="headersuperadmin.jsp"%>
	&nbsp;&nbsp;
	<br />
	<br />
	<br />
	<br />
	<br />



	<h2 style="font-family: sans-serif; font-size: large; color: black"
		align="center">Admin User Registration</h2>
	<form:form method="post" action="adduserdetail.html"
		onsubmit="return formvalid()" commandName="User">



		<table align="center" cellpadding="6" cellspacing="6">


			<tr>
				<td>${userInsertException}</td>
			</tr>




			<tr>
				<td>User First Name</td>
				<td><input onblur="namevalid()" name="userfname" id="userfname"
					type="text" /> <samp style="color: #FF0000; visibility: hidden"
						id="namereq">Name Required*</samp></td>
			</tr>
			<tr>
				<td>User Last Name</td>
				<td><input name="userlname" type="text" /></td>
			</tr>
			<tr>
				<td>User Login Id</td>
				<td><input onblur="loginvalid()" name="userloginid"
					id="userloginid" type="text" /> <samp id="loginreq"
						style="color: #FF0000; visibility: hidden">Login Id
						Required*</samp></td>
			</tr>
			<tr>
				<td>User Password</td>
				<td><input name="userpassword" id="userpassword"
					type="password" /> <samp id="passreq"
						style="color: #FF0000; visibility: hidden">Password
						Required*</samp></td>
			</tr>


			<tr>
				<td>Confirm Password</td>
				<td><input name="confuserpassword" onblur="matchpassword()"
					id="confuserpassword" type="password" /> <samp id="notmatch"
						style="color: #FF0000; visibility: hidden">Password did not
						match*</samp></td>
			</tr>




			<tr>
				<td>User Email</td>
				<td><input name="useremail" id="useremail" type="text"
					onblur="emailvalid()" /> <samp id="emailreq"
						style="color: #FF0000; visibility: hidden"></samp></td>
			</tr>
			<tr>
				<td>User Contact No</td>
				<td><input name="usercontactno" id="usercontactno" type="text"
					onblur="mobilenovalid()" /> <samp id="mobilereq"
						style="color: #FF0000; visibility: hidden"></samp></td>
			</tr>







			<tr>
				<td>Role</td>
				<td><select name="roleid">
						<option value="2">Admin</option>
						<!-- <option value="3">Normal</option> -->

				</select></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input name="Submit" type="submit" value="submit" /></td>
			</tr>
		</table>
	</form:form>

</body>

</html>