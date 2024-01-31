package com.jdbc.testing.Actor;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jdbc.testing.movie.Movie;
import com.jdbc.testing.movie.MovieDao;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class ActorDataAcessService implements ActorDao {
    
    private final JdbcTemplate jdbcTemplate;
    private final MovieDao movieDao;

    @Override
    public List<Actor> allActors() {
        String sql = """
                SELECT  ANAME FROM ACTOR LIMIT 100;
                """;
        return jdbcTemplate.query(sql, new ActorRowMapper());
    }

    @Override
    public  int  insertActor(Actor actor)  {
        String sql = """
                INSERT INTO ACTOR(ANAME) VALUES (? );
                """;
        return jdbcTemplate.update(sql, actor.aname());
    }

    @Override
    public int deleteActor(String name) {
        String sql = """
                DELETE FROM ACTOR WHERE  ANAME = ? 
                """;

        return jdbcTemplate.update(sql, name);
    }

    @Override
    public Optional<Actor> selectActorByName(String  name) {
        String sql = """
                SELECT ID , ANAME FROM ACTOR WHERE ANAME = ?
                """;
        return jdbcTemplate.query(sql, new ActorRowMapper(),name).stream().findFirst();
    }

    @Override
    public List<Actor> findActorsOfMovie(String name) {
        String sql = """
                SELECT A.ANAME  FROM  MOVIE M 
                    JOIN MOVIE_STORE MS ON MS.MOVIE_ID = M.ID AND M.SNAME = ?  
                    JOIN ACTOR A ON A.ID  =  MS.ACTOR_ID
                """;
        return jdbcTemplate.query(sql, new ActorRowMapper(),name);
    }

   


}
