<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Massage</title>
</head>
<body style="background-color: wheat">



	<table align="center">

		<tr>

			<td>Welcome:</td>

			<td><core:out value="${user.userfname}" /></td>
			<td>YOU ARE SUCCESSFULLY REGISTERED AS A SUPER ADMIN</td>


		</tr>
		<tr>

			<td><a href="index.html">Goto LOGIN page</a></td>
		</tr>

	</table>

</body>
</html>