<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Leaderboard</title>
</head>
<body>
	<h1>This is the leaderboard of today</h1>
	
	 <c:forEach items="${users}" var="item">
      <td><c:out value="${item}" /></td><br>
  </c:forEach>
<br>
<br>
<br>

	<a href="/ProgettoDB2_WEB/HomeServlet">Home</a>
</body>
</html>