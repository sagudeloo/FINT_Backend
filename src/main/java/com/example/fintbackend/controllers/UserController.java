package com.example.fintbackend.controllers;

import com.example.fintbackend.dtos.UserDto;
import com.example.fintbackend.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> findAll(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id){
        return userService.findById(id);
    }

    //TODO: OAuth Config
    @PostMapping("/users")
    public ResponseEntity<UserDto> create(@RequestBody UserDto user){
        return userService.create(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserDto> update(@RequestBody UserDto user, @PathVariable Long id){
        return userService.updateById(user, id);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<UserDto> delete(@PathVariable Long id){
        return userService.deleteById(id);
    }
}
