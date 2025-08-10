package org.example.movie2.service;

import lombok.RequiredArgsConstructor;
import org.example.movie2.dto.Movie2Request;
import org.example.movie2.dto.Movie2Response;
import org.example.movie2.entity.Movie2;
import org.example.movie2.repository.Movie2Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Movie2Service {

    private final Movie2Repository movie2Repository;

    // 영화 생성
    @Transactional
    public Movie2Response save(Movie2Request movie2Request) {
        Movie2 movie2 = new Movie2(movie2Request.getTitle());
        Movie2 savedMovie2 = movie2Repository.save(movie2);
        return new Movie2Response(
                savedMovie2.getId(),
                savedMovie2.getTitle()
        );
    }

    // 영화 전체 조회
    @Transactional(readOnly = true)
    public List<Movie2Response> findAll() {
        List<Movie2> movies2 = movie2Repository.findAll();
        return movies2.stream()
                .map(movie2 -> new Movie2Response(
                        movie2.getId(),
                        movie2.getTitle()
                )).toList();
    }
}
