package com.torres.notesapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torres.notesapi.dto.CategoryDTO;
import com.torres.notesapi.entities.Category;
import com.torres.notesapi.repository.CategoryRepository;
import com.torres.notesapi.services.exception.ObjectNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repo;
	
	public List<Category> findAll() {
		return repo.findAll();
	}
	
	public Category findById(String id) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public Category insert(Category obj) {
		return repo.insert(obj);
	}
	
	public Category update(Category obj) {
		Category newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void deleteById(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public void updateData(Category newObj, Category obj) {
		newObj.setName(obj.getName());
	}
	
	public Category fromDTO(CategoryDTO objDTO) {
		return new Category(objDTO.getId(), objDTO.getName(), objDTO.getAuthor());
	}

}
