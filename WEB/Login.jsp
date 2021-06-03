<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="style/MainStyle.css">
</head>
<body>
	<form id="form-login" action="/ProgettoDB2_WEB/LoginServlet"
		method="post">
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
				<td colspan="2"><input type="submit" id="btn-submit" value="Accedi"></td>
			</tr>
		</table>
	</form>
</body>
</html>