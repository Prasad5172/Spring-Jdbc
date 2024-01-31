package com.jdbc.testing.movie;

import java.util.List;
import java.util.Optional;

import com.jdbc.testing.Actor.Actor;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieDao movieDao;

    public MovieService(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    public List<Movie> getMovies() {
        return movieDao.selectMovies();
    }

    public void addNewMovie(Movie movie) {
        // TODO: check if movie exists
        int result = movieDao.insertMovie(movie);
        if (result != 1) {
            throw new IllegalStateException("oops something went wrong");
        }
    }

    public void deleteMovie(Integer id) {
        try {
            movieDao.deleteMovie(id);
            
        } catch (Exception e) {
            throw new NotFoundException(e.getMessage());
        }
    }

    public Optional<Movie> getMovie(String movieName) {
        return movieDao.selectMovieByName(movieName);
    }

    public void addActorsToMovie( MovieRequest movieRequest) {
        movieDao.insertActorsToMovie(movieRequest);
    }

    

   
}