package com.spring.learning.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerResource {

    @Autowired
    private PlayerServiceJpa playerService;

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerService.getAll();

    }

    @GetMapping(path = "/players/{id}")
    public Player getPlayer(@PathVariable("id") int id) {
        return playerService.findById(id);

    }

    @DeleteMapping(path = "/players/{id}")
    public void deletePlayer(@PathVariable("id") int id) {
        playerService.delete(id);

    }

    @PostMapping(path = "/players")
    public void addPlayer(Player player) {
        playerService.insert(player);

    }

    @PutMapping(path = "/players/{id}")
    public void updatePlayer(@PathVariable("id") int id, @RequestBody Player player) {
        playerService.update(player);

    }
}
