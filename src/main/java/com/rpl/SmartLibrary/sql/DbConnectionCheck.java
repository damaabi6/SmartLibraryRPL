package com.rpl.SmartLibrary.sql;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DbConnectionCheck implements CommandLineRunner {
    private final JdbcTemplate jdbc;

    public DbConnectionCheck(JdbcTemplate jdbc) { this.jdbc = jdbc; }

    @Override
    public void run(String... args) {
        Integer result = jdbc.queryForObject("SELECT 1", Integer.class);
        System.out.println("DB connection OK: " + result);
    }
}
