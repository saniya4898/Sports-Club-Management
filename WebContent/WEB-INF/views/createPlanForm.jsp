<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="./adminNavbar.jsp"></jsp:include>
<script>
function validateForm(){
	return true;
}
</script>

	Hello Plan form
	<form action="/Sports_Club_Management/admin/createPlan" method="post" onsubmit="return validateForm()">
		<div class="form-group">
			<label for="planName">Plan Name</label> <input
				type="text" class="form-control" id="planName" name="planName"
				placeholder="Enter Plan Name"> 
		</div>
		<div class="form-group">
			<label for="noOfDays">No of Days</label> <input
				type="number" class="form-control" id="noOfDays" name="noOfDays"
				placeholder="No of Days">
		</div>
		<div class="form-group">
			<label for="price">Price</label> <input
				type="number" class="form-control" id="price" name="price"
				placeholder="Price">
		</div>
		
		<button type="submit" class="btn btn-primary" >Submit</button>
	</form>
<jsp:include page="./footer.jsp"></jsp:include>