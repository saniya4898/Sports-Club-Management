<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="./adminNavbar.jsp"></jsp:include>
	Clerks dekho
	<table border="1" cellpadding="10" cellspacing="5" class="table">
		<caption>
			<h2>Clerks Details</h2>
		</caption>
		<tr>
			<th>ID</th>
			<th>Clerk Name</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="clerk" items="${clerks}">
			<tr>
				<td><c:out value="${clerk.clerkId}" /></td>
				<td><c:out value="${clerk.clerkName}" /></td>
				<td><a href="/Sports_Club_Management/admin/deleteClerk?clerkId=${clerk.clerkId}"><i class="fa fa-trash-o" style="font-size:30px;color:red"></i></a></td>

			</tr>
		</c:forEach>
	</table>

<jsp:include page="./footer.jsp"></jsp:include>