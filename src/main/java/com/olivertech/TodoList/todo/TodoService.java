package com.olivertech.TodoList.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private TodoDAO todoDAO;

    @Autowired
    public TodoService(@Qualifier("postgres") TodoDAO todoDAO) {
        this.todoDAO = todoDAO;
    }

    public List<Todo> getTodos() {
        return todoDAO.getTodos();
    }

    public Optional<Todo> getSpecificTodo(Integer id) {
        return todoDAO.getSpecificTodo(id);
    }

    public void addTodo(Todo todo) {
        todoDAO.addTodo(todo);
    }

    public void deleteTodo(Integer id) {
        todoDAO.deleteTodo(id);
    }

    public void updateTodo(Integer id, Todo todo) {
        todoDAO.updateTodo(id, todo);
    }
}
