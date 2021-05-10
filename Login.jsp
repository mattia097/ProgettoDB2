<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login Page</title>
		<style>
			#tab-login {
				border: 1px solid black;
			}
		</style>
	</head>
	<body>
		<form action="/ProgettoDB2/LoginServlet" method="post">
			<table id="tab-login">
				<tr>
					<td><label>Username:</label></td>
					<td><input type="text" name="field-usr" id="field-usr"></td>
				</tr>
				<tr>
					<td><label>Password:</label></td>
					<td><input type="password" name="field-psw" id="field-psw"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" id="btn-submit"></td>
				</tr>
			</table>
		</form>
	</body>
</html>