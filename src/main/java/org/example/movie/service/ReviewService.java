package org.example.movie.service;

import lombok.RequiredArgsConstructor;
import org.example.movie.dto.ReviewRequest;
import org.example.movie.dto.ReviewResponse;
import org.example.movie.entity.Movie;
import org.example.movie.entity.Review;
import org.example.movie.repository.MovieRepository;
import org.example.movie.repository.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;

    // 리뷰 생성
    @Transactional
    public ReviewResponse save(ReviewRequest request, Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new IllegalArgumentException("그런 movieId의 movie는 찾을 수 없습니다.")
        );
        Review review = new Review(
                request.getContent(),
                movie
        );
        Review savedReview = reviewRepository.save(review);
        return new ReviewResponse(
                savedReview.getId(),
                savedReview.getContent()
        );
    }

    // 리뷰 조회 (전체 리뷰 조회)
    @Transactional(readOnly = true)
    public List<ReviewResponse> findAll(Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new IllegalArgumentException("그런 movieId의 movie는 찾을 수 없습니다.")
        );

        List<Review> movies = reviewRepository.findAllByMovie(movie);
        List<ReviewResponse> dtos = new ArrayList<>();

        for (Review review : movies) {
            dtos.add(
                    new ReviewResponse(
                    review.getId(),
                    review.getContent()
                    )
            );
        }
        return dtos;
    }

    // 리뷰 조회 (선택 리뷰 조회)
    @Transactional(readOnly = true)
    public ReviewResponse findreviews(Long reviewId) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(
                () -> new IllegalArgumentException("그런 reviewId의 review는 찾을 수 없습니다.")
        );
        return new ReviewResponse(
                review.getId(),
                review.getContent()
        );
    }

    // 리뷰 수정
    @Transactional
    public ReviewResponse updatereview(Long reviewId, ReviewRequest request) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(
                () -> new IllegalArgumentException("그런 reviewId의 review는 찾을 수 없습니다.")
        );
        review.updateReview(request.getContent());
        return new ReviewResponse(
                review.getId(),
                review.getContent()
        );
    }
}
