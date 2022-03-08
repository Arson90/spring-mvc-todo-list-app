<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo list</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
    		        rel="stylesheet"
    		        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
    		        crossorigin="anonymous">
</head>
<body class="bg-success p-2 text-dark bg-opacity-25">
	<div class="container">
		<h2>Hi ${name}</h2><br>
		<form action="/listTodos" method="get">
		    <input type="hidden" name="pageNumber" value="${currentPageNumber}" />
            <label for="sort">Sort by:</label>
            <select id="sort" name="sort">
                <option value="id">Id</option>
                <option value="user_name">User name</option>
                <option value="target_date">Target date</option>
            </select>
            <input type="submit" value="Sort"/>
        </form><br>
		<caption>Todos are:</caption>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>User name</th>
					<th>Description</th>
					<th>Date</th>
					<th>Is Completed</th>
					<th>Action</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${listTodos}" var="todo">
					<tr>
						<td>${todo.id}</td>
						<td>${todo.userName}</td>
						<td>${todo.description}</td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${todo.targetDate}" /></td>
						<td>${todo.done}</td>
						<td>
							<a type="button" class="btn btn-primary" href="/edit-todo?id=${todo.id}">Edit</a>
							|
							<a type="button" class="btn btn-danger" href="/deleteTodo?id=${todo.id}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a type="button" class="btn btn-success" href="/addTodo">Add new todo</a>
		</div><br>
		<div>
		    <c:forEach var="i" begin="1" end="${page}" step="1">
		        <a type="button" class="btn btn-primary" href="/listTodos?pageNumber=${i}&sort=${sort}">${i}</a>
		    </c:forEach>
		</div>
	</div>
	<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.js"></script>
	<script>
		$('#targetDate').datepicker({
			format : 'dd/mm/yyyy'
		});
	</script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>