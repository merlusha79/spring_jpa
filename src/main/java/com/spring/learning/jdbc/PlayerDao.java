package com.spring.learning.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public class PlayerDao {

    public static final String SELECT_FROM_PLAYER = "Select * from Player";
    public static final String INSERT_INTO_PLAYER = "INSERT INTO PLAYER (ID, Name, Nationality,Birth_date, Titles) " +
            "VALUES (?, ?, ?, ?, ?)";
    public static final String UPDATE_PLAYER = "UPDATE PLAYER " +
            "SET Name = ?, Nationality = ?, Birth_date = ? , Titles = ? " +
            "WHERE ID = ?";
    public static final String DELETE_FROM_PLAYER = "DELETE FROM PLAYER WHERE ID = ?";

    public static final String FIND_PLAYER_BY_ID = "Select * FROM PLAYER WHERE ID = ?";
    public static final String SELECT_BY_NATIONALITY = "SELECT * FROM PLAYER WHERE NATIONALITY = ?";
    @Autowired
    private JdbcTemplate template;

    public List<Player> getAllPlayers() {
        return template.query(SELECT_FROM_PLAYER, new BeanPropertyRowMapper<>(Player.class));
    }

    public Optional<Player> findById(int playerId) {
        List<Player> players = template.query(FIND_PLAYER_BY_ID, new BeanPropertyRowMapper<>(Player.class), playerId);
        return players.stream().findFirst();
    }

    public int insert(Player player) {
        return template.update(INSERT_INTO_PLAYER, player.getId(), player.getName(), player.getNationality(), new Timestamp(player.getBirthDate().getTime()), player.getTitles());
    }

    public int update(Player player) {
        return template.update(UPDATE_PLAYER, player.getName(), player.getNationality(), new Timestamp(player.getBirthDate().getTime()), player.getTitles(), player.getId());
    }

    public int deleteById(int id) {
        return template.update(DELETE_FROM_PLAYER, id);
    }


    public List<Player> getPlayerByNationality(String nationality) {
        return template.query(SELECT_BY_NATIONALITY, PLAYER_ROW_MAPPER, nationality);
    }

    private static final RowMapper<Player> PLAYER_ROW_MAPPER = (ResultSet resultSet, int rowNum) -> {
        Player player = new Player();
        player.setId(resultSet.getInt("id"));
        player.setName(resultSet.getString("name"));
        player.setNationality(resultSet.getString("nationality"));
        player.setBirthDate(resultSet.getDate("birth_date"));
        player.setTitles(resultSet.getInt("titles"));
        return player;
    };

}
