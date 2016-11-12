<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item Registered</title>
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
	<table align="center">

		<tr style="font-family: sans-serif; font-size: large; color: black">



			<td><core:out value="${item.itemname}" /></td>
			<td>is successsfully inserted in Items.</td>

		</tr>


	</table>

</body>
</html>