<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo list</title>
	<link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body class="bg-success p-2 text-dark bg-opacity-25">
	<div class="container">
		<h2>Hi ${name}</h2>
		<table class="table table-striped">
			<caption>Todos are:</caption>
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
						<td>${todo.user}</td>
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
		</div>
		
	</div>
	<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.js"></script>
	<script>
		$('#targetDate').datepicker({
			format : 'dd/mm/yyyy'
		});
	</script>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>