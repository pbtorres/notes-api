package com.torres.notesapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.torres.notesapi.entities.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

}
