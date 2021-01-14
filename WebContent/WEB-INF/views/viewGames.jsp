<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="./adminNavbar.jsp"></jsp:include>
<%@include file="./base.jsp"%>
<style>
caption {
	text-align: center;
}
</style>

<div class="container">
	<table class="table table-striped table-hover ">
		<caption>
			<h2>Games Details</h2>
		</caption>
		<thead>
		<tr>
			<th>ID</th>
			<th>Game Name</th>
			<th>Delete</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="game" items="${games}">
			<tr>
				<td><c:out value="${game.gameId}" /></td>
				<td><c:out value="${game.gameName}" /></td>
				<td><a
					href="/Sports_Club_Management/admin/deleteGame?gameId=${game.gameId}"><i
						class="fa fa-trash-o" style="font-size: 30px; color: red"></i></a></td>

			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
	<jsp:include page="./footer.jsp"></jsp:include>