package com.torres.notesapi.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.torres.notesapi.entities.Category;

public class CategoryDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	
	private AuthorDTO author;
	
	public CategoryDTO() {
		
	}
	
	public CategoryDTO(Category category) {
		this.id = category.getId();
		this.name = category.getName();
		this.author = category.getAuthor();
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

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
	
	public static List<CategoryDTO> convertToListDTO(List<Category> list) {
		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
	}
	
}
