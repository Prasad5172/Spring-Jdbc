package com.jdbc.testing.movie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.antlr.v4.runtime.misc.IntegerList;
import org.flywaydb.core.internal.jdbc.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.client.RestTemplate;

import com.jdbc.testing.Actor.Actor;
import com.jdbc.testing.Actor.ActorRowMapper;

import lombok.AllArgsConstructor;

public class MovieRowMapper implements org.springframework.jdbc.core.RowMapper<Movie> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    @Nullable
    public Movie mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        int movieId = resultSet.getInt("id");

        return new Movie(
                movieId,
                resultSet.getString("sname"),
                LocalDate.parse(resultSet.getString("release_date")),
                List.of());
    }

    

}
