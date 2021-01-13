<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="./clerkNavbar.jsp"></jsp:include>
<script>
	function onPlanChange(){
		 var plan=document.getElementById("plans");
		 var planValue=plan.value;
		 var dateOfMembership=document.getElementById("dateOfMembership");
		 console.log(dateOfMembership.value);
		 var noOfDays=parseInt(planValue.split("-")[1]);
		 document.getElementById("planPrice").value=parseInt(planValue.split("-")[2]);;
		 var endOfMembership=document.getElementById("endOfMembership");
		 console.log(endOfMembership.value);
		 var date1=new Date(dateOfMembership.value);
		 date1.setDate(date1.getDate()+noOfDays);
		 console.log(formatDate(date1));
		 endOfMembership.value=formatDate(date1);
		
	}
	function formatDate(date) {
	    var d = new Date(date),
	        month = '' + (d.getMonth() + 1),
	        day = '' + d.getDate(),
	        year = d.getFullYear();

	    if (month.length < 2) 
	        month = '0' + month;
	    if (day.length < 2) 
	        day = '0' + day;

	    return [year, month, day].join('-');
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

	Hello Member form
	<form action="/Sports_Club_Management/clerk/createMember" method="post"
		onsubmit="return validateForm()">
		<div class="form-group">
			<label for="memberName">Member Name</label> <input type="text"
				class="form-control" id="memberName" name="memberName"
				placeholder="Enter Member Name">
		</div>
		<div class="form-group">
			<label for="dateOfMembership">Date Of Membership</label> <input
				type="date" class="form-control" id="dateOfMembership"
				name="dateOfMembership">
		</div>
		<div class="form-group">
			<label for="expiryOfMembership">Date Of Membership</label> <input
				type="date" class="form-control" id="endOfMembership"
				name="endOfMembership" readonly>
		</div>
		<div class="form-group">
			<label for="games">Game</label>
			<c:forEach var="game" items="${games}">
				<input type="checkbox" id="${game.gameId }" name="games"
					value="${game.gameId }">
				<label for="${game.gameName }">${game.gameName }</label>
			</c:forEach>
		</div>
		<div class="form-group">
			<label for="plans">Membership Plans</label> <select
				class="form-group" onchange="onPlanChange()" id="plans" name="plans">
				<option value="-1" selected>Select Plan</option>
				<c:forEach var="plan" items="${plans}">
					<option value="${plan.planId }-${plan.noOfDays }-${plan.planPrice}">${plan.planName }</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group" >
			<label for="planPrice">Plan Price</label> <input type="number"
				class="form-control" id="planPrice" name="planPrice">
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
<jsp:include page="./footer.jsp"></jsp:include>