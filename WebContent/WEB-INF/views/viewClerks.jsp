<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="./base.jsp"%>
<jsp:include page="./adminNavbar.jsp"></jsp:include>
<style>
	caption {
	text-align: center;
}
</style>

<div class="container">
	<table class="table table-striped table-hover ">
		<caption>
			<h2>Clerks Details</h2>
		</caption>
		<thead class="thead-dark">

			<tr>
				<th>ID</th>
				<th>Clerk Name</th>
				<th>Delete</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="clerk" items="${clerks}">
				<tr>
					<td><c:out value="${clerk.clerkId}" /></td>
					<td><c:out value="${clerk.clerkName}" /></td>
					<td><a
						href="/Sports_Club_Management/admin/deleteClerk?clerkId=${clerk.clerkId}"><i
							class="fa fa-trash-o" style="font-size: 30px; color: red"></i></a></td>

				</tr>
			</c:forEach>
		</tbody>

	</table>
</div>


<jsp:include page="./footer.jsp"></jsp:include>