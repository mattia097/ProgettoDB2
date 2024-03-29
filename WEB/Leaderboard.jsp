<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Leaderboard</title>
<%@ include file="include/style.jsp"%>
</head>
<body>
	<%@ include file="include/header.jsp"%>

	<!-- BEGIN MAIN TABLE -->
	<table class="main-table">
		<tr>
			<td class="td-side"></td>
			<td class="td-center">
				<h1>This is the leaderboard of today</h1> 
				<table id="tab-questionnaires">
					<tr>
						<th>Username</th>
						<th>Points</th>
					</tr>
					<c:forEach items="${questionnaires}" var="questionnaire">
						<tr>
							<td>${questionnaire.getUser().getUsername()}</td>
							<td>${questionnaire.getPoints()}</td>
						</tr>
					</c:forEach>
				</table>

			</td>
			<td class="td-side"><a href="/ProgettoDB2_WEB/HomeServlet">Home</a>
			</td>
		</tr>
	</table>
	<!-- END MAIN TABLE -->

	<%@ include file="include/footer.jsp"%>

</body>
</html>