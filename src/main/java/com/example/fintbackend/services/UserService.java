package com.example.fintbackend.services;

import com.example.fintbackend.dtos.UserDto;
import com.example.fintbackend.models.Users;
import com.example.fintbackend.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<List<UserDto>> findAll(){
        var a = userRepository.findAll();
        return new ResponseEntity(a, HttpStatus.OK);
    }
    public ResponseEntity<UserDto> findById(@PathVariable Integer id){
        var a = userRepository.findById(id);
        return a.map(users -> new ResponseEntity(users, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<UserDto>(HttpStatus.NOT_FOUND));
        /*
                if(a.isEmpty()){
            return new ResponseEntity<UserDto>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(a.get(), HttpStatus.OK);
         */
    }
    public ResponseEntity<UserDto> create(@RequestBody UserDto user){
        UserDto newUser = new UserDto();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setRole(user.getRole());
        userRepository.save(buildUser(newUser));
        return new ResponseEntity(HttpStatus.CREATED);
    }
    /*      Hash Password   */
    private Users buildUser(UserDto user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return Users.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(encoder.encode(user.getPassword()))
                .role(user.getRole())
                .build();
    }

    //TODO: @ApiResponses not working... Check dependencies

    //TODO: Currently mixing content of UserControllersSQL + services in SWMDBJWT

    public Boolean existsByEmail(@PathVariable String email){
        var a = userRepository.findByEmail(email);
        return a.isPresent();
    }

    public ResponseEntity<UserDto> updateById(@RequestBody UserDto user, @PathVariable Integer id){
        var a = userRepository.existsById(id);
        if(a){
            var b = userRepository.findById(id).get();
            b = b.withName(user.getName()).withPassword(user.getPassword()).withEmail(user.getEmail()).withRole(user.getRole());
            userRepository.save(b);
            return new ResponseEntity("Se ha modificado el usuario con id: " + id, HttpStatus.OK);
        }
        return new ResponseEntity("El usuario buscado no existe", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<UserDto> deleteById(@PathVariable Integer id){
        userRepository.deleteById(id);
        return new ResponseEntity("El usuario ha sido borrado", HttpStatus.NO_CONTENT);
    }
}
