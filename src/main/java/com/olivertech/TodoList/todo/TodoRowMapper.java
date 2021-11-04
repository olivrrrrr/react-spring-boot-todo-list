package com.olivertech.TodoList.todo;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TodoRowMapper implements RowMapper<Todo>{
    @Override
    public Todo mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Todo(
                    resultSet.getInt("id"),
                    resultSet.getString("description"),
                    resultSet.getBoolean("iscomplete")
            );
    }
}
