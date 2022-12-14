package com.torres.notesapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.torres.notesapi.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
