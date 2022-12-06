package com.techelevator.Dao;

import com.techelevator.Models.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcGenreDao implements GenreDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcGenreDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Genre getGenre(int genreId) {
        Genre genre = null;
        String sql = "SELECT * FROM genre WHERE genre_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, genreId);
        if(result.next()){
            genre = mapRowToGenre(result);
        }
        return genre;
    }

    @Override
    public List<Genre> getAllGenres() {
        List<Genre> genres = new ArrayList<>();
        String sql = "SELECT * FROM genre;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            genres.add(mapRowToGenre(results));
        }
        return genres;
    }

    private Genre mapRowToGenre(SqlRowSet rowSet){
        Genre genre = new Genre();
        genre.setGenreId(rowSet.getInt("genre_id"));
        genre.setGenreName(rowSet.getString("genre_name"));
        return genre;
    }
}
