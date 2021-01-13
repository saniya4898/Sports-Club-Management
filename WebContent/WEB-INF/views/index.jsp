<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="./adminNavbar.jsp"></jsp:include>
<style>
.container {
	text-align: center;
	font-size: 16px;
}
.form{
	text-align: center;
}
.row {
	margin-left:400px;
	text-align: left;!important
	
}
.col {
	width: 150px;
}
#userCategory{
	width:25%
}
</style>

<script type="text/javascript">
	function validateForm() {
		return true;
	}
</script>

<div class="container">
	<h1>LOGIN</h1>
	<form action="/Sports_Club_Management/login" method="post"
		onsubmit="return validateForm()">
		<div class="form-group form-inline row ">
			<label for="userCategory" class="col">User Category</label> <select
				class="form-control col " name="userCategory" id="userCategory">
				<option value="admin">Admin</option>
				<option value="clerk">Clerk</option>
			</select>
		</div>
		<div class="form-group form-inline row">
			<label for="userName" class="col">User Name</label> <input
				type="text" class="form-control col" id="userName" name="userName"
				placeholder="Enter User Name">
		</div>
		<div class="form-group form-inline row">
			<label for="password" class="col">Password</label> <input
				type="password" class="form-control col" id="password"
				name="password" placeholder="Password">
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>

</div>

<jsp:include page="./footer.jsp"></jsp:include>