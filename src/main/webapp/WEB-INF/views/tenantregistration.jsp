
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="images/impetus.jpg" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tenant Registration</title>
<script type="text/javascript">
	function validname() {
		var a = document.getElementById("tenantname").value;
		if (a == "" || a == null) {
			document.getElementById("namerequired").style.visibility = "visible";
			return false;
		}

		document.getElementById("namerequired").style.visibility = "hidden";
		return true;
	}

	function formvalid() {
		var a = document.getElementById("tenantname").value;
		if (a == "" || a == null) {
			document.getElementById("namerequired").style.visibility = "visible";
			return false;
		}

	}
</script>
</head>
<body style="background-color: wheat">
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<h2 align="center">Tenant Registration</h2>
	<form:form method="post" action="registrationsuccess.html"
		onsubmit="return formvalid()" commandName="Tenant">
		<table align="center" cellpadding="6" cellspacing="6">
			<tr>
				<td>Tenant Name</td>
				<td><input name="tenantname" id="tenantname"
					onblur="validname()" type="text" /> <samp id="namerequired"
						style="color: #FF0000; visibility: hidden">Name Required*</samp></td>
			</tr>
			<tr>
				<td>Tenant Email</td>
				<td><input name="tenantemail" type="text" /></td>
			</tr>



			<tr>
				<td>Tenant Address</td>
				<td><input name="tenantaddress" type="text" /></td>
			</tr>

			<tr>
				<td>Reminder Mail</td>
				<td><select name="remindermail">
						<option value="0">No</option>
						<option value="1">Yes</option>
				</select></td>
			</tr>


			<tr>
				<td>Thank You Mail</td>
				<td><select name="thankyoumail">
						<option value="0">No</option>
						<option value="1">Yes</option>
				</select></td>
			</tr>



			<tr>
				<td>Currency Format</td>
				<td><select name="currencyformat">
						<option value="&#8377;">INR</option>

						<option value="$">USD</option>
				</select></td>
			</tr>


			<tr>
				<td>&nbsp;</td>
				<td><input name="Submit" type="submit" value="submit" /> <input
					name="reset" type="reset" value="reset" /></td>

			</tr>



		</table>
	</form:form>

	<br />


</body>
</html>
