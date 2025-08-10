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
}
