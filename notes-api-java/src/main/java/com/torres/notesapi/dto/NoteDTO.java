package com.torres.notesapi.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.torres.notesapi.entities.Note;

public class NoteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String title;
	private String text;
	private Date created_at;
	
	private CategoryDTO category;
	private AuthorDTO author;
	
	public NoteDTO() {
		
	}
	
	public NoteDTO(Note noteObj, CategoryDTO categoryDTO, AuthorDTO authorDTO) {
		id = noteObj.getId();
		title = noteObj.getTitle();
		text = noteObj.getText();
		created_at = noteObj.getCreated_at();
		
		category = categoryDTO;
		author = authorDTO;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
	
	public static List<NoteDTO> convertToListDTO(List<Note> list) {
		List<NoteDTO> listDTO = list.stream().map(x -> new NoteDTO(x, x.getCategory(), x.getAuthor())).collect(Collectors.toList());
		return listDTO;
	}

}
