package com.torres.notesapi.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.torres.notesapi.entities.Note;

@Repository
public interface NoteRepository extends MongoRepository<Note, String>{
	
	@Query("{'author.id': ?0}")
	List<Note> findByUserId(String userId);

	@Query("{ $or: [ { 'title': { $regex: ?0, $options: 'i' } }, {'text': { $regex: ?0, $options: 'i' } } ] }")
	List<Note> fullSearch(String text);
	
}