package com.example.movie_api_development.mapper;

import com.example.movie_api_development.dao.entity.User;
import com.example.movie_api_development.model.dto.request.RegisterRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(RegisterRequest request);
}
