package com.arthuracrani.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.arthuracrani.domain.User;
import com.arthuracrani.repository.UserRepository;

//para o spring entender que é uma configuração
@Configuration
public class Instantiation implements CommandLineRunner {

	//injeção do Userrepository para fazer operação com o bd
	@Autowired
	private UserRepository userReposiroty;

	@Override
	public void run(String... arg0) throws Exception {

		//limpa a coleção no mongo db
		userReposiroty.deleteAll();

		//id null pq é o bd que ira gerar
		User maria = new User(null, "Arthur Acrani", "arthur@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		//salva os objetos na coleção de usuario
		userReposiroty.saveAll(Arrays.asList(maria, alex, bob));
		
	}
	
	
}
