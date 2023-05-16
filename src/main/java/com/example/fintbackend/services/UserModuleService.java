package com.example.fintbackend.services;

import com.example.fintbackend.dtos.UserModuleDto;
import com.example.fintbackend.models.UsersModules;
import com.example.fintbackend.repositories.UserModuleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserModuleService {
    private final UserModuleRepository userModuleRepository;

    public UserModuleService(UserModuleRepository userModuleRepository) {
        this.userModuleRepository = userModuleRepository;
    }

    public ResponseEntity<List<UserModuleDto>> findAll(){
        var a = userModuleRepository.findAll();
        return new ResponseEntity(a, HttpStatus.OK);
    }
    public ResponseEntity<UserModuleDto> findById(@PathVariable Integer id){
        var a = userModuleRepository.findById(id);
        if(a.isEmpty()){
            return new ResponseEntity<UserModuleDto>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(a, HttpStatus.OK);
    }
    public ResponseEntity<UserModuleDto> create(@RequestBody UserModuleDto userModule){
        UsersModules newUserModule = new UsersModules();
        newUserModule.setUserId(userModule.getUserId());
        newUserModule.setModuleId(userModule.getModuleId());
        newUserModule.setProgress(userModule.getProgress());
        userModuleRepository.save(newUserModule);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    public ResponseEntity<UserModuleDto> updateById(@RequestBody UserModuleDto userModule, @PathVariable Integer id){
        var a = userModuleRepository.existsById(id);
        if(a){
            var b = userModuleRepository.findById(id).get();
            b = b.withUserId(userModule.getUserId()).withModuleId(userModule.getModuleId()).withProgress(userModule.getProgress());
            userModuleRepository.save(b);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<UserModuleDto> deleteById(@PathVariable Integer id){
        userModuleRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
