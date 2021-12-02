package com.itsoftware.jee.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> listTodos = new ArrayList<Todo>();
	private static int nextId = 3;
	
	static {
		listTodos.add(new Todo(1, "jan.kowalski", "Java, PHP, Pascal", new Date(), false));
		listTodos.add(new Todo(2, "adam.nowak", "C++, C#, VisualBasic", new Date(), false));
		listTodos.add(new Todo(3, "jan.kowalski", "JavaScript, TypeScript, C", new Date(), false));
	}
	
	public Todo retrieveTodo(int id) {
		for (Todo todo : listTodos) {
			if (todo.getId() == id)
				return todo;
		}
		return null;
	}
	
	public void updateTodo(int id, String description, Date targetDate) {
		Todo todo = retrieveTodo(id);
		todo.setDescription(description);
		todo.setTargetDate(targetDate);
	}
	
	public void addTodo(String username, String description, Date targetDate) {
		listTodos.add(new Todo(++nextId, username, description, targetDate, false));
	}
	
	public List<Todo> getTodoByUser(String username) {
		List<Todo> filteredTodos = new ArrayList<Todo>();
		
		for(Todo tempTodo : listTodos) {
			if(tempTodo.getUser().equals(username)) {
				filteredTodos.add(tempTodo);
			}
		}
		return filteredTodos;
	}
	
	public void deleteTodoById(int id) {
		Iterator<Todo> iterator = listTodos.iterator();
		while (iterator.hasNext()) {
			Todo tempTodo = iterator.next();
			if(tempTodo.getId()==id) {
				iterator.remove();
			}
		}
	}
}
