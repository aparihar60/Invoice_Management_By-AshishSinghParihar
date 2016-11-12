<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client Registration</title>
</head>
<body>

	<%@ include file="header.jsp"%>
	&nbsp;&nbsp;
	<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
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
	<table style="font-family: sans-serif; font-size: large; color: black"
		align="center">

		<tr>



			<td><core:out value="${client.clientfname}" /></td>
			<td>you are successfully registered</td>

		</tr>


	</table>

</body>
</html>