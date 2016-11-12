<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search invoices</title>
<script type="text/javascript" src="js/jquery-1.10.1.js"></script>



<script type="text/javascript">
	$(function() {
		/* For zebra striping */
		$("table tr:nth-child(odd)").addClass("odd-row");
		/* For cell text alignment */
		$("table td:first-child, table th:first-child").addClass("first");
		/* For removing the last border */
		$("table td:last-child, table th:last-child").addClass("last");
	});
</script>

<style type="text/css">
html,body,div,span,object,iframe,h1,h2,h3,h4,h5,h6,p,blockquote,pre,abbr,address,cite,code,del,dfn,em,img,ins,kbd,q,samp,small,strong,sub,sup,var,b,i,dl,dt,dd,ol,ul,li,fieldset,form,label,legend,table,caption,tbody,tfoot,thead,tr,th,td
	{
	margin: 0;
	padding: 0;
	border: 0;
	outline: 0;
	font-size: 100%;
	vertical-align: baseline;
	background: transparent;
}

/* body {
		margin:0;
		padding:0;
		font:12px/15px "Helvetica Neue",Arial, Helvetica, sans-serif;
		color: #555;
		background:#f5f5f5 url(bg.jpg);
	} */
#content {
	width: 65%;
	max-width: 690px;
	margin: 6% auto 0;
}

/*
	Pretty Table Styling
	CSS Tricks also has a nice writeup: http://css-tricks.com/feature-table-design/
	*/
table {
	overflow: hidden;
	border: 1px solid #d3d3d3;
	background: #fefefe;
	width: 70%;
	margin: 5% auto 0;
	-moz-border-radius: 5px; /* FF1+ */
	-webkit-border-radius: 5px; /* Saf3-4 */
	border-radius: 5px;
	-moz-box-shadow: 0 0 4px rgba(0, 0, 0, 0.2);
	-webkit-box-shadow: 0 0 4px rgba(0, 0, 0, 0.2);
}

th,td {
	padding: 18px 28px 18px;
	text-align: center;
}

th {
	padding-top: 22px;
	text-shadow: 1px 1px 1px #fff;
	background: #e8eaeb;
}

td {
	border-top: 1px solid #e0e0e0;
	border-right: 1px solid #e0e0e0;
}

tr.odd-row td {
	background: #f6f6f6;
}

td.first,th.first {
	text-align: left
}

td.last {
	border-right: none;
}

/*
	Background gradients are completely unnecessary but a neat effect.
	*/
td {
	background: -moz-linear-gradient(100% 25% 90deg, #fefefe, #f9f9f9);
	background: -webkit-gradient(linear, 0% 0%, 0% 25%, from(#f9f9f9),
		to(#fefefe));
}

tr.odd-row td {
	background: -moz-linear-gradient(100% 25% 90deg, #f6f6f6, #f1f1f1);
	background: -webkit-gradient(linear, 0% 0%, 0% 25%, from(#f1f1f1),
		to(#f6f6f6));
}

th {
	background: -moz-linear-gradient(100% 20% 90deg, #e8eaeb, #ededed);
	background: -webkit-gradient(linear, 0% 0%, 0% 20%, from(#ededed),
		to(#e8eaeb));
}

/*
	I know this is annoying, but we need additional styling so webkit will recognize rounded corners on background elements.
	Nice write up of this issue: http://www.onenaught.com/posts/266/css-inner-elements-breaking-border-radius
	
	And, since we've applied the background colors to td/th element because of IE, Gecko browsers also need it.
	*/
tr:first-child th.first {
	-moz-border-radius-topleft: 5px;
	-webkit-border-top-left-radius: 5px; /* Saf3-4 */
}

tr:first-child th.last {
	-moz-border-radius-topright: 5px;
	-webkit-border-top-right-radius: 5px; /* Saf3-4 */
}

tr:last-child td.first {
	-moz-border-radius-bottomleft: 5px;
	-webkit-border-bottom-left-radius: 5px; /* Saf3-4 */
}

tr:last-child td.last {
	-moz-border-radius-bottomright: 5px;
	-webkit-border-bottom-right-radius: 5px; /* Saf3-4 */
}
</style>
<script type="text/javascript">
	function tablehidden() {

		document.getElementById("tablehidden").style.visibility = "hidden";
		return true;

	}

	function namevalid() {
		var n = document.getElementById("param").value;
		if (n == "" || n == null)

		{

			document.getElementById("req").innerHTML = "Entry Required*";

			document.getElementById("req").style.visibility = "visible";
			return false;

		}

		else {

			document.getElementById("req").style.visibility = "hidden";
			return true;

		}
	}

	function validentry() {
		var n = document.getElementById("searchby").value;
		var n2 = document.getElementById("param").value;
		if (n == "invoice") {

			if (isNaN(n2)) {

				document.getElementById("req").innerHTML = "Characters are not allowed";
				document.getElementById("req").style.visibility = "visible";

				return false;

			}

		}

		else if (n2 == "" || n2 == null)

		{

			document.getElementById("req").innerHTML = "Entry Required*";

			document.getElementById("req").style.visibility = "visible";
			return false;

		}

		else {
			document.getElementById("req").style.visibility = "hidden";
			return true;

		}

	}

	function formvalid() {

		var nameresult = namevalid();
		var invoiceidresult = validentry();

		if (nameresult == false || invoiceidresult == false) {

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

	<%-- <div id="tablehidden">
<table id="results" align="center" cellpadding="2" cellspacing="1" border="1">
		<tr>
			
			
		



		</tr>
		<c:forEach items="${clientlist}" var="client">
			<tr>
				
				<td>${client.clientfname}</td>
		

			</tr>
		</c:forEach>
	</table>
	</div> --%>


	<form:form action="searchinvoice1.html" onsubmit="return formvalid()"
		commandName="Invoice">
		<table align="center">

			<tr>
				<td>Search By:</td>
				<td><select name="searchby" id="searchby">
						<option value="invoice">Invoice Id</option>

						<option value="client">Client Name</option>

				</select></td>




			</tr>


			<tr>
				<td>Type Here:</td>
				<td><input name="param" id="param" type="text" /></td>
				<td><samp style="color: #FF0000; visibility: hidden" id="req">Entry
						Required*</samp></td>
			</tr>

			<tr>
				<td>&nbsp;</td>
				<td><input name="Submit" type="submit" value="Submit" /></td>
			</tr>

		</table>
	</form:form>

	<table align="center" cellpadding="2" cellspacing="1" border="1">
		<tr>
			<th>Id</th>

			<th>Price</th>
			<th>Tax</th>
			<th>Issue Date</th>
			<th>Due Date</th>
			<th>Note</th>
			<th>Status</th>
			<th>Client Name</th>


		</tr>
		<c:forEach items="${invoicelist}" var="invoice">
			<tr>
				<td>${invoice.invoiceid}</td>
				<td>${invoice.invoiceprice}</td>
				<td>${invoice.invoicetax}</td>
				<td>${invoice.invoiceissuedate}</td>
				<td>${invoice.invoiceduedate}</td>
				<td>${invoice.invoicenote}</td>
				<td>${invoice.invoicestatus}</td>
				<td>${invoice.client.clientfname}</td>

			</tr>
		</c:forEach>
	</table>

</body>
</html>