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
			<h2>Plan Details</h2>
		</caption>
		<thead>
			<tr>
				<th>ID</th>
				<th>Plan Name</th>
				<th>Plan Price</th>
				<th>No Of Days</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="plan" items="${plans}">
				<tr>
					<td><c:out value="${plan.planId}" /></td>
					<td><c:out value="${plan.planName}" /></td>
					<td><c:out value="${plan.planPrice}" /></td>
					<td><c:out value="${plan.noOfDays}" /></td>
					<td><a
						href="/Sports_Club_Management/admin/editPlanForm?planId=${plan.planId}"><i
							class="fa fa-pencil" style="font-size: 30px; color: green"></i></a></td>
					<td><a
						href="/Sports_Club_Management/admin/deletePlan?planId=${plan.planId}"><i
							class="fa fa-trash-o" style="font-size: 30px; color: red"></i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<jsp:include page="./footer.jsp"></jsp:include>