<%@page import="com.accolite.Service.AUService"%>
<%@page import="java.util.List"%>
<%@page import="com.accolite.Entity.*"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<form class="login100-form validate-form p-l-55 p-r-55 p-t-178"  method="post" action="unlockUser" id="unlockUserForm">
	<table class="table table-hover table-bordered"">
		<thead .thead-dark>
			<tr>
				<th>User ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>User Name</th>
				<th>Password</th>
				<th>Status</th>
				<th>Unlock</th>
			</tr>
		</thead>
		<tbody>
			<%
				List<Integer> unlockUserList = new ArrayList();
				AUService loginService = new AUService();
				List<Mst_User> list = loginService.getUserList();
				for (Mst_User u : list) {
			%>
			<tr>
				<td><%=u.getId()%></td>
				<td><%=u.getFirstName()%></td>
				<td><%=u.getLastName()%></td>
				<td><%=u.getUserName()%></td>
				<td><%=u.getUserPassword()%></td>
				<td>
				<%
				if(u.getBlocked()) {
					out.println("Blocked");
				}
				else {
					out.println("Active");
				}
				%></td> 
				 <td>
				 <%
				if(u.getBlocked()) { %>
					<button id=<%=u.getId()%> onclick="getSelectedRow(this.id)" type="button"> Select for Unlock</button>
				 <% }
				else { %>
					<button disabled="disabled" style="opacity: 0.65;  cursor: not-allowed"> Already Active </button>
			<%	}
				%>
				 </td>
			</tr>
			<%
				}
			%>
			<input type="text" hidden="hidden" id="hiddenUnlockUserList" name="hiddenUnlockUserList">
		<!-- style="opacity: 0.65;  cursor: not-allowed"  -->
		<tbody>
	</table>
	
	<button class="login100-form-btn">
		Unlock Users
	</button>
	</form>
	
<script type="text/javascript">
function getSelectedRow(id) {
	alert(id);
  console.log(id);
  document.getElementById(id).innerHTML = "Selected for unlock";
  document.getElementById("hiddenUnlockUserList").value += id + ",";
}
</script>
	<!-- <table class="table table-hover">
		<thead>
			<tr>
				<th>Firstname</th>
				<th>Lastname</th>
				<th>Email</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>John</td>
				<td>Doe</td>
				<td>john@example.com</td>
			</tr>
			<tr>
				<td>Mary</td>
				<td>Moe</td>
				<td>mary@example.com</td>
			</tr>
			<tr>
				<td>July</td>
				<td>Dooley</td>
				<td>july@example.com</td>
			</tr>
		</tbody>
	</table> -->
</body>
</html>