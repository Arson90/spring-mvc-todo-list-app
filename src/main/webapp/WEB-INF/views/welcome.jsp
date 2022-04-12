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
        <form action="/list-todos" method="get">
            <input type="hidden" name="name" value="${name}"/>
            <input type="hidden" name="pageNumber" value="1"/>
            <input type="hidden" name="sort" value="id"/>
            <input type="submit" value="Manage your todos" />
        </from>
        <br><br>
         <a href="/console">Go to H2 DB console</a>
    </div>
</body>
</html>