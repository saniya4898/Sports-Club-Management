<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="./base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Admin home
<ul>
	<li><a href="/Sports_Club_Management/admin/createClerkForm">Create Clerk</a></li>
	<li><a href="/Sports_Club_Management/admin/viewClerks">View Clerks</a></li>
	<li><a href="/Sports_Club_Management/admin/createGameForm">Add Game</a></li>
	<li><a href="/Sports_Club_Management/admin/viewGames">View Games</a></li>
	<li><a href="/Sports_Club_Management/admin/createPlanForm">Add Membership Plan</a></li>
	<li><a href="/Sports_Club_Management/admin/viewPlans">View Membership Plans</a></li>
</ul>
</body>
</html>