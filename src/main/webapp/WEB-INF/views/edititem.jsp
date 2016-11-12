
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Item</title>
<script type="text/javascript">
	function updatesuccess() {
		alert("Data has been successfully Updated");
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
	<form:form method="post" action="editcurrentitem.html"
		onsubmit="updatesuccess()" commandName="Item">



		<table align="center"
			style="font-family: sans-serif; font-size: medium;" cellpadding="6"
			cellspacing="6">
			<tr>
				<td>Item Name</td>
				<td><input name="itemname" type="text" value="${item.itemname}" />
				</td>
			</tr>
			<tr>
				<td>Item Price</td>
				<td><input name="itemprice" type="text"
					value="${item.itemprice}" /></td>
			</tr>

			<tr>

				<td><input name="itemid" type="hidden" value="${item.itemid}" />
				</td>
			</tr>

			<tr>

				<td><input name="tenant.tenantid" type="hidden"
					value="${item.tenant.tenantid}" /></td>
			</tr>

			<tr>
				<td>&nbsp;</td>
				<td><input name="Submit" type="submit" value="Submit" /></td>
			</tr>


		</table>
	</form:form>
</body>
</html>