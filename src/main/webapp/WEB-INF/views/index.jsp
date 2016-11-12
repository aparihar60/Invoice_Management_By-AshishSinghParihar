<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="images/impetus.jpg" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome in Invc_Mgmt</title>
<script type="text/javascript">
	function valid() {
		var a = document.getElementById("userloginid").value;
		//alert(a);
		if (a == null || a == "") {
			document.getElementById("userdisplay").style.visibility = "visible";
			document.getElementById("userloginid").focus();
			return false;
		}

		else {

			document.getElementById("userdisplay").style.visibility = "hidden";
			return true;

		}

	}

	function passvalid() {
		var b = document.getElementById("userpassword").value;
		if (b == null || b == "") {

			document.getElementById("passdisplay").style.visibility = "visible";
			document.getElementById("userpassword").focus();
			return false;
		} else {
			document.getElementById("passdisplay").style.visibility = "hidden";
			return true;
		}

	}

	function formvalid() {
		var aa = valid();
		var bb = passvalid();
		if (aa == false || bb == false) {
			return false;
		} else {
			return true;

		}

	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login Modal Dialog Window with CSS and jQuery</title>
<style type="text/css">
body {
	background: #202020;
	font: bold 12px Arial, Helvetica, sans-serif;
	margin: 0;
	padding: 0;
	min-width: 960px;
	color: #bbbbbb;
}

a {
	text-decoration: none;
	color: #00c6ff;
}

h1 {
	font: 4em normal Arial, Helvetica, sans-serif;
	padding: 20px;
	margin: 0;
	text-align: center;
}

h1 small {
	font: 0.2em normal Arial, Helvetica, sans-serif;
	text-transform: uppercase;
	letter-spacing: 0.2em;
	line-height: 5em;
	display: block;
}

h2 {
	color: #bbb;
	font-size: 3em;
	text-align: center;
	text-shadow: 0 1px 3px #161616;
}

.container {
	width: 960px;
	margin: 0 auto;
	overflow: hidden;
}

#content {
	float: left;
	width: 100%;
}

.post {
	margin: 0 auto;
	padding-bottom: 50px;
	float: left;
	width: 960px;
}

