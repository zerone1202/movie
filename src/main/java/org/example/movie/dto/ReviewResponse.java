package org.example.movie.dto;

import lombok.Getter;

@Getter
public class ReviewResponse {

    private final Long id;
    private final String content;

    public ReviewResponse(Long id, String content) {
        this.id = id;
        this.content = content;
    }
}
