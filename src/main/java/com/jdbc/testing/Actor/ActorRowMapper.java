package com.jdbc.testing.Actor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

public class ActorRowMapper implements RowMapper<Actor> {

    @Override
    @Nullable
    public Actor mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Actor(resultSet.getString("ANAME"));
    }
    
}
