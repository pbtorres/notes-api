package com.torres.notesapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.torres.notesapi.dto.NoteDTO;
import com.torres.notesapi.entities.Note;
import com.torres.notesapi.resources.util.URL;
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
	
	@GetMapping(value="/find_by_user_id")
	public ResponseEntity<List<Note>> findByUserId(@RequestParam(value="user_id") @PathVariable String userId) {
		return ResponseEntity.ok().body(service.findByUserId(userId));
	}
	
	@GetMapping(value="/full_search")
	public ResponseEntity<List<Note>> fullSearch(@RequestParam(value="text", defaultValue="") String text) {
		text = URL.decodeParam(text);	
		return ResponseEntity.ok().body(service.fullSearch(text));
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@RequestBody NoteDTO objDTO, @PathVariable String id) {
		Note obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
}
