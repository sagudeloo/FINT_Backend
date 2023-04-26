package com.example.fintbackend.repositories;

import com.example.fintbackend.dtos.UserDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{
    private final List<UserDto> database;

    public UserRepositoryImpl(List<UserDto> database) {
        this.database = database;
    }

    @Override
    public UserDto findById(int id) {
        return database.stream()
                .filter(userDto -> matchWithId(id, userDto))
                .findAny().get();
    }
    //Checks for a user which id matches with the given one;
    private boolean matchWithId(int id, UserDto userDto){
        return userDto.getId() == id;
    }


}
