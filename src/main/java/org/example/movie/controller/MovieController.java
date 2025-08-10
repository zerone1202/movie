package org.example.movie.controller;

import lombok.RequiredArgsConstructor;
import org.example.movie.dto.MovieRequest;
import org.example.movie.dto.MovieResponse;
import org.example.movie.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/movies")
    public ResponseEntity<MovieResponse> saveMovie(
            @RequestBody MovieRequest request
    ) {
        return ResponseEntity.ok(movieService.save(request));
    }

    @GetMapping("/movies")
    public ResponseEntity<List<MovieResponse>> getAllMovies() {
        return ResponseEntity.ok(movieService.findAll());
    }

    @GetMapping("/movies/{movieId}")
    public ResponseEntity<MovieResponse> getOneMovie(
            @PathVariable Long movieId
    ) {
        return ResponseEntity.ok(movieService.findMovies(movieId));
    }

    @PutMapping("/movies/{movieId}")
    public ResponseEntity<MovieResponse> updateMovie(
            @PathVariable Long movieId,
            @RequestBody MovieRequest request
    ) {
        return ResponseEntity.ok(movieService.updateMovie(movieId, request));
    }
}
