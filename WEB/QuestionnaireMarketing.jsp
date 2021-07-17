<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>Questionario - Sezione Marketing</title>
<link rel="stylesheet" href="style/MainStyle.css">
</head>
<body>
	<h3 id="h-main-title">Questionario - Sezione Marketing</h3>

	<form id="form-questionnaire-marketing"
		action="/ProgettoDB2/QuestionnaireMarketingServlet" method="post">
		<table id="tab-questionnaire-marketing">

			<!-- Codice generato dinamicamente, lista di domande con risposte -->
			<c:forEach items="${questions}" var="question">
				<tr><td>${question}</td></tr>
			</c:forEach>
			
			<tr>
				<td><input type="submit" value="Successivo"></td>
			</tr>
		</table>
	</form>
</body>
</html>