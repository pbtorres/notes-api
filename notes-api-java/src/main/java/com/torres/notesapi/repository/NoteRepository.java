package com.torres.notesapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.torres.notesapi.entities.Note;

@Repository
public interface NoteRepository extends MongoRepository<Note, String>{

}
