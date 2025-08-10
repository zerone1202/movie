package org.example.movie2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
public class Movie2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    public Movie2(String title) {
        this.title = title;
    }
}
