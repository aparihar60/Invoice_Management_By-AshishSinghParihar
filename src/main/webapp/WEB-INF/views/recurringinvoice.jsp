                                                                     
                                                                     
                                                                     
                                             
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>



<script>
	$(function() {
		$("#invoiceissuedate").datepicker();

		loadItemList();
		loadClientList();
		

	});

	function onButtonClick(btnName) {
		//var divCreateInv = document.getElementById("divCreateInv");

		//if (btnName == 'createInv') {

		//divCreateInv.style.visibility = 'visible';
		document.getElementById('divCreateInv').style.display = 'block'; // To show
		document.getElementById('divviewInvoice').style.display = 'none'; // To hide

		//}

	}

	function onButtonClick1(btnName) {
		//var divviewInvoice = document.getElementById("divviewInvoice");

		//if (btnName == 'viewInvoice') {

		document.getElementById('divCreateInv').style.display = 'none'; // To hide
		document.getElementById('divviewInvoice').style.display = 'block'; // To show
		//divviewInvoice.style.visibility = 'visible';

		//location.href='view.htm';

		//}

	}

	function addRowInvoice(tableID) {

		var table = document.getElementById(tableID);

		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);


	var newrowid=document.getElementById("nrowid").value;
    var nextrowid=parseInt(newrowid)+parseInt("1");
	      document.getElementById("nrowid").value=nextrowid;
			//var colCount = table.rows[0].cells.length;

			row.setAttribute('id',newrowid);



		

		//var colCount = table.rows[0].cells.length;

		for ( var i = 0; i < 10; i++) {

			var newcell = row.insertCell(i);

			newcell.innerHTML = table.rows[0].cells[i].innerHTML;
			//alert(newcell.childNodes);
			switch (newcell.childNodes[0].type) {
			case "text":
				newcell.childNodes[0].value = "";
				break;
			case "checkbox":
				newcell.childNodes[0].checked = false;
				break;
			case "select-one":
				newcell.childNodes[0].selectedIndex = 0;
				break;
			}
		}
	}

	function deleteRowInvoice(tableID) {
		try {
			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;

			for ( var i = 0; i < rowCount; i++) {
				var row = table.rows[i];
				var chkbox = row.cells[0].childNodes[0];
				if (null != chkbox && true == chkbox.checked) {
					if (rowCount <= 1) {
						alert("Cannot delete all the rows.");
						break;
					}
					table.deleteRow(i);
					rowCount--;
					i--;
				}
              
			}

			alltotal();
		} 

		catch (e) {
			alert(e);
		}
	}



	function doAjaxPost1() {

		var formData = $("#frmInvoice").serialize();
		alert(formData);

		$.ajax({
			url : "insertrecurringinvoice.html",
			type : "post",
			dataType : 'json',
			data : formData,

			success : function(data) {

				$('#recurringinvoicenote').val('');
				$('#recurringinvoicedetailamount').val('');
				$('#recurringinvoicetax').val('');
				$('#recurringinvoicedetailquantity').val('');
				$('#recurringinvoicedetailprice').val('');
				$('#clientList').val('');
				$('#itemList').val('');
				$("#recurringinvoiceprice").val('');
				$("#recurringinvoicefrequency").val('');
				$("#recurringinvoiceoccurence").val('');
				
			}

		});

	}
</script>




