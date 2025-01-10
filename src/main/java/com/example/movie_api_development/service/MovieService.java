package com.example.movie_api_development.service;

import com.example.movie_api_development.dao.entity.Movie;
import com.example.movie_api_development.model.dto.request.MovieRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MovieService {
    Movie getById(Long id);
    Page<Movie> getAll(Pageable pageable);
    void update(Long id,MovieRequest movieRequest);
    void delete(Long id);
    List<Movie> add(List<MovieRequest> movieRequest);
}
