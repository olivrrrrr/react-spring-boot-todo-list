package com.olivertech.TodoList.todo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fake")
public class FakeTodoDataAccessService implements TodoDAO{

    List<Todo> db = new ArrayList<>();

    public FakeTodoDataAccessService() {
        db.add(new Todo(1, "buy eggs", false));
        db.add(new Todo(2, "Hoover room", false));
    }

    @Override
    public List<Todo> getTodos() {
        return db;
    }

    @Override
    public Optional<Todo> getSpecificTodo(Integer id){
        return db.stream().filter(t -> t.getId() == id).findAny();
    }

    @Override
    public int addTodo(Todo todo) {
        db.add(todo);
        return 0;
    }

    @Override
   public void updateTodo(Integer id, Todo todo){
        throw new UnsupportedOperationException("not implemented");
    }

    @Override
    public void deleteTodo(Integer id){
        throw new UnsupportedOperationException("not implemented");
    }

}
