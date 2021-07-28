<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deletion</title>
<%@ include file="include/style.jsp"%>
</head>
<body>
	<%@ include file="include/header.jsp"%>

	<table class="main-table">
		<tr>
			<td class="td-side">
			<a href="/ProgettoDB2_WEB/AdministrationServlet"> Administration page</a>
			</td>
			<td class="td-center">
				<table>
					<c:forEach items="${products}" var="product">
						<tr>
							<td>${product.getProductId()}</td>
							<td>${product.getProductName()}</td>
							<td>${product.getDate()}</td>
						</tr>
					</c:forEach>
				</table>
				
				<form method="POST" action="/ProgettoDB2_WEB/DeletionServlet">
					<label>Cancella le domande del prodotto:</label>
					<input type="number" name="product-id">
					<input type="submit" value="cancella domande">
				</form>
			</td>
			<td class="td-side"><img src="new.gif" width="128" height="128"></td>
		</tr>
	</table>


	<%@ include file="include/footer.jsp"%>
</body>
</html>