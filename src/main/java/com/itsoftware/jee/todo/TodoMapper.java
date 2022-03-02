package com.itsoftware.jee.todo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TodoMapper implements RowMapper<Todo> {
    @Override
    public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Todo todo = new Todo();
        todo.setId(rs.getInt("id"));
        todo.setUser(rs.getString("user"));
        todo.setDescription(rs.getString("description"));
        todo.setTargetDate(rs.getDate("targetDate"));
        todo.setDone(rs.getBoolean("isDone"));

        return todo;
    }
}
