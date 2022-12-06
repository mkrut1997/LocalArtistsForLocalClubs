package com.techelevator.Dao;

import com.techelevator.Models.Performer;

import java.util.List;

public interface PerformerDao {

    Performer getPerformer (int performerId);
    List<Performer> getAllPerformers();
    List<Performer> getPerformersByGenre(int genreId);
    Performer createPerformer(Performer performer);
    void addGenreToPerformer(int performerId, int genreId);
    void removeGenreFromPerformer(int performerId, int genreId);
    Performer getPerformerByEmail(String email);
    void updatePerformer(Performer performer);

}
