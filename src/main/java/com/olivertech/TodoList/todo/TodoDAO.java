package com.olivertech.TodoList.todo;

import java.util.List;
import java.util.Optional;

public interface TodoDAO {

  List<Todo> getTodos();

    Optional<Todo> getSpecificTodo(Integer id);

    int addTodo(Todo todo);

    void updateTodo(Integer id, Todo todo);

    void deleteTodo(Integer id);


}
