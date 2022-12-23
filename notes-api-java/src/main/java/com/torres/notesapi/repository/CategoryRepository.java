package com.torres.notesapi.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.torres.notesapi.entities.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
	
	@Query("{ 'author.id': ?0 }")
	List<Category> findByUserId(String userId);
	
	@Query("{ 'name': { $regex: ?0, $options: 'i' } }")
	List<Category> findByName(String name);
	
}