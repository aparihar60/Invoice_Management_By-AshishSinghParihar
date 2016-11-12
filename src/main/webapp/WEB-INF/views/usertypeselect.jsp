<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.impetus.invc_mgmt.model.User"%>

<%@ page language="java" import="java.sql.*"%>
<%
	User user = ((User) session.getAttribute("user"));
	String name = user.getUserfname();
%>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Type of User</title>
</head>
<body>
	<%@ include file="headersuperadmin.jsp"%>
	&nbsp;&nbsp;




	<br />
	<br />
	<br />
	<br />
	<br />

	<h2 align="center">
		<a style="font-family: sans-serif; font-size: large; color: black"
			href="adduser.html">Add Admin User</a>
	</h2>



</body>
</html>