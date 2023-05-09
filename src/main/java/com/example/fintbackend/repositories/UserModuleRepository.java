package com.example.fintbackend.repositories;

import com.example.fintbackend.models.UsersModules;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserModuleRepository extends CrudRepository<UsersModules, Integer> {
    //TODO: UserModule parameter is supposed to come from "models". Check this up.

}