<script type="text/javascript">


	 var xmlhttp;

	 function GetXmlHttpObject()
	 {
	     if (window.XMLHttpRequest)
	     {
	        return new XMLHttpRequest();
	     }
	     if (window.ActiveXObject)
	     {
	       return new ActiveXObject("Microsoft.XMLHTTP");
	     }
	  return null;
	 }



	
	function itemamount(itemid,sender)
	 {
	//alert(itemid);
	//alert(sender);
	 var tr = sender.parentNode.parentNode;
	 var trid= tr.getAttribute('id');
	 //var a=document.getElementById(trid);
	 //var b=a.cells[3].childNodes[1].value;
     //alert(b);
		
	   xmlhttp=GetXmlHttpObject();

	   if (xmlhttp==null)
	   {
	    alert ("Your browser does not support Ajax HTTP");
	    return;
	   }

	     var url="itemamount.html?itemId="+itemid;
	    // url=url+"?q="+str;

	     xmlhttp.onreadystatechange=function()
	     {

	    	   if (xmlhttp.readyState==4)
	    	   {
	    	  zz=xmlhttp.responseText;

	    	  document.getElementById(trid).cells[3].childNodes[1].value=zz;
	    	  document.getElementById(trid).cells[2].childNodes[1].value=0;
	    	  document.getElementById(trid).cells[4].childNodes[1].value=0; 
	    	  alltotal();
//	    	  alert(zz);

	         
	      	   }
	    		     
		     
		 };
	     xmlhttp.open("GET",url,true);
	     xmlhttp.send();
	 };



  function  gettotalamount(qtyvalue,sender)
  {
  
	  var tr = sender.parentNode.parentNode;
      var trid= tr.getAttribute('id');
//      alert(trid);
     var price=document.getElementById(trid).cells[3].childNodes[1].value;

     
     var totamount=parseInt(qtyvalue)*parseInt(price);

     
     document.getElementById(trid).cells[4].childNodes[1].value=totamount;
     
		 
         alltotal();

  }


function alltotal() 
{
	var table = document.getElementById("dataTable");

	var rowCount = table.rows.length;

	var gtotal=0;
	
    for(i=0;i<rowCount;i++)
        {

     var tot=table.rows[i].cells[4].childNodes[1].value;

       gtotal=gtotal+parseInt(tot);
       
        }
    	document.getElementById("totalamount").value=gtotal;

    	taxamount();
}


function taxamount()
{

	var tax=document.getElementById("recurringinvoicetax").value;
	var totalamount=document.getElementById("totalamount").value;

	 var taxamount=(parseInt(totalamount)*parseInt(tax))/100;

	 var fullamount=parseInt(totalamount)+parseFloat(taxamount);
	 
	  document.getElementById("recurringalltax").value=taxamount;	 

	 document.getElementById("recurringinvoiceprice").value=fullamount;
	 
	
}
	
	</script>





</head>





<body>

<input type="hidden" value="3" id="nrowid">
<div><%@ include file="header.jsp" %></div>


