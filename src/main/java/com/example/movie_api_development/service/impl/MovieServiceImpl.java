package com.example.movie_api_development.service.impl;

import com.example.movie_api_development.dao.entity.Movie;
import com.example.movie_api_development.dao.repository.MovieRepository;
import com.example.movie_api_development.mapper.MovieMapper;
import com.example.movie_api_development.model.dto.request.MovieRequest;
import com.example.movie_api_development.model.exception.MovieNotFound;
import com.example.movie_api_development.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;


    @Override
    public Movie getById(Long id) {
        return movieRepository.findById(id).orElseThrow(
                () -> new MovieNotFound("Movie not found"));
    }

    @Override
    public Page<Movie> getAll(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    @Override
    public void update(Long id, MovieRequest movieRequest) {
        Movie existingMovie = movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFound("Movie not found with id: " + id));

        movieMapper.updateMovieFromDto(movieRequest, existingMovie);
        movieRepository.save(existingMovie);
    }

    @Override
    public void delete(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new MovieNotFound("Movie not found with id :" + id);
        }
        movieRepository.deleteById(id);
    }

    @Override
    public List<Movie> add(List<MovieRequest> movieRequests) {
        List<Movie> movies = movieMapper.toEntityList(movieRequests); // Mapper ilə List çevrilməsi
        return movieRepository.saveAll(movies);
    }

}
