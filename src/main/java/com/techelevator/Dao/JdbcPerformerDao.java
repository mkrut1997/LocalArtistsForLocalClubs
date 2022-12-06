package com.techelevator.Dao;
import com.techelevator.Models.Performer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcPerformerDao implements PerformerDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcPerformerDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Performer getPerformer(int performerId) {
        Performer performer = null;
        String sql = "SELECT * FROM performer WHERE performer_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, performerId);
        if(result.next()){
            performer = mapRowToPerformer(result);
        }
        return performer;
    }

    @Override
    public List<Performer> getAllPerformers() {
        List<Performer> performers = new ArrayList<>();
        String sql = "SELECT * FROM performer;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            performers.add(mapRowToPerformer(results));
        }
        return performers;
    }

    @Override
    public List<Performer> getPerformersByGenre(int genreId) {
        List<Performer> performers = new ArrayList<>();
        String sql = "SELECT performer.performer_id, type_id, performer_name, email, phone_number, eq_id, soundcloud_url FROM performer " +
                    "JOIN performer_genre ON performer_genre.performer_id = performer.performer_id " +
                    "WHERE genre_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, genreId);
        while(results.next()){
            performers.add(mapRowToPerformer(results));
        }
        return performers;
    }

    @Override
    public Performer createPerformer(Performer performer) {
        String sql = "INSERT INTO performer (type_id, performer_name, email, phone_number, eq_id, soundcloud_url " +
                    "VALUES (?, ?, ?, ?, ?, ?) RETURNING performer_id;";
        int newPerformerId = jdbcTemplate.queryForObject(sql, int.class, performer.getType_id(), performer.getPerformerName(), performer.getEmail(), performer.getPhoneNumber(), performer.getEqId(), performer.getSoundcloudUrl());
        return getPerformer(newPerformerId);
    }

    @Override
    public void addGenreToPerformer(int performerId, int genreId) {
        String sql = "INSERT INTO performer_genre (performer_id, genre_id) " +
                    "VALUES (?, ?);";
        jdbcTemplate.update(sql, performerId, genreId);
    }

    @Override
    public void removeGenreFromPerformer(int performerId, int genreId) {

    }

    @Override
    public Performer getPerformerByEmail(String email) {
        Performer performer = null;
        String sql = "SELECT * FROM performer WHERE email = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, email);
        if(result.next()){
            performer = mapRowToPerformer(result);
        }
        return performer;
    }

    @Override
    public void updatePerformer(Performer performer) {
        String sql = "UPDATE performer SET phone_number = ?, eq_id = ?, soundcloud_url = ? " +
                    "WHERE performer_id = ?;";
        jdbcTemplate.update(sql, performer.getPhoneNumber(), performer.getEqId(), performer.getSoundcloudUrl(), performer.getPerformerId());
    }

    private Performer mapRowToPerformer(SqlRowSet rowSet) {
        Performer performer = new Performer();
        performer.setPerformerId(rowSet.getInt("performer_id"));
        performer.setPerformerName(rowSet.getString("performer_name"));
        performer.setType_id(rowSet.getInt("type_id"));
        performer.setEmail(rowSet.getString("email"));
        if (rowSet.getString("phone_number") != null) {
            performer.setPhoneNumber(rowSet.getString("phone_number"));
        }
        performer.setEqId(rowSet.getInt("eq_id"));
        performer.setSoundcloudUrl(rowSet.getString("soundcloud_url"));
        return performer;
    }


}
