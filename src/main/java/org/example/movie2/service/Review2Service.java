package org.example.movie2.service;

import lombok.RequiredArgsConstructor;
import org.example.movie2.dto.Review2Request;
import org.example.movie2.dto.Review2Response;
import org.example.movie2.entity.Movie2;
import org.example.movie2.entity.Review2;
import org.example.movie2.repository.Movie2Repository;
import org.example.movie2.repository.Review2Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Review2Service {

    private final Review2Repository review2Repository;
    private final Movie2Repository movie2Repository;

    // 리뷰 생성
    @Transactional
    public Review2Response save(Review2Request request, Long movieId) {
        Movie2 movie2 = movie2Repository.findById(movieId).orElseThrow(
                () -> new IllegalArgumentException("그런 movieId의 movie는 찾을 수 없습니다.")
        );
        Review2 review2 = new Review2(
                request.getContent(),
                movie2
        );
        Review2 savedReview = review2Repository.save(review2);
        return new Review2Response(
                savedReview.getId(),
                savedReview.getContent()
        );
    }

    // 리뷰 조회 (전체 리뷰 조회)
    @Transactional(readOnly = true)
    public List<Review2Response> findAll(Long movieId) {
        Movie2 movie2 = movie2Repository.findById(movieId).orElseThrow(
                () -> new IllegalArgumentException("그런 movieId의 movie는 찾을 수 없습니다.")
        );

        List<Review2> movies = review2Repository.findAllByMovie2(movie2);
        List<Review2Response> dtos = new ArrayList<>();

        for (Review2 review2 : movies) {
            dtos.add(
                    new Review2Response(
                            review2.getId(),
                            review2.getContent()
                    )
            );
        }
        return dtos;
    }

    // 리뷰 조회 (선택 리뷰 조회)
    @Transactional(readOnly = true)
    public Review2Response findreviews(Long reviewId) {
        Review2 review2 = review2Repository.findById(reviewId).orElseThrow(
                () -> new IllegalArgumentException("그런 reviewId의 review는 찾을 수 없습니다.")
        );
        return new Review2Response(
                review2.getId(),
                review2.getContent()
        );
    }

    // 리뷰 수정
    @Transactional
    public Review2Response updatereview(Long reviewId, Review2Request request) {
        Review2 review2 = review2Repository.findById(reviewId).orElseThrow(
                () -> new IllegalArgumentException("그런 reviewId의 review는 찾을 수 없습니다.")
        );
        review2.updateReview(request.getContent());
        return new Review2Response(
                review2.getId(),
                review2.getContent()
        );
    }
}
