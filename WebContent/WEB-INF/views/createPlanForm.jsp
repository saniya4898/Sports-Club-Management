<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="./adminNavbar.jsp"></jsp:include>
<script>
function validateForm(){
	return true;
}
</script>
<style>
.h1 {
	margin-top: 50px;
	text-align: center;
}

.container {
	background-color: rgb(243, 250, 240);
	border-radius: 1rem;
	width: 500px;
	padding: 20px;
	font-size: 16px;
	margin-top: 50px;
	text-align: left; ! important;
	border-color: rgba(82, 168, 236, 0.8);
	box-shadow: 0px 15px 20px rgba(82, 168, 236, 0.6);
}

.row {
	padding-left: 40px;
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
</style>
<div class="h1">Add Membership Plan</div>
<div class="container">
	<form action="/Sports_Club_Management/admin/createPlan" method="post"
		onsubmit="return validateForm()">
		<div class="form-group">
			<label for="planName">Plan Name</label> <input type="text"
				class="form-control" id="planName" name="planName"
				placeholder="Enter Plan Name">
		</div>
		<div class="form-group">
			<label for="noOfDays">No of Days</label> <input type="number"
				class="form-control" id="noOfDays" name="noOfDays"
				placeholder="No of Days">
		</div>
		<div class="form-group">
			<label for="price">Price</label> <input type="number"
				class="form-control" id="price" name="price" placeholder="Price">
		</div>

		<div id="buttonContainer">
			<button type="submit" class="btn btn-primary">ADD</button>
		</div>
	</form>
</div>
<jsp:include page="./footer.jsp"></jsp:include>