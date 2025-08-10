package org.example.movie2.controller;

import lombok.RequiredArgsConstructor;
import org.example.movie2.dto.Review2Request;
import org.example.movie2.dto.Review2Response;
import org.example.movie2.service.Review2Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Review2Controller {

    private final Review2Service review2Service;

    @PostMapping("/movies2/{movieId}/reviews")
    public ResponseEntity<Review2Response> saveReviews(
            @RequestBody Review2Request request,
            @PathVariable Long movieId
    ) {
        return ResponseEntity.ok(review2Service.save(request,movieId));
    }
}
