package com.jdbc.testing.movie;

import java.time.LocalDate;
import java.util.List;

import com.jdbc.testing.Actor.Actor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie{
     private Integer id;
    private String sname;
    private LocalDate releaseDate;
    private List<Actor> actors;

}
