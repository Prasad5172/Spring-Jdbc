package com.jdbc.testing.movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.antlr.v4.runtime.misc.IntegerList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jdbc.testing.Actor.Actor;
import com.jdbc.testing.Actor.ActorRowMapper;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class MovieDataAccessService implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Movie> selectMovies() {
        String sql = """
                SELECT ID ,SNAME ,RELEASE_DATE FROM MOVIE LIMIT 100;
                """;
        List<Movie> movies = jdbcTemplate.query(sql, new MovieRowMapper());
        for(Movie movie : movies){
            movie.setActors(getActors(movie.getSname()));
        }
        return movies;
    }

    @Override
    public int insertMovie(Movie movie) {
        String sql = """
                INSERT INTO MOVIE(SNAME,RELEASE_DATE) VALUES (? , ?);
                """;
        return jdbcTemplate.update(sql, movie.getSname(), movie.getReleaseDate());
    }

    @Override
    public int deleteMovie(int id) {
        String sql = """
                DELETE FROM MOVIE WHERE ID = ?
                """;
        return jdbcTemplate.update(sql, id);

    }

    @Override
    public Optional<Movie> selectMovieByName(String movieName) {
        String sql = """
                SELECT ID , SNAME , RELEASE_DATE FROM MOVIE WHERE SNAME = ?
                """;

        List<Movie> optionalMovie = jdbcTemplate.query(sql,new MovieRowMapper(),movieName);
        if(!optionalMovie.isEmpty()){
            optionalMovie.get(0).setActors(getActors(movieName)); 
        }

        return optionalMovie.stream().findFirst();
    }

    private List<Actor> getActors(String movieName) {
        return jdbcTemplate.query(
            """
                SELECT  A.ID , A.ANAME FROM MOVIE M 
            JOIN MOVIE_STORE MS ON MS.MOVIE_ID = M.ID AND M.SNAME = ?
             JOIN ACTOR A  WHERE A.ID = MS.ACTOR_ID ; 
            """,
            new ActorRowMapper(),
            movieName
            );
    }

    @Override
    public int insertActorsToMovie( MovieRequest movieRequest) {
        System.out.println(movieRequest.getSname());
        Optional<Movie> optionalMovie = selectMovieByName(movieRequest.getSname());
        Movie movie = optionalMovie.get();
        if(!optionalMovie.isPresent()){
            String sql = """
                INSERT INTO MOVIE(SNAME) VALUES (?);
                """;
            jdbcTemplate.update(sql, movie.getSname());
        }

         String sql = """
                INSERT INTO ACTOR(ANAME) VALUES (? );
                """;
        return 1;
    }

}