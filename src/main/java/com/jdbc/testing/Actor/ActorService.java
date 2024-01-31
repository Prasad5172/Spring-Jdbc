package com.jdbc.testing.Actor;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jdbc.testing.movie.Movie;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ActorService {
    
    private final ActorDao actorDao;

    public List<Actor> getActors() {
        return actorDao.allActors();
    }

    public Optional<Actor> getActor(String actor) {
        return actorDao.selectActorByName(actor);
    }

    public void addActor(Actor Actor) {
        int result = actorDao.insertActor(Actor);
        if(result != 1){
            throw new IllegalStateException("oops something went worng");
        }
    }

    public void deleteActor(String  actor) {
        actorDao.deleteActor(actor);
    }

    public List<Actor> actorsOfMovie(String  movie) {
        return actorDao.findActorsOfMovie(movie);
    }

    
    
}
