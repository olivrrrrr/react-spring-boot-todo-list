package com.olivertech.TodoList.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatasourceConfig {

        @Bean
        @Primary
        @ConfigurationProperties(prefix = "app.datasource.main")
        public HikariDataSource hikariDataSource() {
            return DataSourceBuilder
                    .create()
                    .type(HikariDataSource.class)
                    .build();

    }

}
