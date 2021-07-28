<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Greetings</title>
<%@ include file="include/style.jsp"%>
</head>
<body>
	<%@ include file="include/header.jsp"%>

	<!-- BEGIN MAIN TABLE -->
	<table class="main-table">
		<tr>
			<td class="td-side"></td>
			<td class="td-center">
				<h1>Greetings!</h1>
				<p>
					Thank you for fulfilling our daily questionnaire! <br> <a
						href="/ProgettoDB2_WEB/HomeServlet">Home page</a>
				</p>
			</td>
			<td class="td-side"><img src="new.gif" width="128" height="128"></td>
		</tr>
	</table>
	<!-- END MAIN TABLE -->

	<%@ include file="include/footer.jsp"%>

</body>
</html>