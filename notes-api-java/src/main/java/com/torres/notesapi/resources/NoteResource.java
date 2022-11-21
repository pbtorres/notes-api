package com.torres.notesapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
		//List<User> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}
	
}
