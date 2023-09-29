package com.spring.learning.jdbc;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.util.ReflectionUtils.makeAccessible;
import static org.springframework.util.ReflectionUtils.setField;

@Service
@Slf4j
public class PlayerService {

    @Autowired
    private PlayerRepository repo;

    //Get all players
    public List<Player> getAllPlayers() {
        return repo.findAll();
    }

    //Get player by ID
    public Player getPlayer(int id) {
        return getPlayerById(id);
    }

    public Player addPlayer(Player p) {
        return repo.save(p);
    }

    public Player updatePlayer(int id, Player p) {
        getPlayerById(id);
        p.setId(id);
        return repo.save(p);
    }

    //Partial update
    public Player patch(int id, Map<String, Object> partialPlayer) {
        Player player = getPlayerById(id);

        partialPlayer.forEach((key, value) -> {
            log.info("Key: " + key + " Value: " + value);
            Field field = ReflectionUtils.findField(Player.class, key);
            if (Objects.nonNull(field)) {
                makeAccessible(field);
                setField(field, player, value);
            }
        });

        return repo.save(player);
    }

    @Transactional
    public void updateTitles(int id, int titles) {
        getPlayerById(id);
        repo.updateTitles(id, titles);
    }

    public void deletePlayer(int id) {
        repo.delete(getPlayerById(id));
    }

    private Player getPlayerById(int id) {
        Optional<Player> tempPlayer = repo.findById(id);

        if (tempPlayer.isEmpty()) {
            throw new PlayerNotFoundException("Player with id {" + id + "} not found");
        }
        return tempPlayer.get();
    }
}