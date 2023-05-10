package com.example.fintbackend.controllers;

import com.example.fintbackend.dtos.SubjectDto;
import com.example.fintbackend.services.SubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    public ResponseEntity<List<SubjectDto>> findAll(){
        return subjectService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectDto> findById(@PathVariable Integer id){
        return subjectService.findById(id);
    }

    @PostMapping
    public ResponseEntity<SubjectDto> create(@RequestBody SubjectDto subject){
        return subjectService.create(subject);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectDto> updateById(@RequestBody SubjectDto subject, @PathVariable Integer id){
        return subjectService.updateById(subject, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SubjectDto> delete(@PathVariable Integer id){
        return subjectService.deleteById(id);
    }
}
