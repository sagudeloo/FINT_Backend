package com.example.fintbackend.repositories;

import com.example.fintbackend.models.Modules;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends CrudRepository<Modules, Integer> {
    //TODO: Module parameter is supposed to come from "models". Check this up.

}
