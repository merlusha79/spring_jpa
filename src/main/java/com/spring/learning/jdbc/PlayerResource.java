package com.spring.learning.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerResource {

    public static final String WELCOME_STRING = "Tennis Player REST API";
    @Autowired
    PlayerService service;

    @GetMapping("/welcome")
    public String welcome() {
        return WELCOME_STRING;
    }

    @GetMapping("/players")
    public List<Player> allPlayers() {
        return service.getAllPlayers();
    }
    @GetMapping("/players/{id}")
    public Player getPlayer(@PathVariable int id){
        return service.getPlayer(id);
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player) {
        player.setId(0);
        return service.addPlayer(player);
    }
    @PutMapping("/players/{id}")
    public Player updatePlayer(@PathVariable int id, @RequestBody Player player) {
        return service.updatePlayer(id, player);
    }
    @PatchMapping("/players/{id}")
    public Player partialUpdate(@PathVariable int id, @RequestBody Map<String, Object> playerPatch) {
        return service.patch(id, playerPatch);
    }
    @PatchMapping("/players/{id}/titles")
    public void updateTitles(@PathVariable int id, @RequestBody int titles) {
        service.updateTitles(id, titles);
    }

    @DeleteMapping("/players/{id}")
    public void deletePlayer(@PathVariable int id) {
        service.deletePlayer(id);
    }
}