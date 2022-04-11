package com.itsoftware.jee.todo;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TodoDAO {

    Todo getTodo(int id);

    List<Todo> getAllTodos(Pageable pageable);

    int addTodo(Todo todo);

    int updateTodo(Todo todo);

    int deleteTodo(int id);

    int countingPages();
}
