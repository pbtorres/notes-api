package com.torres.notesapi.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.torres.notesapi.entities.User;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	
	private List<CategoryDTO> categories = new ArrayList<>();
	private List<NoteDTO> notes = new ArrayList<>(); 
	
	public UserDTO() {
		
	}

	public UserDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	
		notes = obj.getNotes()
				.stream()
				.map(x -> new NoteDTO(x, x.getCategory(), x.getAuthor())).collect(Collectors.toList());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<CategoryDTO> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryDTO> categories) {
		this.categories = categories;
	}

	public List<NoteDTO> getNotes() {
		return notes;
	}

	public void setNotes(List<NoteDTO> notes) {
		this.notes = notes;
	}

}
