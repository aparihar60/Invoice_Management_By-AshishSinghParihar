<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/dialogbox.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script type="text/javascript">
	$(function() {
		$("#dialog").dialog({
			autoOpen : false,
			draggable : false,
			position : [ 10, 159 ],
			width : 688,
			height : 270,
			show : {

				duration : 1000
			},
			hide : {
				effect : "explode",
				duration : 500
			}
		});

		$("#dialog1").dialog({
			autoOpen : false,
			draggable : false,
			position : [ 800, 159 ],
			width : 688,
			height : 270,
			show : {

				duration : 1000
			},
			hide : {
				effect : "explode",
				duration : 500
			}
		});

		$("#dialog2").dialog({

			autoOpen : false,
			draggable : false,
			position : [ 6, 430 ],
			width : 500,
			height : 430,
			show : {

				duration : 1000
			},
			hide : {
				effect : "none",
				duration : 500
			}
		});

		$("#dialog3").dialog({

			autoOpen : false,
			draggable : false,
			position : [ 6, 430 ],
			width : 500,
			height : 430,
			show : {

				duration : 1000
			},
			hide : {
				effect : "none",
				duration : 500
			}
		});

		$("#dialog4").dialog({

			autoOpen : false,
			draggable : false,
			position : [ 6, 430 ],
			width : 500,
			height : 430,
			show : {

				duration : 1000
			},
			hide : {
				effect : "none",
				duration : 500
			}
		});

	});

	$(window)
			.load(
					function() {
						$
								.ajax({
									type : "GET",
									datatype : "application/json",
									url : "dashDueInv.html",
									data : {},

									success : function(response) {

										var table = '<table align="left" width="95%">'
												+ '<thead>'
												+ '<tr height="24">'
												+ '<th>Invoice Id</th>'
												+ '<th>Issue Date</th>'
												+ '<th>Due Date</th>'
												+ '<th>Client</th>'
												+ '<th>Amount</th>'
												+ '<th>Status</th>' +

												'</tr>' + '</thead><tbody>';

										$
												.each(
														response,
														function(i, item) {

															table += "<br/><tr align = center  style=height:30px>"
																	+ "<td>"
																	+ item.invoiceid
																	+ " </td>"
																	+ "<td>"
																	+ item.invoiceissuedate
																	+ "</td>"
																	+ "<td>"
																	+ item.invoiceduedate
																	+ "</td>"
																	+ "<td>"
																	+ item.client.clientfname
																	+ "</td>"
																	+ "<td>"
																	+ item.invoiceprice
																	+ "</td>"
																	+ "<td>"
																	+ item.invoicestatus
																	+ "</td>"

																	+ "</tr>";
														});
										table += "</tbody></table>";
										$("#dialog").html(table);

										$("#dialog").dialog("open");

									},

								});

						$
								.ajax({
									type : "GET",
									datatype : "application/json",
									url : "dashDueInv1.html",
									data : {},

									success : function(response) {

										var table = '<table align="left" width="95%">'
												+ '<thead>'
												+ '<tr height="24">'
												+ '<th>Invoice Id</th>'
												+ '<th>Issue Date</th>'
												+ '<th>Due Date</th>'
												+ '<th>Client</th>'
												+ '<th>Amount</th>'
												+ '<th>Status</th>' +

												'</tr>' + '</thead><tbody>';

										$
												.each(
														response,
														function(i, item) {

															table += "<br/><tr align = center  style=height:30px>"
																	+ "<td>"
																	+ item.invoiceid
																	+ " </td>"
																	+ "<td>"
																	+ item.invoiceissuedate
																	+ "</td>"
																	+ "<td>"
																	+ item.invoiceduedate
																	+ "</td>"
																	+ "<td>"
																	+ item.client.clientfname
																	+ "</td>"
																	+ "<td>"
																	+ item.invoiceprice
																	+ "</td>"
																	+ "<td>"
																	+ item.invoicestatus
																	+ "</td>"

																	+ "</tr>";
														});
										table += "</tbody></table>";
										$("#dialog1").html(table);

										$("#dialog1").dialog("open");

									},

								});

						// open dialog

						$("#dialog2")
								.html(
										"<img width='430px' height='370px' src='dashDueInv2.html'/>");
						$("#dialog2").dialog("open");

					});
</script>

<script type="text/javascript">
	function doAjaxPostDaily() {

		// open dialog
		$("#dialog3").dialog("close");
		$("#dialog4").dialog("close");

		$("#dialog2").html(
				"<img width='430px' height='370px' src='dashDueInv2.html'/>");
		$("#dialog2").dialog("open");

	}
</script>



<script type="text/javascript">
	function doAjaxPostweekly() {

		// open dialog
		$("#dialog2").dialog("close");
		$("#dialog4").dialog("close");

		$("#dialog3")
				.html(
						"<img width='430px' height='370px' src='dashDueInv2weekly.html'/>");
		$("#dialog3").dialog("open");

	}
</script>


<script type="text/javascript">
	function doAjaxPostmonthly() {

		// open dialog
		$("#dialog2").dialog("close");
		$("#dialog3").dialog("close");

		$("#dialog4")
				.html(
						"<img width='430px' height='370px' src='dashDueInv2monthly.html'/>");
		$("#dialog4").dialog("open");

	}
</script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div id="dialog" title="Invoices To be Due"></div>




	<div id="dialog1" title="Latest Invoices"></div>



	<div id="dialog2" title="Daily Bar Graph(Invoices)"></div>




	<div id="dialog3" title="Weekly Bar Graph(Invoices)"></div>



	<div id="dialog4" title="Monthly Bar Graph(Invoices)"></div>


	<div>
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br /> <br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br /> <br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br /> <br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br /> <br />
		<br />
		<br /> <br />
		<br />
		<br />
		<br />
		<br />

		<table align="left">
			<tr>
				<td><input type="button" value="Daily "
					onclick="doAjaxPostDaily()" /></td>

				<td><input type="button" value="Weekly"
					onclick="doAjaxPostweekly()" /></td>
				<td><input type="button" value="Monthly "
					onclick="doAjaxPostmonthly()" /></td>
			</tr>


		</table>


	</div>






</body>
</html>