package com.spring.learning.jdbc;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
@NamedQuery(name = "get_all_players", query = "select p from Player p")
public class PlayerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Player player) {
        entityManager.merge(player);
    }

    public void update(Player player) {
        entityManager.merge(player);
    }

    public Player findById(int id) {
        return entityManager.find(Player.class, id);
    }

    public void delete(int id) {
        entityManager.remove(findById(id));
    }

    public List<Player> getAll() {
        TypedQuery<Player> getAll = entityManager.createNamedQuery("get_all_players", Player.class);
        return getAll.getResultList();
    }
}
