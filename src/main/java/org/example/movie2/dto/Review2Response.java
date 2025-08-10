package org.example.movie2.dto;

import lombok.Getter;

@Getter
public class Review2Response {

    private final Long id;
    private final String content;

    public Review2Response(Long id, String content) {
        this.id = id;
        this.content = content;
    }
}
