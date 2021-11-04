package com.olivertech.TodoList.todo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository("postgres")
public class TodoDataAccessService implements TodoDAO {

    private final JdbcTemplate jdbcTemplate;

    public TodoDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Todo> getTodos() {
        String sql = """
                SELECT id, description, iscomplete 
                FROM todo;
                """;

        return jdbcTemplate.query(sql, new TodoRowMapper());
    }

    @Override
    public Optional<Todo> getSpecificTodo(Integer id){
        String sql = """
                SELECT id, description, iscomplete 
                FROM todo
                WHERE todo.id = ?;
                """;

       return jdbcTemplate.query(sql, new TodoRowMapper(),id)
               .stream()
               .findFirst();
    }

    @Override
    public int addTodo(Todo todo) {
        String sql = """
                      INSERT INTO todo(description, iscomplete) 
                      VALUES (?, ?);
                    """;

        return jdbcTemplate.update(sql,
                                    todo.getDescription(),
                                    todo.getComplete());
    }

    @Override
    public void updateTodo(Integer id, Todo todo){
        String sql = """
                       UPDATE todo
                       SET description = ?, iscomplete = ?
                       WHERE todo.id = ?;     
                    """;

        jdbcTemplate.update(sql, todo.getDescription(), todo.getComplete(), id);

    }

    @Override
    public void deleteTodo(Integer id){
        String sql = """
                      DELETE FROM todo
                       WHERE todo.id = ?;
                    """;
        jdbcTemplate.update(sql, id);
    }
}
