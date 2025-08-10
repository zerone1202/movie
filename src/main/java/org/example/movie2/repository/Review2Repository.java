package org.example.movie2.repository;

import org.example.movie2.entity.Movie2;
import org.example.movie2.entity.Review2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Review2Repository extends JpaRepository<Review2, Long> {
    List<Review2> findAllByMovie2(Movie2 movie2);
}
