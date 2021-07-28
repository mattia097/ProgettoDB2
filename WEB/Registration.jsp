<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="include/style.jsp"%>
<title>Registrati</title>
<script type="text/javascript">
	function checkPasswordEquivalence() {
		var pass1 = document.getElementById('password').value;
		var pass2 = document.getElementById('check-password').value;
		var form = document.getElementById('form-registration');

		if (pass1 === pass2) {
			return true;
		} else {
			alert('Le password devono essere uguali');

			return false;
		}
	}
</script>
</head>
<body>
	<%@ include file="include/header.jsp"%>

	<!-- BEGIN MAIN TABLE -->
	<table class="main-table">
		<tr>
			<td class="td-side"></td>
			<td class="td-center">
				<form name="form-registration" id="form-registration"
					action="/ProgettoDB2_WEB/RegistrationServlet" method="post">
					<table id="tab-registration">
						<tr>
							<td><label>Nome</label></td>
							<td><input type="text" name="field-name"></td>
						</tr>
						<tr>
							<td><label>Cognome</label></td>
							<td><input type="text" name="field-surname"></td>
						</tr>
						<tr>
							<td><label>Nome Utente</label></td>
							<td><input type="text" name="field-usr"></td>
						</tr>
						<tr>
							<td><label>Email</label></td>
							<td><input type="email" name="field-email"></td>
						</tr>
						<tr>
							<td><label>Password</label></td>
							<td><input type="password" name="field-psw" id="password"></td>
						</tr>
						<tr>
							<td><label>Conferma Password</label></td>
							<td><input type="password" name="field-check-psw"
								id="check-password"></td>
						</tr>
						
						<!--
						<tr>
							<td><label>Data di nascita</label></td>
							<td><input type="date" name="field-birth-date"></td>
						</tr>
						<tr>
							<td><label>Sesso</label></td>
							<td><label for="male">Male</label> <input type="radio"
								name="field-sex" id="male" value="male"> <label
								for="female">Female</label> <input type="radio" name="field-sex"
								id="female" value="female"> <label for="other">Other</label>
								<input type="radio" name="field-sex" id="other" value="other">
							</td>
						</tr>
						-->
						
						<tr>
							<td colspan="2"><input type="submit" value="Registrati"
								onclick="return checkPasswordEquivalence()"></td>
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