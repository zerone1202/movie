package org.example.movie2.controller;

import lombok.RequiredArgsConstructor;
import org.example.movie.dto.ReviewResponse;
import org.example.movie2.dto.Review2Request;
import org.example.movie2.dto.Review2Response;
import org.example.movie2.service.Review2Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/movies2/{movieId}/reviews")
    public ResponseEntity<List<Review2Response>> getAllReviews(
            @PathVariable Long movieId
    ) {
        return ResponseEntity.ok(review2Service.findAll(movieId));
    }

    @GetMapping("/movies2/{movieId}/reviews/{reviewId}")
    public ResponseEntity<Review2Response> getOneReview(
            @PathVariable Long reviewId
    ) {
        return ResponseEntity.ok(review2Service.findreviews(reviewId));
    }
}
