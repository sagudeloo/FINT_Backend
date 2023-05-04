package com.example.fintbackend.repositories;

import com.example.fintbackend.persistence.entity.Module;
import org.springframework.data.repository.CrudRepository;

public interface ModuleRepository extends CrudRepository<Module, Long> {
    //TODO: Module parameter is supposed to come from "models". Check this up.

}
