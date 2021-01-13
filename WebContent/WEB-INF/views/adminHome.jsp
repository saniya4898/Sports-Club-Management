<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="./adminNavbar.jsp"></jsp:include>
Admin home
<ul>
	<li><a href="/Sports_Club_Management/admin/createClerkForm">Create Clerk</a></li>
	<li><a href="/Sports_Club_Management/admin/viewClerks">View Clerks</a></li>
	<li><a href="/Sports_Club_Management/admin/createGameForm">Add Game</a></li>
	<li><a href="/Sports_Club_Management/admin/viewGames">View Games</a></li>
	<li><a href="/Sports_Club_Management/admin/createPlanForm">Add Membership Plan</a></li>
	<li><a href="/Sports_Club_Management/admin/viewPlans">View Membership Plans</a></li>
	<li><a href="/Sports_Club_Management/admin/logoutAdmin">Logout</a></li>
</ul>
<jsp:include page="./footer.jsp"></jsp:include>