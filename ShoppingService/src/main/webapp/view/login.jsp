<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Cart</title>
</head>
<body>
<body>


	<div class="page-title">Login (For Customer)</div>

	<div class="login-container">

		<h3>Enter username and password</h3>
		<br>
		<!-- /login?error=true -->
		<c:if test="${param.error == 'true'}">
			<div style="color: red; margin: 10px 0px;"></div>
		</c:if>

		<form method="POST"
			action="${pageContext.request.contextPath}/j_spring_security_check">
			<table>
				<tr>
					<td>User Name *</td>
					<td><input name="userName" /></td>
				</tr>

				<tr>
					<td>Password *</td>
					<td><input type="password" name="password" /></td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" value="Login" /> <input type="reset"
						value="Reset" /></td>
				</tr>
			</table>
		</form>

		<span class="error-message">${error }</span>

	</div>


	<

</body>
</html>