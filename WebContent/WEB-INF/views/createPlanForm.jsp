<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function validateForm(){
	return true;
}
</script>
</head>
<body>
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
</body>
</html>