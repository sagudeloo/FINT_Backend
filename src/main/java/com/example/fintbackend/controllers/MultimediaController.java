package com.example.fintbackend.controllers;

import com.example.fintbackend.dtos.MultimediaDto;
import com.example.fintbackend.services.MultimediaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/multimedia")
public class MultimediaController {
    private final MultimediaService multimediaService;

    public MultimediaController(MultimediaService multimediaService) {
        this.multimediaService = multimediaService;
    }

    @GetMapping
    public ResponseEntity<List<MultimediaDto>> findAll(){
        return multimediaService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<MultimediaDto> findById(@PathVariable Integer id){
        return multimediaService.findById(id);
    }

    @PostMapping
    public ResponseEntity<MultimediaDto> create(@RequestBody MultimediaDto multimedia){
        return multimediaService.create(multimedia);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MultimediaDto> update(@RequestBody MultimediaDto multimedia, @PathVariable Integer id){
        return multimediaService.updateById(multimedia, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MultimediaDto> delete(@PathVariable Integer id){
        return multimediaService.deleteById(id);
    }
}
