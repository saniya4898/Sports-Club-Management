<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	Hello Clerk form
	<form action="/Sports_Club_Management/admin/createClerk" method="post" onsubmit="return validateForm()">
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