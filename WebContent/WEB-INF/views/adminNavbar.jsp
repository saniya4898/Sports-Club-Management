
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="./base.jsp"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
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


	<nav class="navbar navbar-inverse ">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"><i class="fa fa-heartbeat" ></i> Sports Club Management</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="nav-item"><a
				href="/Sports_Club_Management/admin/createClerkForm" id="createClerks">Create Clerk</a></li>
			<li class="nav-item"><a
				href="/Sports_Club_Management/admin/viewClerks" id="viewClerks">View Clerks</a></li>
			<li class="nav-item"><a
				href="/Sports_Club_Management/admin/createGameForm" id="addGame">Add Game</a></li>
			<li class="nav-item"><a
				href="/Sports_Club_Management/admin/viewGames" id="viewGames">View Games</a></li>
			<li class="nav-item"><a
				href="/Sports_Club_Management/admin/createPlanForm" id="addMembers">Add	Membership Plan</a></li>
			<li class="nav-item"><a
				href="/Sports_Club_Management/admin/viewPlans" id="viewMembers">View Membership Plans</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">

			<li><a href="/Sports_Club_Management/admin/logoutAdmin"><span
					class="glyphicon glyphicon-log-out"></span> Logout</a></li>
		</ul>
	</div>
	</nav>
