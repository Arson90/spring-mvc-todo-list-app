package com.itsoftware.jee.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Size;

@Service
public class TodoDAOImpl implements TodoDAO{

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public TodoDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private static List<Todo> listTodos = new ArrayList<>();
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
		List<Todo> filteredTodos = new ArrayList<>();
		
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

	@Override
	public Todo getTodo(int id) {
		String sql = "SELECT * FROM Todo WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new TodoMapper(), id);
	}

	@Override
	public List<Todo> getAllTodos() {
		String sql = "SELECT * FROM Todo";
		return jdbcTemplate.query(sql, new TodoMapper());
	}

	@Override
	public int addTodo(Todo todo) {
		String sql = "INSERT INTO Todo(id, user, description, targetDate, isDone) VALUES(?,?,?,?,?)";
		return jdbcTemplate.update(sql, todo.getId(), todo.getUser(), todo.getDescription(), todo.getTargetDate(), todo.isDone());
	}

	@Override
	public int updateTodo(Todo todo) {
//		String sql = "UPDATE Todo SET " +
//				"id='" + todo.getId() +
//				"', user=" + todo.getUser() +
//				", description=" + todo.getDescription() +
//				", targetDate=" + todo.getTargetDate() +
//				", isDone=" +  todo.isDone() +
//				""
		return 0;
	}

	@Override
	public int deleteTodo(int id) {
		return 0;
	}
}
