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
        <p>Welcome ${name}. You have been logged.</p>
        <p>Now, you can <a href="/listTodos">manage your todos.</a></p>
    </div>
</body>
</html>