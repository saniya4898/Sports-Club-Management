
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="./base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clerk</title>
<style>
body{
	background-image: url("${pageContext.request.contextPath}/resources/images/bg5.jpg");
}
.navbar-brand{
	font-size: 22px
}
a
{
	font-size: 16px
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"><i class="fa fa-heartbeat" ></i> Sports Club Maintenance</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="/Sports_Club_Management/clerk/createMemberForm">Create
					Member</a></li>
			<li><a href="/Sports_Club_Management/clerk/viewMembers">View
					Members</a></li>
			
		</ul>
		<ul class="nav navbar-nav navbar-right">
			
			<li><a href="/Sports_Club_Management/clerk/logoutClerk"><span class="glyphicon glyphicon-log-out"></span>
					Logout</a></li>
		</ul>
	</div>
	</nav>