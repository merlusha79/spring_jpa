package com.spring.learning.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceJpa {
    @Autowired
    private PlayerSpringDataRepository repo;


    public void insert(Player player) {
        repo.save(player);
    }

    public void update(Player player) {
        repo.save(player);
    }

    public Player findById(int id) {
        return repo.findById(id).orElseThrow();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public List<Player> getAll() {
       return repo.findAll();
    }


}
