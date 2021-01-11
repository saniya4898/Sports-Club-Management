<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="./base.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sports Club Management</title>
</head>
<script type="text/javascript">
	function validateForm(){
		return true;
	}
</script>
<body>
	<h1>Welcome</h1>
	<form action="/Sports_Club_Management/login" method="post" onsubmit="return validateForm()">
		<select class="form-group" name="userCategory">
			<option value="admin" >Admin</option>
			<option value="clerk" >Clerk</option>
		</select>
		<div class="form-group">
			<label for="userName">User Name</label> <input
				type="text" class="form-control" id="userName" name="userName"
				placeholder="Enter User Name"> 
		</div>
		<div class="form-group">
			<label for="password">Password</label> <input
				type="password" class="form-control" id="password" name="password"
				placeholder="Password">
		</div>
		<button type="submit" class="btn btn-primary" >Submit</button>
	</form>

</body>
</html>