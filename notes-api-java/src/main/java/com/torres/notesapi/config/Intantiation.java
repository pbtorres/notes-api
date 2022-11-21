package com.torres.notesapi.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.torres.notesapi.entities.User;
import com.torres.notesapi.repository.UserRepository;

@Configuration
public class Intantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		User user1 =  new User(null, "Pablo", "pablo@gmail.com");
		userRepository.saveAll(Arrays.asList(user1));
		
	}

}
