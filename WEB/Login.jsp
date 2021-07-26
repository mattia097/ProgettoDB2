<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<%@ include file="include/style.jsp"%>
</head>
<body>

	<%@ include file="include/header.jsp"%>

	<!-- BEGIN MAIN TABLE -->
	<table class="main-table">
		<tr>
			<td class="td-side"></td>
			<td class="td-center">
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
							<td colspan="2"><input type="submit" id="btn-submit"
								value="Accedi"></td>
						</tr>
					</table>
				</form>
			</td>
			<td class="td-side"></td>
		</tr>
	</table>

	<!-- END MAIN TABLE -->

	<%@ include file="include/footer.jsp"%>
</body>
</html>