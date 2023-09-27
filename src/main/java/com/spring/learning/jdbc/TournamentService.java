package com.spring.learning.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TournamentService {
    @Autowired
    private TournamentDao dao;

    public void init(){
        dao.createTournamentTable();;
    }
}
