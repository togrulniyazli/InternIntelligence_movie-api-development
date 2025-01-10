package com.example.movie_api_development.model.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class MovieRequest {
    private String title;
    private String director;
    @Positive(message = "Release year must be positive")
    private int releaseYear;
    private String genre;
    @NotNull(message = "IMDb rating cannot be null")
    @Positive(message = "IMDb rating must be positive")
    private Double imdbRating;
}
