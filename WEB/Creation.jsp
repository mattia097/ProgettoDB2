<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Creation page</title>
<%@ include file="include/style.jsp"%>
</head>
<body>
	<%@ include file="include/header.jsp"%>

	<table class="main-table">
		<tr>
			<td class="td-side"><img src="new.gif" width="128" height="128"></td>
			<td class="td-center">

				<h1>Creation page</h1>

				<table id="tab-questions">
					<tr>
						<th>Product Id</th>
						<th>Question</th>
					</tr>
					<c:forEach items="${questions}" var="question">
						<tr>
							<td><c:out value="${question.getProduct().getProductId()}" /></td>
							<td><c:out value="${question.getQuestionText()}" /></td>
						</tr>
					</c:forEach>


				</table>
				<form id="form-create-question"
					action="/ProgettoDB2_WEB/CreateQuestion" method="post">
					<table id="tab-insert-question">
						<caption>Insert new question</caption>
						<tr>
							<td><label>product id: </label> <input type="number"
								name="field-product-id" id="field-product-id"></td>
							<td><label>question text:</label> <input type="text"
								name="field-question-text" id="field-question-text"></td>

							<td><input type="submit" value="Submit"></td>
						</tr>
					</table>
				</form>
				<table id="tab-products">
					<tr>
						<th>Product Id</th>
						<th>Product Name</th>
						<th>Date</th>
					</tr>
					<c:forEach items="${products}" var="product">
						<tr>
							<td>${product.getProductId()}</td>
							<td>${product.getProductName()}</td>
							<td>${product.getDate()}</td>
						</tr>
					</c:forEach>
				</table>
				<form id="form-create-product"
					action="/ProgettoDB2_WEB/CreateProduct" method="post">
					<table id="tab-insert-product">
						<caption>Insert new product</caption>
						<tr>
							<td><label>administrator id: </label> <input type="number"
								name="field-administrator-id" id="field-administrator-id"></td>
							<td><label>product name:</label> <input type="text"
								name="field-product-name" id="field-product-name"></td>
							<td><label>date: (yyyy-mm-dd) </label> <input type="date"
								name="field-date" id="field-date"></td>
							<td><label>image: </label> <input type="text"
								name="field-image" id="field-image"></td>

							<td><input type="submit" value="Submit"></td>
						</tr>
					</table>
				</form>
				<form id="form-modify-product"
					action="/ProgettoDB2_WEB/ModifyProductDate" method="post">
					<table id="tab-modify-product">
						<caption>Modify a product date</caption>
						<tr>
							<td><label>product id: </label> <input type="number"
								name="field-product-id" id="field-product-id"></td>
							<td><label>date: (yyyy-mm-dd)</label> <input type="date"
								name="field-date" id="field-date"></td>

							<td><input type="submit" value="Submit"></td>
						</tr>
					</table>
				</form>
				<br>
				<br>
				<a href="/ProgettoDB2_WEB/AdministrationServlet"> Administration page</a>
			</td>
			<td class="td-side"><img src="new.gif" width="128" height="128"></td>
		</tr>
	</table>


	<%@ include file="include/footer.jsp"%>
</body>
</html>