<br/>


	<%-- <fieldset>
		<legend>Invoice Actions</legend>
		<table>
			<tr>
				<td><input type="button" value="Create Invoice"
					onclick="onButtonClick('createInv')" /></td>

				<td><input type="submit" value="View List of Invoices"
					onclick="onButtonClick1('viewInvoice')"  onclick="JavaScript:window.location='view.htm'
						/></td>
			</tr>

		</table>
	</fieldset> --%>
	<form:form id="frmInvoice" action="insertrecurringinvoice.html" method="post">
		<div id="divCreateInv">
			<!-- style="vertical-align: top; visibility: hidden;">
 -->

			<fieldset>
				<legend style="font-family: sans-serif;font-size: x-large;">Create Invoice</legend>
				<table>
					<tr>
						<td>Fill the Given Data:</td> <br/>
					
						<!-- <td><a style="font-style: italic; color: blue; font-size: large;"  href="invoicelist.html">View List Of Invoices</a></td>
					</tr>
					<tr align="right">
						<td><a
							style="font-style: italic; color: blue; font-size: large;"
							href="searchinvoice.html">Search Invoices</a></td>

					</tr>
 -->
				</table>
				<table align="center">
					<!-- <tr align="left">
						<td width="150">Invoice Id</td>
						<td width="150"><label id="lblInvId" for="Invoice ID">
						</label></td>
					</tr> -->
					<tr align="left">
						<td width="150">Client To Be Billed</td>
						<td width="150" valign="top"><select name="clientList"
							id="clientList">
								<option>Select Client</option>
								<c:forEach items="${clientList}" var="client">
									<option value="${client.clientid}">${client.clientfname}</option>
								</c:forEach>

						</select>
					</tr>
					<tr align="left">
						<td width="150">Date:</td>
						<td><input type="text" id="invoiceissuedate" name="invoiceissuedate" /></td>
					</tr>
					<tr align="left">
						<td width="150">frequency:</td>

						<td><select name="recurringinvoicefrequency"
							id="recurringinvoicefrequency">
								<option value="weekly">Weekly</option>
								<option value="monthly">Monthly</option>
								<option value="yearly">yearly</option>

						</select></td>
					</tr>
					<tr align="left">
						<td width="150">Occurence</td>

						<td><input type="text" id="recurringinvoiceoccurence" name="recurringinvoiceoccurence" /></td>
					</tr>
				</table>

			</fieldset>

			<fieldset>
				<legend>Item List</legend>
				<div>
					<table>
						<tr>
							<td><INPUT type="button" value="Add Item"
								onclick="addRowInvoice('dataTable')" /></td>
							<td><INPUT type="button" value="Delete Item"
								onclick="deleteRowInvoice('dataTable')" /></td>
						</tr>


					</table>
				</div>
				<div>
					<TABLE id="1" border="0">
						<tr>
						<td width="30%">Choose</td>
							<td width="20%" align="left">Items</td>

							<td width="22%">Qty</td>
							<td width="20%">Price</td>
							<td width="20%">Amount</td>
						</tr>
					</TABLE>
					<TABLE id="dataTable" border="0">
						<TR id="tr-1">
						
						
						
							<TD width="20%"><INPUT type="checkbox" name="chk" /></TD>



							<td width="150" valign="top">
							<select name="itemList"
								id="itemList" onchange="itemamount(this.value,this)">
									
									<option value="">Select Item</option>
									<c:forEach items="${itemList}" var="item">
										<option value="${item.itemid}">${item.itemname}</option>
									</c:forEach>
							</select>
							
							<TD width="20%">
							
							<INPUT type="text" name="recurringinvoicedetailquantity" autocomplete="off"   onkeyup="gettotalamount(this.value,this)"
								id="recurringinvoicedetailquantity" />
								
								</TD>
							
							
							<TD width="20%">
							<INPUT style="background: gray;" type="text" value="0" readonly="readonly" name="recurringinvoicedetailprice" id="recurringinvoicedetailprice" /></TD>
							
							
							<TD width="20%">
							
							<INPUT style="background: gray;" type="text" readonly="readonly" name="recurringinvoicedetailamount" value="0"	id="recurringinvoicedetailamount" />
							
							</TD>



						</TR>
					</table>
							<table width="62%" border="0">
				
				<tr>
				<td width="80%" align="right"></td>
				<td width="20%"></td>
				<td align="right">
				<input style="background: gray;" type="hidden" id="totalamount" readonly="readonly" value="0">
				 </td>
				</tr>
				</table>
		

					<table style="margin-left: 520px;">
						<tr>
							<td align="right" colspan="3">Tax(10%)</td>
							<td>
							<input type="hidden" name="recurringinvoicetax" id="recurringinvoicetax" value="10" readonly="readonly">
							<input style="background: gray;" type="text" name="recurringalltax" id="recurringalltax" value="" readonly="readonly">
							
							</td>
						</tr>
						<tr>
							<td align="right" colspan="3">Total Amount</td>
							<td><input style="background: gray;" type="text" readonly="readonly" name="recurringinvoiceprice" id="recurringinvoiceprice"></td>
						</tr>

					</table>
				
				</div>
				
			</fieldset>
			<fieldset>

				<table>
					<tr>

						<td>Notes:<textarea rows="2" cols="100" maxlength="500"
								id="recurringinvoicenote" name="recurringinvoicenote"></textarea></td>
					<tr>
						<td colspan="2"><div id="info"></div></td>
					</tr>

				</table>
			</fieldset>

			<table align="center">
				<tr>
					<td><input type="Reset" value="Cancel" /></td>
					<td><input type="submit" value="Save & Send"
						 /></td>
				</tr>
			</table>

		</div>


	</form:form>


</body>

</html>