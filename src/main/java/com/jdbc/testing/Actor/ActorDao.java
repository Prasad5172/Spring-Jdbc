package com.jdbc.testing.Actor;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.jdbc.testing.movie.Movie;

public interface ActorDao {
    List<Actor> allActors();
    int insertActor(Actor actor) ;
    int deleteActor(String name);
    Optional<Actor> selectActorByName(String name);
    List<Actor> findActorsOfMovie(String  movie);
}
