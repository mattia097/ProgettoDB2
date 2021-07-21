<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Home Page</title>
</head>

<body>

	<h1>Welcome to the Home Page ${user.getUsername()}</h1>
	<div class="dayprod">

		<p>Product of the day (name, image, reviews)</p>
		<p>The product of the day is ${productOfTheDay.getProductName()}</p>
		 <img src= "img/${productOfTheDay.getImage()}" alt="product image"> <br>
		 <br>
		 <p>Reviews: </p>
		 <c:forEach items="${reviews}" var="review">
      <td><c:out value="author: ${review.getAuthor()}  rate = ${review.getRate()}" /></td><br>
      <td><c:out value="${review.getReview()}" /></td><br>         
  </c:forEach>
		 


	</div>
	<div class="questionnaire">
		<p>Link to the questionnaire of the day</p>

	</div>
	<div class="leaderboard">
		<a href="/ProgettoDB2_WEB/LeaderboardServlet">Leaderboard</a>
	</div>


</body>
</html>