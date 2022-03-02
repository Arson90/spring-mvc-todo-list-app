package com.itsoftware.jee.todo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TodoMapper implements RowMapper<Todo> {
    @Override
    public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Todo todo = new Todo();
        todo.setId(rs.getInt("id"));
        todo.setUserName(rs.getString("user_name"));
        todo.setDescription(rs.getString("description"));
        todo.setTargetDate(rs.getDate("target_date"));
        todo.setDone(rs.getBoolean("is_done"));

        return todo;
    }
}
