package org.example.movie2.dto;

import lombok.Getter;
import org.example.movie2.entity.Movie2;

@Getter
public class Movie2Response {

    private final Long id;
    private final String title;

    public Movie2Response(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
