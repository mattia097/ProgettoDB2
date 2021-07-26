<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="it">
<head>
<meta charset="ISO-8859-1">
<title>Questionario - Sezione Marketing</title>
<%@ include file="include/style.jsp"%>
</head>
<body>
	<%@ include file="include/header.jsp"%>

	<!-- BEGIN MAIN TABLE -->
	<table class="main-table">
		<tr>
			<td class="td-side"><img src="new.gif" width="128" hwight="128"></td>
			<td class="td-center">
				<h2 id="h-main-title">Questionario - Sezione Marketing</h2>

				<h3>Product of the day: ${productName}</h3>

				<form id="form-questionnaire-marketing"
					action="/ProgettoDB2_WEB/QuestionnaireMarketingServlet"
					method="post">
					<table id="tab-questionnaire-marketing">
						<tr>
							<td>Questions</td>
							<td>Yes</td>
							<td>No</td>
						</tr>

						<!-- Codice generato dinamicamente, lista di domande con risposte -->
						<c:forEach items="${questions}" var="question">
							<tr>
								<td>${question.getQuestionText()}</td>
								<td><input type="radio"
									name="rd_${question.getQuestionId()}" value="yes" /></td>
								<td><input type="radio"
									name="rd_${question.getQuestionId()}" value="no" /></td>
							</tr>
						</c:forEach>
					</table>

					<input type="submit" value="Successivo">
				</form>
			</td>
			<td class="td-side"><img src="new.gif" width="128" hwight="128"></td>
		</tr>
	</table>
	<!-- END MAIN TABLE -->

	<%@ include file="include/footer.jsp"%>

</body>
</html>