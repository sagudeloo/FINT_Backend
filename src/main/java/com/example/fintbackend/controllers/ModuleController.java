package com.example.fintbackend.controllers;

import com.example.fintbackend.dtos.ModuleDto;
import com.example.fintbackend.services.ModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/modules")
public class ModuleController {
    private final ModuleService moduleService;
    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @GetMapping
    public ResponseEntity<List<ModuleDto>> findAll(){
        return moduleService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ModuleDto> findById(@PathVariable Integer id){
        return moduleService.findById(id);
    }

    //TODO: OAuth Config
    @PostMapping
    public ResponseEntity<ModuleDto> create(@RequestBody ModuleDto module){
        return moduleService.create(module);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModuleDto> update(@RequestBody ModuleDto module, @PathVariable Integer id){
        return moduleService.updateById(module, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ModuleDto> delete(@PathVariable Integer id){
        return moduleService.deleteById(id);
    }

}
