package com.example.fintbackend.repositories;

import com.example.fintbackend.models.Multimedia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultimediaRepository extends CrudRepository<Multimedia, Integer> {
    //TODO: Multimedia parameter is supposed to come from "models". Check this up.
}