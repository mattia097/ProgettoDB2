<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>

<body>

	<h1>Welcome to the Home Page ${user.getUsername()}</h1>
	<div class="dayprod">

		<p>Product of the day (name, image, reviews)</p>
		<p>${productOfTheDay.getProductName()}</p>
		
		<!-- <img src= url alt="Girl in a jacket"> -->
		 <img src= "img/${productOfTheDay.getImage()}" alt="product image">
		 <!-- ${pageContext.servletContext.contextPath}/src/main/webapp/img/box.jpg -->
		 


	</div>
	<div class="questionnaire">
		<p>Link to the questionnaire of the day</p>

	</div>
	<div class="leaderboard">
		<a href="/ProgettoDB2_WEB/LeaderboardServlet">Leaderboard</a>
		<!-- TODO: da fare -->

	</div>


</body>
</html>