package com.olivertech.TodoList.todo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/todolist")
public class TodoController{

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getTodos(){
        return todoService.getTodos();
    }

    @GetMapping("{id}")
    public Optional<Todo> getSpecificTodo(@PathVariable("id") Integer id){
        return todoService.getSpecificTodo(id);
    }

    @PostMapping
    public void addTodo(@RequestBody Todo todo){
        todoService.addTodo(todo);
    }

    @PutMapping("{id}")
    public void updateTodo(@PathVariable("id") Integer id, @RequestBody Todo todo){
        todoService.updateTodo(id, todo);
    }

    @DeleteMapping("{id}")
    public void deleteTodo(@PathVariable("id") Integer id){
        todoService.deleteTodo(id);
    }

}
