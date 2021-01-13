<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="./adminNavbar.jsp"></jsp:include>
<script type="text/javascript">
	function validateForm(){
		return true;
	}
</script>
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

<jsp:include page="./footer.jsp"></jsp:include>