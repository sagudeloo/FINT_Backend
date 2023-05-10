package com.example.fintbackend.controllers;

import com.example.fintbackend.dtos.ContentDto;
import com.example.fintbackend.services.ContentServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/content")
public class ContentController {
    private final ContentServices contentServices;
    public ContentController(ContentServices contentServices) {
        this.contentServices = contentServices;
    }

    @GetMapping
    public ResponseEntity<List<ContentDto>> findAll(){
        return contentServices.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContentDto> findById(@PathVariable Integer id){
        return contentServices.findById(id);
    }

    @PostMapping
    public ResponseEntity<ContentDto> create(@RequestBody ContentDto content){
        return contentServices.create(content);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContentDto> updateById(@RequestBody ContentDto content, @PathVariable Integer id){
        return contentServices.updateById(content, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ContentDto> deleteById(@PathVariable Integer id){
        return contentServices.deleteById(id);
    }

}
