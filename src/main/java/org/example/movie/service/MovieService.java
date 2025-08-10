package org.example.movie.service;

import lombok.RequiredArgsConstructor;
import org.example.movie.dto.MovieRequest;
import org.example.movie.dto.MovieResponse;
import org.example.movie.entity.Movie;
import org.example.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    // 영화 생성
    @Transactional
    public MovieResponse save(MovieRequest request) {
        Movie movie = new Movie(request.getTitle());
        Movie savedMovie = movieRepository.save(movie);
        return new MovieResponse(
                savedMovie.getId(),
                savedMovie.getTitle()
        );
    }

    // 영화 조회 (전체 영화 조회)
    @Transactional(readOnly = true)
    public List<MovieResponse> findAll() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream()
                .map(movie -> new MovieResponse(
                        movie.getId(),
                        movie.getTitle()
                )).toList();
    }

    // 영화 조회 (선택 영화 조회)
    @Transactional(readOnly = true)
    public MovieResponse findMovies(Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new IllegalArgumentException("그런 movieId의 movie는 찾을 수 없습니다.")
        );
        return new MovieResponse(
                movie.getId(),
                movie.getTitle()
        );
    }

    // 수정
    @Transactional
    public MovieResponse updateMovie(Long movieId, MovieRequest request) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new IllegalArgumentException("그런 movieId의 movie는 찾을 수 없습니다.")
        );
        movie.updateMovie(request.getTitle());
        return new MovieResponse(
                movie.getId(),
                movie.getTitle()
        );
    }
}
