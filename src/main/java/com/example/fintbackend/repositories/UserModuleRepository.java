package com.example.fintbackend.repositories;

import com.example.fintbackend.persistence.entity.UserModule;
import org.springframework.data.repository.CrudRepository;

public interface UserModuleRepository extends CrudRepository<UserModule, Long> {
    //TODO: UserModule parameter is supposed to come from "models". Check this up.

}
