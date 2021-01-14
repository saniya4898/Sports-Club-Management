<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="./loginNavbar.jsp"></jsp:include>
<style>
.h1{
	margin-top:50px;
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
.row{
	padding-left: 40px;
}
form{
	padding: 20px;
		
}
.col {
	width: 150px;
}
#userCategory{
	width:190px
}
#buttonContainer {
	text-align: center;
}

input[type=text]:hover, input[type=password]:hover,select:hover {
	border-color: rgba(82, 168, 236, 0.8);
	box-shadow: 0px 0px 8px rgba(82, 168, 236, 0.6);
}
</style>

<script type="text/javascript">
	function validateForm() {
		return true;
	}
</script>
<div class="h1">LOGIN</div>
<div class="container">
	
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
		<div id="buttonContainer">
				<button type="submit" class="btn btn-primary">LOGIN</button>
		</div>
	</form>

</div>

<jsp:include page="./footer.jsp"></jsp:include>