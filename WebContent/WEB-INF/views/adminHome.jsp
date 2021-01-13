<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="./adminNavbar.jsp"></jsp:include>
<div class="container">
	<div class="jumbotron">
		<h1 class="display-4">Hello, ${userName }!</h1>
		<p class="lead">Welcome to Sports Club Management.</p>
		<hr class="my-4">
		<p>Here you will be able to manage your club's Clerks, Games &
			Membership Plans.</p>
		<p>For any query write to us at : info@sportsclub.com</p>
	</div>
</div>

<jsp:include page="./footer.jsp"></jsp:include>