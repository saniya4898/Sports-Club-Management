<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="./adminNavbar.jsp"></jsp:include>
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

<jsp:include page="./footer.jsp"></jsp:include>