<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<jsp:useBean id="service"
	class="it.polimi.db2.progettodb2.services.HomeService" />
<body>

	<h1>Welcome to the Home Page</h1>
	<div class="dayprod">

		<p>Product of the day (name, image, reviews)</p>
		<jsp:getProperty name="service" property="productOfTheDay" />

		<!-- use bean -->

	</div>
	<div class="questionnaire">
		<p>Link to the questionnaire of the day</p>

	</div>
	<div class="leaderboard">
		<a href="/ProgettoDB2_WEB/Leaderboard">Leaderboard</a>
		<!-- TODO: da fare -->

	</div>


</body>
</html>