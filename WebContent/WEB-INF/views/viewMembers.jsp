
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="./clerkNavbar.jsp"></jsp:include>
<%@include file="./base.jsp"%>
<style>
caption {
	text-align: center;
}
.hide{
	display:none;
}
</style>

<script>
	function onCategoryChange(){
		var plans=document.getElementById("plansType");
		var games=document.getElementById("games");

		var category=document.getElementById("searchCategory");
		if(category.value=="membershipPlan"){
			plans.style.display="inline";
		}
		else if(category.value=="games"){
			plans.style.display="none";
			games.style.display="inline";
		}
		
	}

</script>

<div class="container">
	<div class="container searchBar">
		<div class="form-group form-inline">
			<select class="form-control" name="searchCategory"
				id="searchCategory"  onchange="onCategoryChange()">
				<option value="-1">Select Category</option>
				<option value="membershipPlan">Membership Plan</option>
				<option value="game">Game</option>
				<option value="expiryDateOfMembership">Expiry Date of Membership</option>
			</select> 
			
			<select style="display:none;" class="form-control" id="plansType" name="plansType">
				<option value="-1">Select Category</option>
				<c:forEach var="plan" items="${plans}">
					<option value="${plan.planId }">${plan.planName }</option>
				</c:forEach>
			</select> 
			
			<select class="form-control" id="gameType" name="gameType">
				<option value="-1">Select Category</option>
				<c:forEach var="game" items="${games}">
					<option value="${game.gameId }">${game.gameName }</option>
				</c:forEach>
				
			</select> <input type="date" class="form-control" id="expiryDate"
				name="expiryDate">
		</div>
	</div>
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