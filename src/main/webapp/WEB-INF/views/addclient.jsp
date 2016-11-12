<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Add Client Detail</title>

<style type="text/css">
.errors {
	color: #ff0000;
	font-style: italic;
}
</style>

<script type="text/javascript">
	function namevalid() {
		var n = document.getElementById("clientfname").value;
		if (n == "" || n == null) {
			document.getElementById("namereq").style.visibility = "visible";
			return false;

		}

		else {

			document.getElementById("namereq").style.visibility = "hidden";
			return true;

		}
	}

	function emailvalid() {
		var n = document.getElementById("clientemail").value;
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
		var n = document.getElementById("clientcontactno").value;

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

		var nameresult = namevalid();
		var emailresult = emailvalid();

		var mobileresult = mobilenovalid();

		if (nameresult == false || emailresult == false
				|| mobileresult == false) {

			return false;
		} else {

			return true;
		}

	}
</script>

</head>

<body>
	<%@ include file="header.jsp"%>
	&nbsp;&nbsp;
	<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
	<p style="color: black; font-family: sans-serif; font-size: x-large;"
		align="center">Client Registration</p>
	<form:form method="post" action="insertclient.html"
		 commandName="client">


		<table style="font-family: sans-serif; font-size: medium;"
			align="center" cellpadding="6" cellspacing="6">
			<tr>
				<td>Client First Name</td>
				<td><input onblur="namevalid()" id="clientfname"
					name="clientfname" type="text" value="${client.clientfname}" /> <samp
						style="color: #FF0000; visibility: hidden" id="namereq">First
						Name Required*</samp></td>
						<td align="center"><form:errors path="clientfname" cssClass="errors" /></td>
			</tr>
			<tr>
				<td>Client Last Name</td>
				<td><input name="clientlname" type="text"
					value="${client.clientlname}" /></td>
					<td align="center"><form:errors path="clientlname" cssClass="errors" /></td>
					
			</tr>
			<tr>
				<td>Client Address</td>
				<td><input name="clientaddress" type="text"
					value="${client.clientaddress}" /></td>
					<td align="center"><form:errors path="clientaddress" cssClass="errors" /></td>
					
			</tr>
			<tr>
				<td>Client Email</td>
				<td><input onblur="emailvalid()" id="clientemail"
					name="clientemail" type="text" value="${client.clientemail}" /> <samp
						style="color: #FF0000; visibility: hidden" id="emailreq">Email
						Required*</samp></td>
						<td align="center"><form:errors path="clientemail" cssClass="errors" /></td>
						
			</tr>

			<tr>
				<td>Client Contact No</td>
				<td><input onblur="mobilenovalid()" name="clientcontactno"
					id="clientcontactno" type="text" value="${client.clientcontactno}" />

					<samp style="color: #FF0000; visibility: hidden" id="mobilereq"></samp>

				</td>
				<td align="center"><form:errors path="clientcontactno" cssClass="errors" /></td>
				
			</tr>

			<tr>
				<td>Client Company</td>
				<td><input name="clientcompany" type="text"
					value="${client.clientcompany}" /></td>
					<td align="center"><form:errors path="clientcompany" cssClass="errors" /></td>
					
			</tr>


			<tr>
				<td>&nbsp;</td>
				<td><input name="Submit" type="submit" value="submit" /> <input
					name="reset" type="reset" value="reset" /></td>
			</tr>


		</table>
	</form:form>

</body>

</html>