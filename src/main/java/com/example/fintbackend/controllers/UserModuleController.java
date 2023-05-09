package com.example.fintbackend.controllers;


import com.example.fintbackend.dtos.UserModuleDto;
import com.example.fintbackend.services.UserModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userModule")
public class UserModuleController {
    private final UserModuleService userModuleService;
    public UserModuleController(UserModuleService userModuleService) {
        this.userModuleService = userModuleService;
    }

    @GetMapping
    public ResponseEntity<List<UserModuleDto>> findAll(){
        return userModuleService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModuleDto> findById(@PathVariable Integer id){
        return userModuleService.findById(id);
    }

    @PostMapping
    public ResponseEntity<UserModuleDto> create(@RequestBody UserModuleDto userModule){
        return userModuleService.create(userModule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserModuleDto> update(@RequestBody UserModuleDto userModule, @PathVariable Integer id){
        return userModuleService.updateById(userModule, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserModuleDto> delete(@PathVariable Integer id){
        return userModuleService.deleteById(id);
    }
}
