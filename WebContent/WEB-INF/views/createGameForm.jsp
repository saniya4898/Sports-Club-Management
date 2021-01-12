<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
function validateForm(){
	return true;
}
</script>
</head>
<body>
	Hello Game form
	<form action="/Sports_Club_Management/admin/createGame" method="post" onsubmit="return validateForm()">
		<div class="form-group">
			<label for="gameName">Game Name</label> <input
				type="text" class="form-control" id="gameName" name="gameName"
				placeholder="Enter Game Name"> 
		</div>
		
		<button type="submit" class="btn btn-primary" >Submit</button>
	</form>
</body>
</html>