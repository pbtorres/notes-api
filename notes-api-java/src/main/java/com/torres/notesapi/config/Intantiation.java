package com.torres.notesapi.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.torres.notesapi.dto.AuthorDTO;
import com.torres.notesapi.entities.Note;
import com.torres.notesapi.entities.User;
import com.torres.notesapi.repository.NoteRepository;
import com.torres.notesapi.repository.UserRepository;

@Configuration
public class Intantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private NoteRepository noteRepository;
	
	@Override
	public void run(String... args) throws Exception {

		noteRepository.deleteAll();
		userRepository.deleteAll();
		
		User user1 =  new User(null, "Pablo", "pablo@gmail.com");
		userRepository.saveAll(Arrays.asList(user1));
		
		Note note1 = new Note(null, "Teste 1", "Essa é uma nota teste", new Date(), new AuthorDTO(user1));
		noteRepository.saveAll(Arrays.asList(note1));
		
		user1.getNotes().add(note1);
		userRepository.saveAll(Arrays.asList(user1));

	}

}
