<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p><font color="red">${errorMessage}</font></p>
	<form action="welcome" method="post">
		<label>User Name</label>
		<input type="text" name="username" />
		<br><br>
		<label>Password</label>
		<input type="password" name="password"/>
		<br><br>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>