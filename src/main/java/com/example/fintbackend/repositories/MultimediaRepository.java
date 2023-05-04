package com.example.fintbackend.repositories;

import com.example.fintbackend.persistence.entity.Multimedia;
import org.springframework.data.repository.CrudRepository;

public interface MultimediaRepository extends CrudRepository<Multimedia, Long> {
    //TODO: Multimedia parameter is supposed to come from "models". Check this up.

}
