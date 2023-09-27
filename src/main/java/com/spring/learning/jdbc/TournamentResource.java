package com.spring.learning.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TournamentResource {

    @Autowired
    private TournamentService service;


    @PostMapping(path = "/tournament/init")
    public void init(Player player) {
        service.init();
    }
}
