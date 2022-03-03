<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
	</head>
	<body class="bg-success p-2 text-dark bg-opacity-25">
		<div class="container">
			<h1>Add a Todo</h1>
			<form:form action="addTodo" method="post" modelAttribute="todo">
			    	<fieldset class="form-group">
                			<form:label path="userName">User Name</form:label>
                			<form:input path="userName" type="text" class="form-control" value="${name}" readonly="true"/>
                			<form:errors path="userName" cssClass="text-warning" />
                		</fieldset>

				<fieldset class="form-group">
					<form:label path="description">Description</form:label>
					<form:input path="description" type="text" class="form-control" required="required"/>
					<form:errors path="description" cssClass="text-warning" />
				</fieldset>
				
				<fieldset class="form-group">
					<form:label path="targetDate">Target Date</form:label>
					<form:input path="targetDate" type="text" class="form-control" required="required"/>
					<form:errors path="targetDate" cssClass="text-warning" />
				</fieldset>
				<button type="submit" class="btn btn-success">Add</button>
			</form:form>
		</div>
		
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>
</html>
