package com.example.fintbackend.services;

import com.example.fintbackend.dtos.UserDto;
import com.example.fintbackend.models.Users;
import com.example.fintbackend.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity readAll(){
        var a = userRepository.findAll();
        return new ResponseEntity(a, HttpStatus.OK);
    }
    public ResponseEntity create(@RequestBody UserDto user){
        Users newUser = new Users();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        userRepository.save(newUser);
        return new ResponseEntity("Create new user", HttpStatus.CREATED);
    }

    //TODO: Currently mixing content of UserControllersSQL + services in SWMDBJWT
}
