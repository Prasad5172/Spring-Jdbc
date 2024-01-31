package com.jdbc.testing.movie;

import java.util.List;
import java.util.Optional;


public interface MovieDao {
    List<Movie> selectMovies();
    int insertMovie(Movie movie);
    int insertActorsToMovie(MovieRequest movieRequest);
    int deleteMovie(int id);
    Optional<Movie> selectMovieByName(String movieName);
    // TODO: Update
}