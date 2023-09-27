package com.spring.learning.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class TournamentDao {
    public static final String CREATE_TABLE_SQL = "CREATE TABLE TOURNAMENT (ID INTEGER, NAME VARCHAR(50),LOCATION VARCHAR(50), PRIMARY KEY (ID))";
    @Autowired
    private JdbcTemplate template;
    public void createTournamentTable() {
        template.execute(CREATE_TABLE_SQL);
        log.info("TOURNAMENT Table created");
    }

}
