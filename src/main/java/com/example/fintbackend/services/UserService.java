package com.example.fintbackend.services;

import com.example.fintbackend.dtos.UserDto;
import com.example.fintbackend.models.Users;
import com.example.fintbackend.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity getAll(){
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

    //TODO: @ApiResponses not working... Check dependencies

    public ResponseEntity getById(@PathVariable Long id){
        var a = userRepository.findById(id);
        if(a.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(a.get(), HttpStatus.OK);
    }

    //TODO: Currently mixing content of UserControllersSQL + services in SWMDBJWT

    public ResponseEntity updateById(@RequestBody UserDto user, @PathVariable Long id){
        var a = userRepository.existsById(id);
        if(a){
            var b = userRepository.findById(id).get();
            b = b.withName(user.getName()).withPassword(user.getPassword()).withEmail(user.getEmail());
            userRepository.save(b);
            return new ResponseEntity(b, HttpStatus.OK);
        }
        return new ResponseEntity("El usuario buscado no existe", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity deleteById(@PathVariable Long id){
        userRepository.deleteById(id);
        return new ResponseEntity("El usuario ha sido borrado", HttpStatus.NO_CONTENT);
    }
}
