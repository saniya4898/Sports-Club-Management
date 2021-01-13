<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="./adminNavbar.jsp"></jsp:include>
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

<jsp:include page="./footer.jsp"></jsp:include>