package com.spring.learning.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerDao dao;

    public List<Player> getAllPlayers() {
        return dao.getAllPlayers();
    }

    public void addPlayer(Player player) {
        dao.insert(player);
    }

    public void updatePlayer(Player player) {
        dao.update(player);
    }

    public Player getPlayer(int id) {
         return   dao.findById(id).orElseThrow(() -> new IllegalArgumentException("No Value Present"));

    }

    public void deletePlayer(int playerId) {
        dao.deleteById(playerId);
    }

}
