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
	Games dekho
	<table border="1" cellpadding="10" cellspacing="5" class="table">
		<caption>
			<h2>Games Details</h2>
		</caption>
		<tr>
			<th>ID</th>
			<th>Game Name</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="game" items="${games}">
			<tr>
				<td><c:out value="${game.gameId}" /></td>
				<td><c:out value="${game.gameName}" /></td>
				<td><a href="/Sports_Club_Management/admin/deleteGame?gameId=${game.gameId}"><i class="fa fa-trash-o" style="font-size:30px;color:red"></i></a></td>

			</tr>
		</c:forEach>
	</table>

</body>
</html>