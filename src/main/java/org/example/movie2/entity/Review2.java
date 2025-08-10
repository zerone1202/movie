package org.example.movie2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Review2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie id", nullable = false)
    private Movie2 movie2;

    public Review2(String content, Movie2 movie2) {
        this.content = content;
        this.movie2 = movie2;
    }
}
