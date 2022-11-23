package com.torres.notesapi.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.torres.notesapi.dto.AuthorDTO;
import com.torres.notesapi.dto.CategoryDTO;

@Document(collection="note")
public class Note implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String title;
	private String text;
	private Date created_at;
	
	private CategoryDTO category;
	private AuthorDTO author;
	
	public Note() {
		
	}

	public Note(String id, String title, String text, Date created_at,CategoryDTO category, AuthorDTO author) {
		super();
		this.id = id;
		this.title = title;
		this.text = text;
		this.created_at = created_at;
		this.category = category;
		this.author = author;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		return Objects.equals(id, other.id);
	}

}
