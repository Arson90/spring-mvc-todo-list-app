<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
    		        rel="stylesheet"
    		        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
    		        crossorigin="anonymous">
</head>
<body class="bg-success p-2 text-dark bg-opacity-25">
    <div class="container">
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
    </div>
</body>
</html>