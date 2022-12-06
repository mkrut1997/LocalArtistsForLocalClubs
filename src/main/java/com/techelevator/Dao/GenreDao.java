package com.techelevator.Dao;

import com.techelevator.Models.Genre;

import java.util.List;

public interface GenreDao {

    Genre getGenre(int genreId);
    List<Genre> getAllGenres();

}
