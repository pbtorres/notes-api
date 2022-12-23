package com.torres.notesapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torres.notesapi.dto.NoteDTO;
import com.torres.notesapi.entities.Note;
import com.torres.notesapi.repository.NoteRepository;
import com.torres.notesapi.services.exception.ObjectNotFoundException;

@Service
public class NoteService {

	@Autowired
	private NoteRepository repo;
	
	public List<Note> findAll() {
		return repo.findAll();
	}
	
	public Note findById(String id) {
		Optional<Note> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public List<Note> findByUserId(String userId) {
		return repo.findByUserId(userId);
	}
	
	public List<Note> fullSearch(String text) {
		return repo.fullSearch(text);
	}
	
	public Note update(Note obj) {
		Note newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void updateData(Note newObj, Note obj) {
		newObj.setTitle(obj.getTitle());
		newObj.setText(obj.getText());
		newObj.setCreated_at(obj.getCreated_at());
		newObj.setCategory(obj.getCategory());
		newObj.setAuthor(obj.getAuthor());
	}
	
	public Note fromDTO(NoteDTO objDTO) {
		return new Note(objDTO.getId(),
				objDTO.getTitle(),
				objDTO.getText(),
				objDTO.getCreated_at(),
				objDTO.getCategory(),
				objDTO.getAuthor());
	}
	
}
