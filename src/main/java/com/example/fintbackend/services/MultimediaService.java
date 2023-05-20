package com.example.fintbackend.services;

import com.example.fintbackend.dtos.MultimediaDto;
import com.example.fintbackend.models.Multimedias;
import com.example.fintbackend.repositories.MultimediaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MultimediaService {
    private final MultimediaRepository multimediaRepository;

    public MultimediaService(MultimediaRepository multimediaRepository){
        this.multimediaRepository = multimediaRepository;
    }

    public ResponseEntity<List<MultimediaDto>> findAll(){
        var a = multimediaRepository.findAll();
        return new ResponseEntity(a, HttpStatus.OK);
    }
    public ResponseEntity<MultimediaDto> findById(@PathVariable Integer id){
        var a = multimediaRepository.findById(id);
        return a.map(multi -> new ResponseEntity(multi, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<MultimediaDto>(HttpStatus.NOT_FOUND));
    }

    public  ResponseEntity<MultimediaDto> create(@RequestBody MultimediaDto multimedia){
        Multimedias newMultimedia = new Multimedias();
        newMultimedia.setTitle(multimedia.getTitle());
        newMultimedia.setUrl(multimedia.getUrl());
        newMultimedia.setDuration(multimedia.getDuration());
        newMultimedia.setContentId(multimedia.getContentId());
        multimediaRepository.save(newMultimedia);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    public ResponseEntity<MultimediaDto> updateById(@RequestBody MultimediaDto multimedia, @PathVariable Integer id){
        var a = multimediaRepository.existsById(id);
        if(a){
            var b = multimediaRepository.findById(id).get();
            b = b.withTitle(multimedia.getTitle()).withUrl(multimedia.getUrl()).withDuration(multimedia.getDuration()).withContentId(multimedia.getContentId());
            multimediaRepository.save(b);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<MultimediaDto> deleteById(@PathVariable Integer id){
        multimediaRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
