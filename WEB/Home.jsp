<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<%@ include file="include/style.jsp"%>
</head>

<body>

	<%@ include file="include/header.jsp"%>

	<!-- BEGIN MAIN TABLE -->
	<table class="main-table">
		<tr>
			<td class="td-side">
				<div class="questionnaire">
					<a href="/ProgettoDB2_WEB/QuestionnaireMarketingServlet">Questionnaire,
						marketing part</a>

				</div>
				<div class="leaderboard">
					<a href="/ProgettoDB2_WEB/LeaderboardServlet">Leaderboard</a>
				</div>
			</td>
			<td class="td-center">
				<h1>Welcome to the Home Page ${user.getUsername()}</h1>
				<div class="dayprod">

					<p>Product of the day (name, image, reviews)</p>
					<p>The product of the day is
						${productOfTheDay.getProductName()}</p>
					<img src="img/${productOfTheDay.getImage()}" alt="product image"
						width="200px" height="100px"> <br> <br>

					<table>
						<tr>
							<td colspan="3">Reviews</td>
						</tr>
						<tr>
							<td>Author</td>
							<td>Rate</td>
							<td>Review Text</td>
						</tr>
						<c:forEach items="${reviews}" var="review">
							<tr>
								<td><c:out value="${review.getAuthor()}" /></td>
								<td><c:out value="${review.getRate()}" /></td>
								<td><c:out value="${review.getReview()}" /></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</td>
			<td class="td-side"><img src="img/new.gif" width="128" hwight="128"></td>
		</tr>
	</table>
	<!-- END MAIN TABLE -->

	<%@ include file="include/footer.jsp"%>

</body>
</html>