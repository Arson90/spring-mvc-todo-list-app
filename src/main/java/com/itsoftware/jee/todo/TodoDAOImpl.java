package com.itsoftware.jee.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TodoDAOImpl implements TodoDAO{

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public TodoDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Todo getTodo(int id) {
		String sql = "SELECT * FROM todo WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new TodoMapper(), id);
	}

	@Override
	public List<Todo> getAllTodos() {
		String sql = "SELECT * FROM todo";
		return jdbcTemplate.query(sql, new TodoMapper());
	}

	@Override
	public int addTodo(Todo todo) {
		String sql = "INSERT INTO todo(id, user_name, description, target_date, is_done) VALUES(?,?,?,?,?)";
		return jdbcTemplate.update(sql, todo.getId(), todo.getUserName(), todo.getDescription(), todo.getTargetDate(), todo.isDone());
	}

	@Override
	public int updateTodo(Todo todo) {
		String sql = "UPDATE todo SET user_name=?, description=?, target_date=?, is_done=? WHERE id=?";
		return jdbcTemplate.update(sql, todo.getUserName(), todo.getDescription(), todo.getTargetDate(), todo.isDone(), todo.getId());
	}

	@Override
	public int deleteTodo(int id) {
		String sql = "DELETE FROM todo WHERE id=?";
		return jdbcTemplate.update(sql, id);
	}
}
