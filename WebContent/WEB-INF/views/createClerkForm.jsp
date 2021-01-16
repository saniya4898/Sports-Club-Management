<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="./adminNavbar.jsp"></jsp:include>
<script>
	function validateForm() {
		return true;
	}
</script>
<style>
body {
	text-align: center;
}

h1 {
	margin-top: 50px;
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

form {
	padding: 10px
}

#buttonContainer {
	text-align: center;
}

input[type=text]:hover, input[type=password]:hover {
	border-color: rgba(82, 168, 236, 0.8);
	box-shadow: 0px 0px 8px rgba(82, 168, 236, 0.6);
}

.msg {
	text-align: center;
	font-weight: bold;
}
</style>
</head>
<body>
	<h1>Create Clerk Form</h1>
	<div class="container">

		<form action="/Sports_Club_Management/admin/createClerk" method="post"
			onsubmit="return validateForm()">
			<div class="form-group">
				<label for="userName">User Name</label> <input type="text"
					class="form-control" id="userName" name="userName"
					placeholder="Enter User Name">
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					class="form-control" id="password" name="password"
					placeholder="Password">
			</div>
			<div id="buttonContainer">
				<button type="submit" class="btn btn-primary">SUBMIT</button>
			</div>
		</form>
		<div class="msg">
			<h4>${msg }</h4>
		</div>
	</div>


	<jsp:include page="./footer.jsp"></jsp:include>