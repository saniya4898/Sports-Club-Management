<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="./adminNavbar.jsp"></jsp:include>
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
<jsp:include page="./footer.jsp"></jsp:include>
	