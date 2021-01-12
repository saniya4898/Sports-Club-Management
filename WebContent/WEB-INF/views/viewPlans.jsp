<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="./base.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Plans dekho
	<table border="1" cellpadding="10" cellspacing="5" class="table">
		<caption>
			<h2>Plan Details</h2>
		</caption>
		<tr>
			<th>ID</th>
			<th>Plan Name</th>
			<th>Plan Price</th>
			<th>No Of Days</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="plan" items="${plans}">
			<tr>
				<td><c:out value="${plan.planId}" /></td>
				<td><c:out value="${plan.planName}" /></td>
				<td><c:out value="${plan.planPrice}" /></td>
				<td><c:out value="${plan.noOfDays}" /></td>
				<td><a href="/Sports_Club_Management/admin/editPlanForm?planId=${plan.planId}"><i class="fa fa-pencil" style="font-size:30px;color:green"></i></a></td>
				<td><a href="/Sports_Club_Management/admin/deletePlan?planId=${plan.planId}"><i class="fa fa-trash-o" style="font-size:30px;color:red"></i></a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>