package com.example.fintbackend.services;

import com.example.fintbackend.dtos.ContentDto;
import com.example.fintbackend.models.Contents;
import com.example.fintbackend.repositories.ContentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ContentServices {
    private final ContentRepository contentRepository;

    public ContentServices(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public ResponseEntity<List<ContentDto>> findAll(){
        var a = contentRepository.findAll();
        return new ResponseEntity(a, HttpStatus.OK);
    }
    public ResponseEntity<ContentDto> findById(@PathVariable Integer id){
        var a = contentRepository.findById(id);
        return a.map(contents -> new ResponseEntity(contents, HttpStatus.OK)).orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<ContentDto> create(@RequestBody ContentDto content){
        Contents newContent = new Contents();
        newContent.setTitle(content.getTitle());
        newContent.setText(content.getText());
        contentRepository.save(newContent);
        return new ResponseEntity("Se ha creado un nuevo contenido", HttpStatus.CREATED);
    }

    public ResponseEntity<ContentDto> updateById(@RequestBody ContentDto content, @PathVariable Integer id){
        var a = contentRepository.existsById(id);
        if(a){
            var b = contentRepository.findById(id).get();
            b = b.withTitle(content.getTitle()).withText(content.getText()).withSubjectId(content.getSubjectId());
            contentRepository.save(b);
            return new ResponseEntity("Se ha modificado el contenido con id: "+id, HttpStatus.OK);
        }
        return new ResponseEntity("El contenido buscado no existe", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<ContentDto> deleteById(@PathVariable Integer id){
        contentRepository.deleteById(id);
        return new ResponseEntity("El modulo ha sido borrado", HttpStatus.NO_CONTENT);
    }
}
