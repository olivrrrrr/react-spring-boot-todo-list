package com.olivertech.TodoList.todo;

import java.math.BigInteger;
import java.util.Objects;

public class Todo {

    private Integer id;
    private String description;
    private Boolean isComplete;

    public Todo(Integer id, String description, Boolean isComplete) {
        this.id = id;
        this.description = description;
        this.isComplete = isComplete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getComplete() {
        return isComplete;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return Objects.equals(id, todo.id) && Objects.equals(description, todo.description) && Objects.equals(isComplete, todo.isComplete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, isComplete);
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", isComplete=" + isComplete +
                '}';
    }
}
