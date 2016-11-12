<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Normal User List</title>
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
	padding: 12px 20px 12px;
	text-align: center;
}

th {
	padding-top: 17px;
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
	function surdel(ii) {

		var res = confirm("Are You Sure you want to delete this user");
		if (res == true) {
			window.location.href = "deleteuser.html?userId=" + ii;
			return true;
		} else if (res == false) {
			return false;
		}
	}
</script>
<script type="text/javascript">
function Pager(tableName, itemsPerPage) {
    this.tableName = tableName;
    this.itemsPerPage = itemsPerPage;
    this.currentPage = 1;
    this.pages = 0;
    this.inited = false;
    
    this.showRecords = function(from, to) {        
        var rows = document.getElementById(tableName).rows;
        // i starts from 1 to skip table header row
        for (var i = 1; i < rows.length; i++) {
            if (i < from || i > to)  
                rows[i].style.display = 'none';
            else
                rows[i].style.display = '';
        }
    }
    
    this.showPage = function(pageNumber) {
    	if (! this.inited) {
    		alert("not inited");
    		return;
    	}

        var oldPageAnchor = document.getElementById('pg'+this.currentPage);
        oldPageAnchor.className = 'pg-normal';
        
        this.currentPage = pageNumber;
        var newPageAnchor = document.getElementById('pg'+this.currentPage);
        newPageAnchor.className = 'pg-selected';
        
        var from = (pageNumber - 1) * itemsPerPage + 1;
        var to = from + itemsPerPage - 1;
        this.showRecords(from, to);
    }   
    
    this.prev = function() {
        if (this.currentPage > 1)
            this.showPage(this.currentPage - 1);
    }
    
    this.next = function() {
        if (this.currentPage < this.pages) {
            this.showPage(this.currentPage + 1);
        }
    }                        
    
    this.init = function() {
        var rows = document.getElementById(tableName).rows;
        var records = (rows.length - 1); 
        this.pages = Math.ceil(records / itemsPerPage);
        this.inited = true;
    }

    this.showPageNav = function(pagerName, positionId) {
    	if (! this.inited) {
    		alert("not inited");
    		return;
    	}
    	var element = document.getElementById(positionId);
    	
    	var pagerHtml = '<span onclick="' + pagerName + '.prev();" class="pg-normal"> &#171 Prev </span> | ';
        for (var page = 1; page <= this.pages; page++) 
            pagerHtml += '<span id="pg' + page + '" class="pg-normal" onclick="' + pagerName + '.showPage(' + page + ');">' + page + '</span> | ';
        pagerHtml += '<span onclick="'+pagerName+'.next();" class="pg-normal"> Next &#187;</span>';            
        
        element.innerHTML = pagerHtml;
    }
}


</script>
</head>
<body>
	<div><%@ include file="header.jsp"%></div>



	<div>
		<h2 align="center">
			<a style="font-family: sans-serif; font-size: large; color: black"
				href="addnormaluser.html"><b><i>Add Normal User</i></b></a>
		</h2>
		> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

	</div>

	<h2 align="center">Normal User List</h2>
	<table id="results" align="center" cellpadding="2" cellspacing="1"
		border="1">
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>login id</th>
			<th>password</th>
			<th>Email</th>
			<th>Contact No</th>
			<th></th>
			<th></th>






		</tr>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${user.userid}</td>
				<td>${user.userfname}</td>
				<td>${user.userlname}</td>
				<td>${user.userloginid}</td>
				<td>${user.userpassword}</td>
				<td>${user.useremail}</td>
				<td>${user.usercontactno}</td>


				<td><a href="edituser.html?userId=${user.userid}">Edit</a></td>




				<td><a href="javascript:" onclick="surdel('${user.userid}')">Delete</a></td>




			</tr>
		</c:forEach>
	</table>
	<table id="results1" border="5" style="background-color: gray;"
		align="center" class="data">
		<tr>
			<td>
				<div id="pageNavPosition" style="cursor: pointer"></div>
			</td>
		</tr>
	</table>
	<script type="text/javascript">
			<!--
				var pager = new Pager('results',10);
				pager.init();
				pager.showPageNav('pager', 'pageNavPosition');
				pager.showPage(1);
			//-->
			</script>
	<br />

</body>
</html>