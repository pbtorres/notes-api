package com.torres.notesapi.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.torres.notesapi.dto.CategoryDTO;
import com.torres.notesapi.entities.Category;
import com.torres.notesapi.services.CategoryService;

@RestController
@RequestMapping(value="categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll() {
		List<Category> list = service.findAll();
		List<CategoryDTO> listDTO = CategoryDTO.convertToListDTO(list);
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<CategoryDTO> findById(@PathVariable String id) {
		Category obj = service.findById(id);
		CategoryDTO objDTO = new CategoryDTO(obj);
		return ResponseEntity.ok().body(objDTO);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody CategoryDTO objDTO) {
		Category obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@RequestBody CategoryDTO objDTO, @PathVariable String id) {
		Category obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deletById(@PathVariable String id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value="/find_by_user_id")
	public ResponseEntity<List<CategoryDTO>> findByUserId(@RequestParam(value="user_id") String userId) {
		List<Category> list = service.findByUserId(userId);
		List<CategoryDTO> listDTO = CategoryDTO.convertToListDTO(list);
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value="/find_by_name")
	public ResponseEntity<List<CategoryDTO>> findByName(@RequestParam(value="name") String name) {
		List<Category> list = service.findByName(name);
		List<CategoryDTO> listDTO = CategoryDTO.convertToListDTO(list);
		return ResponseEntity.ok().body(listDTO);
	}
	
}
