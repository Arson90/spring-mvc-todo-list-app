package com.itsoftware.jee.todo;

import java.util.List;

public interface TodoDAO {

    Todo getTodo(int id);

    List<Todo> getAllTodos();

    int addTodo(Todo todo);

    int updateTodo(Todo todo);

    int deleteTodo(int id);
}
