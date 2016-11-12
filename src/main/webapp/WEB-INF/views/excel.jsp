<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>



<script>
	$(function() {
		$("#fromdate").datepicker();
		$("#todate").datepicker();

	});
</script>


<title>Download Excel</title>


<script type="text/javascript">
	function namevalid() {
		var n = document.getElementById("fromdate").value;
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
		var n = document.getElementById("todate").value;
		if (n == "" || n == null) {
			document.getElementById("pricereq").style.visibility = "visible";
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

	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />

	<h2 align="center">Download Invoice List Between Two Dates</h2>
	<form:form onsubmit="return formvalid()" action="download.html"
		method="get">
		<table style="font-family: sans-serif; font-size: medium;"
			align="center" cellpadding="3" cellspacing="3">
			<tr align="left">
				<td width="150">From Date:</td>
				<td><input type="text" onblur="namevalid()" id="fromdate"
					name="fromdate" /> <samp
						style="color: #FF0000; visibility: hidden" id="namereq">Select
						a date*</samp></td>
			</tr>

			<tr align="left">
				<td width="150">To Date:</td>
				<td><input type="text" onblur="pricevalid()" id="todate"
					name="todate" /> <samp style="color: #FF0000; visibility: hidden"
						id="pricereq">Select a date*</samp></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input name="Submit" type="submit" value="Download" style="width: 130px;height: 30px" /></td>
			</tr>

		</table>
	</form:form>



	<!-- <h3 align="center">
		Invoices Excel Report</br> <a href="download.html" style="color: blue;">download
			here</a>
	</h3> -->
</body>
</html>