<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inspection Page</title>
<%@ include file="include/style.jsp"%>
</head>
<body>
	<%@ include file="include/header.jsp"%>

	<!-- BEGIN MAIN TABLE -->
	<table class="main-table">
		<tr>
			<td class="td-side">
			<a href="/ProgettoDB2_WEB/AdministrationServlet"> Administration page</a>
			</td>
			<td class="td-center">
				<h1>Inspection Page</h1>
				<table id="tab-answers">
					<tr>
						<th>Product Id</th>
						<th>Product Name</th>
						<th>Question</th>
						<th>Answer</th>
						<th>Username</th>
					</tr>
					<c:forEach items="${answers}" var="answer">
						<tr>
							<td>${answer.getQuestion().getProduct().getProductId()}</td>
							<td>${answer.getQuestion().getProduct().getProductName()}</td>
							<td>${answer.getQuestion().getQuestionText()}</td>
							<td>${answer.isAnswer()}</td>
							<td>${answer.getUser().getUsername()}</td>
						</tr>
					</c:forEach>
					<tr>
						<td>date: ${date}</td>
					</tr>
				</table>

				<table id="tab-questionnaires">
					<tr>
						<th>Username</th>
						<th>Questionnaire</th>
					</tr>
					<c:forEach items="${questionnaires }" var="questionnaire">
						<tr>
							<td>${questionnaire.getUser().getUsername()}</td>
							<td>Canceled</td>
						</tr>
					</c:forEach>
				</table>

				<form id="form-search-questionnaires"
					action="/ProgettoDB2_WEB/InspectionServlet" method="post">
					<table id="tab-search-questionnaires">
						<caption>Insert date</caption>
						<tr>
							<td><label>date: (yyyy-mm-dd)</label> <input type="date"
								name="field-date" id="field-date"></td>

							<td><input type="submit" value="Submit"></td>
						</tr>
					</table>
				</form>
			</td>
			<td class="td-side"></td>
		</tr>
	</table>

	<%@ include file="include/footer.jsp"%>

</body>
</html>