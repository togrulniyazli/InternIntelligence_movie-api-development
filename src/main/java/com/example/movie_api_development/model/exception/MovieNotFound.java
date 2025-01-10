package com.example.movie_api_development.model.exception;

public class MovieNotFound extends RuntimeException{
    public MovieNotFound(String message) {
        super(message);
    }
}
