package com.example.fintbackend.repositories;

import com.example.fintbackend.persistence.entity.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository<Subject, Long> {
    //TODO: Subject parameter is supposed to come from "models". Check this up.

}
