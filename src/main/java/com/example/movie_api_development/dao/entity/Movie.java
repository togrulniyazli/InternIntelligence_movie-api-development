package com.example.movie_api_development.dao.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "movies")
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String director;
    private int releaseYear;
    private String genre;
    @Column(precision = 3,scale = 2)
    private BigDecimal imdbRating;
}
