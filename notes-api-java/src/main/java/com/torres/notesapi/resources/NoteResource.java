package com.torres.notesapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torres.notesapi.entities.Note;
import com.torres.notesapi.services.NoteService;

@RestController
@RequestMapping(value="notes")
public class NoteResource {
	
	@Autowired
	private NoteService service;
		
	@GetMapping
	public ResponseEntity<List<Note>> findAll() {
		List<Note> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Note> findById(@PathVariable String id) {
		Note obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
