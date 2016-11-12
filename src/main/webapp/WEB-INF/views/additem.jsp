
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Item Detail</title>

<script type="text/javascript">
	function namevalid() {
		var n = document.getElementById("itemname").value;
		if (n == "" || n == null) {
			document.getElementById("namereq").style.visibility = "visible";
			return false;

		}

		else {

			document.getElementById("namereq").style.visibility = "hidden";
			return true;

		}
	}

	function pricevalid() {
		var n = document.getElementById("itemprice").value;

		if (n == "" || n == null) {

			document.getElementById("pricereq").innerHTML = "Price can not be null*";
			document.getElementById("pricereq").style.visibility = "visible";
			return false;

		}

		else if (isNaN(n))

		{
			document.getElementById("pricereq").innerHTML = "Alphabatic character not allowed";

			document.getElementById("nopricereq").style.visibility = "visible";
			return false;

		}

		else {

			document.getElementById("pricereq").style.visibility = "hidden";
			return true;

		}
	}

	function formvalid() {

		var nameresult = namevalid();
		var emailresult = pricevalid();

		if (nameresult == false || emailresult == false) {

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
	<br />
	<br />
	<br />
	<form:form method="post" action="insertitem.html"
		onsubmit="return formvalid()" commandName="Item">



		<table style="font-family: sans-serif; font-size: medium;"
			align="center" cellpadding="6" cellspacing="6">
			<tr>
				<td>Item Name</td>
				<td><input onblur="namevalid()" id="itemname" name="itemname"
					type="text" value="${item.itemname}" /> <samp
						style="color: #FF0000; visibility: hidden" id="namereq">Name
						Required*</samp></td>
			</tr>
			<tr>
				<td>Item Price</td>
				<td><input onblur="pricevalid()" id="itemprice"
					name="itemprice" type="text" value="${item.itemprice}" /> <samp
						style="color: #FF0000; visibility: hidden" id="pricereq">Price
						can not be null*</samp></td>
			</tr>


			<tr>
				<td>&nbsp;</td>
				<td><input name="Submit" type="submit" value="Submit" /> <input
					name="reset" type="reset" value="reset" /></td>
			</tr>


		</table>
	</form:form>
</body>
</html>