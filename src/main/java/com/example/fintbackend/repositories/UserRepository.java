package com.example.fintbackend.repositories;


import com.example.fintbackend.models.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {
    //TODO: This Users parameter is being called from 'models'.
    Optional<Users> findByEmail(String email);
}
