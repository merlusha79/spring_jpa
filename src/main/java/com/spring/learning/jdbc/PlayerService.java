package com.spring.learning.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    public List<Player> getAllPlayers() {
        return repository.getAll();
    }

    public void addPlayer(Player player) {
        repository.insert(player);
    }

    public void updatePlayer(Player player) {
        repository.update(player);
    }

    public Player getPlayer(int id) {
         return  repository.findById(id);

    }

    public void deletePlayer(int playerId) {
        repository.delete(playerId);
    }

}
