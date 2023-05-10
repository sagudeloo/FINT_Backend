package com.example.fintbackend.services;

import com.example.fintbackend.dtos.SubjectDto;
import com.example.fintbackend.models.Subjects;
import com.example.fintbackend.repositories.SubjectRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public ResponseEntity<List<SubjectDto>> findAll(){
        var a = subjectRepository.findAll();
        return new ResponseEntity(a, HttpStatus.OK);
    }
    public ResponseEntity<SubjectDto> findById(@PathVariable Integer id){
        var a = subjectRepository.findById(id);
        return a.map(subjects -> new ResponseEntity(subjects, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<SubjectDto>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<SubjectDto> create(@RequestBody SubjectDto subject){
        Subjects newSubject = new Subjects();
        newSubject.setTitle(subject.getTitle());
        newSubject.setProgress(subject.getProgress());
        newSubject.setModuleId(subject.getModuleId());
        subjectRepository.save(newSubject);
        return new ResponseEntity("Se ha creado un nuevo tema", HttpStatus.CREATED);
    }

    public ResponseEntity<SubjectDto> updateById (@RequestBody SubjectDto subject, @PathVariable Integer id){
        var a = subjectRepository.existsById(id);
        if (a){
            var b = subjectRepository.findById(id).get();
            b = b.withTitle(subject.getTitle()).withProgress(subject.getProgress()).withModuleId(subject.getModuleId());
            subjectRepository.save(b);
            return new ResponseEntity("Se ha modificado el tema con id: "+id, HttpStatus.OK);
        }
        return new ResponseEntity("El tema buscado no existe", HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<SubjectDto> deleteById(@PathVariable Integer id){
        subjectRepository.deleteById(id);
        return new ResponseEntity("El tema ha sido borrado", HttpStatus.NO_CONTENT);
    }
}
