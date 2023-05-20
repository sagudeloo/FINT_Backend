package com.example.fintbackend.services;

import com.example.fintbackend.dtos.ModuleDto;
import com.example.fintbackend.dtos.UserDto;
import com.example.fintbackend.models.Modules;
import com.example.fintbackend.repositories.ModuleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ModuleService {
    private final ModuleRepository moduleRepository;

    public ModuleService(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    public ResponseEntity<List<ModuleDto>> findAll(){
        var a = moduleRepository.findAll();
        return new ResponseEntity(a, HttpStatus.OK);
    }
    public ResponseEntity<ModuleDto> findById(@PathVariable Integer id){
        var a = moduleRepository.findById(id);
        return a.map(modules -> new ResponseEntity(modules, HttpStatus.OK)).orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<ModuleDto> create(@RequestBody ModuleDto module){
        Modules newModule = new Modules();
        newModule.setTitle(module.getTitle());
        newModule.setDescription(module.getDescription());
        moduleRepository.save(newModule);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    public ResponseEntity<ModuleDto> updateById(@RequestBody ModuleDto module, @PathVariable Integer id){
        var a = moduleRepository.existsById(id);
        if(a){
            var b = moduleRepository.findById(id).get();
            b = b.withTitle(module.getTitle()).withDescription(module.getDescription());
            moduleRepository.save(b);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<ModuleDto> deleteById(@PathVariable Integer id){
        moduleRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
