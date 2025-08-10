package org.example.movie2.controller;


import lombok.RequiredArgsConstructor;
import org.example.movie2.dto.Movie2Request;
import org.example.movie2.dto.Movie2Response;
import org.example.movie2.service.Movie2Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Movie2Controller {

    private final Movie2Service movie2Service;

    @PostMapping("/movies2")
    public ResponseEntity<Movie2Response> saveMovie(
            @RequestBody Movie2Request movie2Request
    ) {
        return ResponseEntity.ok(movie2Service.save(movie2Request));
    }
}