.btn-sign {
	width: 460px;
	margin-bottom: 20px;
	margin: 0 auto;
	padding: 20px;
	border-radius: 5px;
	background: -moz-linear-gradient(center top, #00c6ff, #018eb6);
	background: -webkit-gradient(linear, left top, left bottom, from(#00c6ff),
		to(#018eb6));
	background: -o-linear-gradient(top, #00c6ff, #018eb6);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorStr='#00c6ff',
		EndColorStr='#018eb6');
	text-align: center;
	font-size: 36px;
	color: #fff;
	text-transform: uppercase;
}

.btn-sign a {
	color: #fff;
	text-shadow: 0 1px 2px #161616;
}

#mask {
	display: none;
	background: #000;
	position: fixed;
	left: 0;
	top: 0;
	z-index: 10;
	width: 100%;
	height: 100%;
	opacity: 0.8;
	z-index: 999;
}

.login-popup {
	display: none;
	background: #333;
	padding: 10px;
	border: 2px solid #ddd;
	float: left;
	font-size: 1.2em;
	position: fixed;
	top: 50%;
	left: 50%;
	z-index: 99999;
	box-shadow: 0px 0px 20px #999;
	-moz-box-shadow: 0px 0px 20px #999; /* Firefox */
	-webkit-box-shadow: 0px 0px 20px #999; /* Safari, Chrome */
	border-radius: 3px 3px 3px 3px;
	-moz-border-radius: 3px; /* Firefox */
	-webkit-border-radius: 3px; /* Safari, Chrome */
}

img.btn_close {
	float: right;
	margin: -28px -28px 0 0;
}

fieldset {
	border: none;
}

form.signin .textbox label {
	display: block;
	padding-bottom: 7px;
}

form.signin .textbox span {
	display: block;
}

form.signin p,form.signin span {
	color: #999;
	font-size: 11px;
	line-height: 18px;
}

form.signin .textbox input {
	background: #666666;
	border-bottom: 1px solid #333;
	border-left: 1px solid #000;
	border-right: 1px solid #333;
	border-top: 1px solid #000;
	color: #fff;
	border-radius: 3px 3px 3px 3px;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	font: 13px Arial, Helvetica, sans-serif;
	padding: 6px 6px 4px;
	width: 200px;
}

form.signin input:-moz-placeholder {
	color: #bbb;
	text-shadow: 0 0 2px #000;
}

form.signin input::-webkit-input-placeholder {
	color: #bbb;
	text-shadow: 0 0 2px #000;
}

.button {
	background: -moz-linear-gradient(center top, #f3f3f3, #dddddd);
	background: -webkit-gradient(linear, left top, left bottom, from(#f3f3f3),
		to(#dddddd));
	background: -o-linear-gradient(top, #f3f3f3, #dddddd);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorStr='#f3f3f3',
		EndColorStr='#dddddd');
	border-color: #000;
	border-width: 1px;
	border-radius: 4px 4px 4px 4px;
	-moz-border-radius: 4px;
	-webkit-border-radius: 4px;
	color: #333;
	cursor: pointer;
	display: inline-block;
	padding: 6px 6px 4px;
	margin-top: 10px;
	font: 12px;
	width: 214px;
}

.button:hover {
	background: #ddd;
}
</style>
<script type="text/javascript" src="js/jquery-1.10.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('a.login-window').click(function() {

			// Getting the variable's value from a link 
			var loginBox = $(this).attr('href');

			//Fade in the Popup and add close button
			$(loginBox).fadeIn(300);

			//Set the center alignment padding + border
			var popMargTop = ($(loginBox).height() + 24) / 2;
			var popMargLeft = ($(loginBox).width() + 24) / 2;

			$(loginBox).css({
				'margin-top' : -popMargTop,
				'margin-left' : -popMargLeft
			});

			// Add the mask to body
			$('body').append('<div id="mask"></div>');
			$('#mask').fadeIn(300);

			return false;
		});

		// When clicking on the button close or the mask layer the popup closed
		$('a.close, #mask').live('click', function() {
			$('#mask , .login-popup').fadeOut(300, function() {
				$('#mask').remove();
			});
			return false;
		});
	});
</script>
<!-- <link rel="canonical" href="views/index.jsp" /> -->
</head>
<body>
	<h1 align="center">Invoice Management System</h1>
	<div class="container">
		<div id="content">
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
			<br />
			<br />
			<br />
			<br />
			<br />
			<div class="post">

				<div class="btn-sign">
					<a href="#login-box" class="login-window">Sign In / REGISTER</a>
				</div>
			</div>

			<div id="login-box" class="login-popup">
				<a href="close.html" class="close"><img
					src="images/close_pop.png" class="btn_close" title="Close Window"
					alt="Close" /></a>
				<form:form method="post" class="signin" action="userlogin.html"
					commandname="User" onsubmit="return formvalid()">
					<fieldset class="textbox">
						<label class="userloginid"> <span>Login Id</span> <input
							name="userloginid" id="userloginid" value="" type="text"
							autocomplete="on" placeholder="Username" size="30"
							onblur="valid()"> <samp
								style="color: #FF0000; visibility: hidden; font-family: sans-serif;"
								id="userdisplay"> Login Id can not be empty*</samp>
						</label> <label class="password"> <span>Password</span> <input
							id="password" type="password" name="userpassword" value=""
							type="password" placeholder="Password">
						</label>

						<button class="submit button" type="submit">Sign in</button>

						<p>
							<a href="Tenant.html"
								style="color: highlighttext; font-family: sans-serif;">New
								Tenant Register Here</a>
						</p>

					</fieldset>
				</form:form>
			</div>

		</div>
	</div>

</body>
</html>