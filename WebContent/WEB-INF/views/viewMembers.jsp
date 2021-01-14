
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="./clerkNavbar.jsp"></jsp:include>
<%@include file="./base.jsp"%>
<style>
caption {
	text-align: center;
}
</style>

<div class="container">
	<table class="table table-striped table-hover ">
		<caption>
			<h2>Members Details</h2>
		</caption>
		<thead>
			<tr>
				<th>ID</th>
				<th>Member Name</th>
				<th>Date of Membership</th>
				<th>Expiry Date of Membership</th>
				<th>Plan Selected</th>
				<th>Plan Price</th>
				<th>Games Selected</th>
				<th>Edit</th>
				<th>Delete</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="member" items="${members}">
				<tr>
					<td><c:out value="${member.memberId}" /></td>
					<td><c:out value="${member.memberName}" /></td>
					<td><fmt:formatDate value="${member.dateOfMembership}"
							pattern="dd-MM-YYYY" /></td>
					<td><fmt:formatDate value="${member.expiryOfMembership}"
							pattern="dd-MM-YYYY" /></td>
					<td><c:out value="${member.planSelected.planName}" /></td>
					<td><c:out value="${member.planSelected.planPrice}" /></td>
					<td><c:out value="${member.gamesToString()}" /></td>

					<td><a
						href="/Sports_Club_Management/clerk/editMemberForm?memberId=${member.memberId}"><i
							class="fa fa-pencil" style="font-size: 30px; color: green"></i></a></td>
					<td><a
						href="/Sports_Club_Management/clerk/deleteMember?memberId=${member.memberId}"><i
							class="fa fa-trash-o" style="font-size: 30px; color: red"></i></a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<jsp:include page="./footer.jsp"></jsp:include>