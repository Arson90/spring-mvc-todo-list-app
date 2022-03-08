<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Edit Todo</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
		        rel="stylesheet"
		        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
		        crossorigin="anonymous">
	</head>
	<body class="bg-success p-2 text-dark bg-opacity-25">
		<div class="container">
			<h1>Edit a Todo</h1><br><hr>
			<form:form action="edit-todo" method="post" modelAttribute="todo">
			    <input type="hidden" name="name" value="${name}"/>
                <input type="hidden" name="pageNumber" value="${currentPageNumber}"/>
                <input type="hidden" name="sort" value="${sort}"/>
				<form:hidden path="id"/>
				<fieldset class="form-group">
          <form:label path="userName">User Name</form:label>
          <form:input path="userName" type="text" class="form-control" value="${name}" readonly="true"/>
          <form:errors path="userName" cssClass="text-warning" />
        </fieldset><br>
    
				<fieldset class="form-group">
					<form:label path="description">Description</form:label>
					<form:input path="description" type="text" class="form-control" required="required"/>
					<form:errors path="description" cssClass="text-warning" />
				</fieldset><br>
				
				<fieldset class="form-group">
					<form:label path="targetDate">Target Date</form:label>
					<form:input path="targetDate" type="text" class="form-control" required="required"/>
					<form:errors path="targetDate" cssClass="text-warning" />
				</fieldset><br><hr>
				<button type="submit" class="btn btn-success">Save</button><br><br>
			</form:form>
			<div>

			  <a class="btn btn-success" href="/list-todos?name=${name}&pageNumber=${currentPageNumber}&sort=${sort}" role="button">Back To Todo List </a>
      </div>
		</div>

		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>
</html>
