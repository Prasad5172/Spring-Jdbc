package com.jdbc.testing.Actor;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdbc.testing.movie.Movie;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/actors")
@AllArgsConstructor
public class ActorController {

    private final ActorService actorService;

    @GetMapping
    public List<Actor> listActors() {
        return actorService.getActors();
    }

    @GetMapping("{name}")
    public Optional<Actor> getActor(@PathVariable("name") String name) {
        return actorService.getActor(name);
    }

    @PostMapping
    public void addActor(@RequestBody Actor movie) {
        actorService.addActor(movie);
    }

    @DeleteMapping("{name}")
    public void deleteActor( @PathVariable("name") String name) {
        actorService.deleteActor(name);
    }

    @GetMapping("movie/{name}")
    public List<Actor> actorsOfMovie(@PathVariable("name") String name){
        return actorService.actorsOfMovie(name);
    }
    

}