<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Statistics</title>
</head>

<style>
	.buttons{
		height:25px;
    	width:70px;
		text-align: center;
	}

</style>

<body>
	<h1>Statistics Page</h1>
	<br>
	<br>
	<div class='questions' >
		<form id="questions" action="/ProgettoDB2_WEB/GreetingsServlet" method="POST" >
			<label>Age: </label> <input type="number" name="field-age" id="field-age" min="1" max="100"> <br>
			<br>
			<br>
			<table id='tab-gender'>
				<tr>
					<td> <p>Select your gender: </p></td>
				</tr>
				<tr>
				<td> <label for="field-male">M</label> </td>
				<td> <input type="radio" name="gender" id="field-male" value="male"> </td> </tr>
				<tr>
				<td><label for="field-female">F</label></td>
				<td><input type="radio" name="gender" id="field-female" value="female"></td>
				</tr>
			</table>
			<br>
			<br>
			<table id='tab-expertise'>
				<tr>
					<td> <p>Specify your level of expertise </p></td>
				</tr>
				<tr>
				<td> <label for="field-low">Low</label> </td>
				<td> <input type="radio" name="expertise" id="field-low" value="low"> </td> </tr>
				<tr>
				<td><label for="field-medium">Medium</label></td>
				<td><input type="radio" name="expertise" id="field-medium" value="medium"></td>
				</tr>
				<tr>
					<td><label for="field-high">High</label></td>
					<td><input type="radio" name="expertise" id="field-high" value="high"></td>
					</tr>
			</table>
			
			<table id="tab-buttons">
			<tr>
				<td> <button class='buttons' type='submit' form="questions" name='submit' >Submit</button> </td>
				<td> <button class='buttons' type='submit' form="questions" name="cancel" formaction="/ProgettoDB2_WEB/HomeServlet" formmethod="GET">Cancel</button> </td>
				<td> <button class='buttons' type='submit' form="questions" name="previous" formaction="/ProgettoDB2_WEB/QuestionnaireMarketingServlet" formmethod="GET">Previous</button> </td>
			</tr>
		</table>
		</form>
	</div>

	<div class='buttons'>
		
	</div>

</body>
</html>