package com.itsoftware.jee.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
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
	public List<Todo> getAllTodos(Pageable pageable) {
		String sql = "SELECT * FROM todo ORDER BY user_name LIMIT " + pageable.getPageSize() + " " + "OFFSET " + pageable.getOffset();
		return jdbcTemplate.query(sql, new TodoMapper());
	}

	public int countingPages(){
		String sql = "SELECT COUNT(*) FROM todo";
		double count = jdbcTemplate.queryForObject(sql, Double.class) / 10;
		int page = 0;
		page = (int)Math.ceil(count);
		return page;
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
