<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer SignUp</title>
</head>
<body>
		<form id="sign_up_form" method="post" action="/signUp">
				<div class="form_description">
						<h2>Customer SignUp</h2>
				</div>

				<label class="name">Name </label>
				<div>
						<input name="name" type="text" maxlength="255">
				</div>
				<label class="email">Email </label>
				<div>
						<input name="email" type="email" maxlength="20">
				</div>
				<label class="password">Password </label>
				<div>
						<input name="password" type="password" maxlength="16">
				</div>

				<input id="saveForm" type="submit" name="submit" value="Submit">

		</form>
</body>
</html>