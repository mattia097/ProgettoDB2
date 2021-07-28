<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administration</title>
<%@ include file="include/style.jsp"%>
</head>
<body>
	<%@ include file="include/header.jsp"%>

	<table class="main-table">
		<tr>
			<td class="td-side"><img src="new.gif" width="128" height="128"></td>
			<td class="td-center">
				<h1>Administration</h1> <a href="/ProgettoDB2_WEB/CreationServlet">Creation
					Page</a> <br> <a href="/ProgettoDB2_WEB/InspectionServlet">Inspection
					Page</a> <br> <a href="/ProgettoDB2_WEB/DeletionServlet">Deletion
					Page</a> <br>
			</td>
			<td class="td-side"><img src="new.gif" width="128" height="128"></td>
		</tr>
	</table>
	<!-- END MAIN TABLE -->

	<%@ include file="include/footer.jsp"%>
</body>
</html>