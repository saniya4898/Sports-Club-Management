<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="./clerkNavbar.jsp"></jsp:include>
<script>
	function onPlanChange() {
		var plan = document.getElementById("plans");
		var planValue = plan.value;
		var dateOfMembership = document.getElementById("dateOfMembership");
		console.log(dateOfMembership.value);
		var noOfDays = parseInt(planValue.split("-")[1]);
		document.getElementById("planPrice").value = parseInt(planValue
				.split("-")[2]);
		;
		var endOfMembership = document.getElementById("endOfMembership");
		console.log(endOfMembership.value);
		var date1 = new Date(dateOfMembership.value);
		date1.setDate(date1.getDate() + noOfDays);
		console.log(formatDate(date1));
		endOfMembership.value = formatDate(date1);

	}
	function formatDate(date) {
		var d = new Date(date), month = '' + (d.getMonth() + 1), day = ''
				+ d.getDate(), year = d.getFullYear();

		if (month.length < 2)
			month = '0' + month;
		if (day.length < 2)
			day = '0' + day;

		return [ year, month, day ].join('-');
	}
	function validateForm() {
		/*console.log("working");
		var error=false;
		var memberName=document.getElementById("memberName");
		var memberError="";
		if(memberName.value.length==0){
			memberError="Member name is required";
			error=true;
		}
		var dateOfMembership=document.getElementById("dateOfMembership");
		var dateOfMembershipError="";
		if(dateOfMembership.value.length==0){
			error=true;
			dateOfMembershipError="Date of membership is required";
		}
		 var plan=document.getElementById("plans");
		 var planValue=plan.value;
		 var planError="";
		 if(plan.value.length==0){
			 error=true;
			 planError="Plan is not selected";
			 return false;
		 }
		 var noOfDays=Integer.parseInt(planValue.split("-")[1]);
		 if(dateOfMembershipError==""){
			 var endOfMembership=document.getElementById("endOfMembership");
			 var date1=new date(dateOfMemebership.value);
			 date1.setDate(date1.getDate()+noOfDays);
			 var newDate=date1.getYear()+"-"+date1.getMonth()+"-"+date1.getDay();
			 console.log(newDate);
			 endOfMemebership.value=newDate;
		 }
		 
		return !error;*/
		return true;
	}
</script>

<style>
.h1 {
	margin-top: 30px;
	text-align: center;
}

.gameLabel {
	font-weight: normal !important;
}

.container {
	background-color: rgb(243, 250, 240);
	border-radius: 1rem;
	padding: 20px;
	width: 900px;
	font-size: 16px;
	margin-top: 30px;
	text-align: left; ! important;
	border-color: rgba(82, 168, 236, 0.8);
	box-shadow: 0px 15px 20px rgba(82, 168, 236, 0.6);
}

form {
	padding: 20px;
}

.col {
	width: 150px;
}

#userCategory {
	width: 190px
}

#buttonContainer {
	text-align: center;
}

input[type=text]:hover, input[type=password]:hover, input[type=number]:hover,
	select:hover {
	border-color: rgba(82, 168, 236, 0.8);
	box-shadow: 0px 0px 8px rgba(82, 168, 236, 0.6);
}

.msg {
	text-align: center;
	font-weight: bold;
}
</style>
<div class="h1">Add Member</div>
<div class="container">
	<form action="/Sports_Club_Management/clerk/createMember" method="post"
		onsubmit="return validateForm()">
		<div class="form-group">
			<label for="memberName">Member Name</label> <input type="text"
				class="form-control" id="memberName" name="memberName"
				placeholder="Enter Member Name">
		</div>
		<div class="row">
			<div class="form-group col-xs-12 col-sm-6 col-md-6 col-lg-6">
				<label for="dateOfMembership">Date Of Membership</label> <input
					type="date" class="form-control" id="dateOfMembership"
					name="dateOfMembership">
			</div>
			<div class="form-group col-xs-12 col-sm-6 col-md-6 col-lg-6">
				<label for="expiryOfMembership">Expiry Of Membership</label> <input
					type="date" class="form-control" id="endOfMembership"
					name="endOfMembership" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="games">Games</label><br />
			<c:forEach var="game" items="${games}">
				<input type="checkbox" id="${game.gameId }" name="games"
					value="${game.gameId }">
				<label for="${game.gameName }" class="gameLabel">${game.gameName }</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</c:forEach>
		</div>
		<div class="form-group">
			<label for="plans">Membership Plans</label> <select
				class="form-group form-control" onchange="onPlanChange()" id="plans"
				name="plans">
				<option value="-1" selected>Select Plan</option>
				<c:forEach var="plan" items="${plans}">
					<option value="${plan.planId }-${plan.noOfDays }-${plan.planPrice}">${plan.planName }</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="planPrice">Plan Price</label> <input type="number"
				class="form-control" id="planPrice" name="planPrice" readonly>
		</div>

		<div id="buttonContainer">
			<button type="submit" class="btn btn-primary">ADD</button>
		</div>
	</form>
	<div class="msg">
		<h4>${msg }</h4>
	</div>
</div>

<jsp:include page="./footer.jsp"></jsp:include>