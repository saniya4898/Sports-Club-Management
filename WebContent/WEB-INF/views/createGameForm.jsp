<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="./adminNavbar.jsp"></jsp:include>
<script>
function validateForm(){
	return true;
}
</script>

	Hello Game form
	<form action="/Sports_Club_Management/admin/createGame" method="post" onsubmit="return validateForm()">
		<div class="form-group">
			<label for="gameName">Game Name</label> <input
				type="text" class="form-control" id="gameName" name="gameName"
				placeholder="Enter Game Name"> 
		</div>
		
		<button type="submit" class="btn btn-primary" >Submit</button>
	</form>
<jsp:include page="./footer.jsp"></jsp:include>