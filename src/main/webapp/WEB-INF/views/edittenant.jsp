<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.impetus.invc_mgmt.model.User"%>
<%User user=((User)session.getAttribute("user")); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Edit Tenant</title>

<script type="text/javascript">
	function updatesuccess() {
		alert("Changes successfully updated");
	}
</script>

<script type="text/javascript">
	function namevalid() {
		var n = document.getElementById("fileToUpload").value;
		if (n == "" || n == null) {
			document.getElementById("namereq").style.visibility = "visible";
			return false;

		}

		else {

			document.getElementById("namereq").style.visibility = "hidden";
			return true;

		}
	}

	
	

	function formvalid() {

		var nameresult = namevalid();
	

		if (nameresult == false) {

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
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<p align="center"
		style="color: black; font-family: sans-serif; font-size: large;">Edit
		Tenant Info</p>

	<form:form method="post" action="editcurrenttenant.html"
		onsubmit="updatesuccess()" commandName="Tenant">


		<table style="font-family: sans-serif; font-size: medium;"
			align="center" cellpadding="6" cellspacing="6">
			<tr>
				<td>Reminder Mail</td>
				<td><select name="remindermail">
						<option value="0" <%if(user.getTenant().getRemindermail()==0) { %>
							selected="selected" <%}%>>No</option>
						<option value="1" <%if(user.getTenant().getRemindermail()==1) { %>
							selected="selected" <%}%>>Yes</option>
				</select></td>
			</tr>


			<tr>
				<td>Thank You Mail</td>
				<td><select name="thankyoumail">
						<option value="0" <%if(user.getTenant().getThankyoumail()==0) { %>
							selected="selected" <%}%>>No</option>
						<option value="1" <%if(user.getTenant().getThankyoumail()==1) { %>
							selected="selected" <%}%>>Yes</option>
				</select></td>
			</tr>



			<tr>
				<td>Currency Format</td>
				<td><select name="currencyformat">
						<option value="&#8377;"
							<%if(user.getTenant().getCurrencyformat().equals("&#8377;")) { %>
							selected="selected" <%}%>>INR</option>

						<option value="$"
							<%if(user.getTenant().getCurrencyformat().equals("$")) { %>
							selected="selected" <%}%>>USD</option>
				</select></td>
			</tr>

			<tr>
				<td>&nbsp;</td>
				<td><input name="Submit" type="submit" value="submit" /></td>


				<td><input name="tenantid" type="hidden"
					value="${tenant.tenantid}" /></td>

				<td><input name="tenantname" type="hidden"
					value="${tenant.tenantname}" /></td>
				<td><input name="tenantemail" type="hidden"
					value="${tenant.tenantemail}" /></td>
				<td><input name="tenantcontactno" type="hidden"
					value="${tenant.tenantcontactno}" /></td>

				<td><input name="tenantaddress" type="hidden"
					value="${tenant.tenantaddress}" /></td>

			</tr>


		</table>
&nbsp;&nbsp;;

</form:form>

	<form:form modelAttribute="uploadForm" method="post"
		onsubmit="return formvalid()" action="tenantlogo.html"
		enctype="multipart/form-data">

		<table style="font-family: sans-serif; font-size: medium;"
			id="fileTable" align="center">
			<tr>
				<td>select company logo</td>
				<td><input onblur="namevalid()" id="fileToUpload"
					name="fileToUpload" type="file" /> <samp
						style="color: #FF0000; visibility: hidden" id="namereq">Select
						some file*</samp></td>
			</tr>
			<tr>
				<td><p align="right">
						<input type="submit" value="Upload" />
					</p></td>



			</tr>

		</table>
		<br />


	</form:form>

</body>

</html>