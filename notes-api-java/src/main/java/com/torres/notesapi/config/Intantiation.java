package com.torres.notesapi.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.torres.notesapi.dto.AuthorDTO;
import com.torres.notesapi.dto.CategoryDTO;
import com.torres.notesapi.entities.Category;
import com.torres.notesapi.entities.Note;
import com.torres.notesapi.entities.User;
import com.torres.notesapi.repository.CategoryRepository;
import com.torres.notesapi.repository.NoteRepository;
import com.torres.notesapi.repository.UserRepository;

@Configuration
public class Intantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private NoteRepository noteRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void run(String... args) throws Exception {

		noteRepository.deleteAll();
		userRepository.deleteAll();
		categoryRepository.deleteAll();
		
		User user1 =  new User(null, "Pablo", "pablo@gmail.com");
		User user2 =  new User(null, "Flavio", "flavio@gmail.com");
		userRepository.saveAll(Arrays.asList(user1, user2));
		
		Category cat1 = new Category(null, "Alimentação", new AuthorDTO(user1));
		Category cat2 = new Category(null, "Transporte", new AuthorDTO(user2));
		Category cat3 = new Category(null, "Saúde", new AuthorDTO());

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		Note note1 = new Note(null, "Teste 1", "Essa é uma nota teste", new Date(), new CategoryDTO(cat1), new AuthorDTO(user1));
		Note note2 = new Note(null, "Uma nova nota", "Created new note", new Date(), new CategoryDTO(cat2), new AuthorDTO(user1));
		noteRepository.saveAll(Arrays.asList(note1, note2));
		
		user1.getCategories().addAll(Arrays.asList(cat1));
		user2.getCategories().addAll(Arrays.asList(cat2));
		user1.getNotes().add(note1);
		userRepository.saveAll(Arrays.asList(user1, user2));

	}

}
