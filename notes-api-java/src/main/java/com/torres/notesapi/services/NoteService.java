package com.torres.notesapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torres.notesapi.entities.Note;
import com.torres.notesapi.repository.NoteRepository;

@Service
public class NoteService {

	@Autowired
	private NoteRepository repo;
	
	public List<Note> findAll() {
		return repo.findAll();
	}
	
	public Note findById(String id) {
		Optional<Note> obj = repo.findById(id);
		return obj.get();
	}
	
}
