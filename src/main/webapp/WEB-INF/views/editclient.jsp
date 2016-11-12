<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript">
	function updatesuccess() {
		alert("Data has been successfully Updated");
	}
</script>


<title>Edit Client</title>

</head>

<body>
	<%@ include file="header.jsp"%>
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

	<form:form method="post" action="editcurrentclient.html"
		onsubmit="updatesuccess()" commandName="Client">


		<table align="center"
			style="font-family: sans-serif; font-size: medium;" cellpadding="6"
			cellspacing="6">
			<tr>
				<td>Client First Name</td>
				<td><input name="clientfname" type="text"
					value="${client.clientfname}" /></td>
			</tr>
			<tr>
				<td>Client Last Name</td>
				<td><input name="clientlname" type="text"
					value="${client.clientlname}" /></td>
			</tr>
			<tr>
				<td>Client Address</td>
				<td><input name="clientaddress" type="text"
					value="${client.clientaddress}" /></td>
			</tr>
			<tr>
				<td>Client Email</td>
				<td><input name="clientemail" type="text"
					value="${client.clientemail}" /></td>
			</tr>

			<tr>
				<td>Client Contact No</td>
				<td><input name="clientcontactno" type="text"
					value="${client.clientcontactno}" /></td>
			</tr>

			<tr>
				<td>Client Company</td>
				<td><input name="clientcompany" type="text"
					value="${client.clientcompany}" /></td>
			</tr>

			<tr>

				<td><input name="clientid" type="hidden"
					value="${client.clientid}" /></td>
			</tr>

			<tr>

				<td><input name="tenant.tenantid" type="hidden"
					value="${client.tenant.tenantid}" /></td>
			</tr>

			<tr>
				<td>&nbsp;</td>
				<td><input name="Submit" type="submit" value="submit" /></td>
			</tr>
		</table>
	</form:form>

</body>

</html>