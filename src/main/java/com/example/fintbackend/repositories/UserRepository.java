package com.example.fintbackend.repositories;

import com.example.fintbackend.dtos.UserDto;

public interface UserRepository {
    UserDto findById(int id);
}
