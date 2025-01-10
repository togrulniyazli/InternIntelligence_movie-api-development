package com.example.movie_api_development.mapper;

import com.example.movie_api_development.dao.entity.Movie;
import com.example.movie_api_development.model.dto.request.MovieRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    public void updateMovieFromDto(MovieRequest movieRequest, @MappingTarget Movie existingMovie);

    List<Movie> toEntityList(List<MovieRequest> movieRequests);
}
