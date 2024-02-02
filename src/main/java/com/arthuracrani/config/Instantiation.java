package com.arthuracrani.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.arthuracrani.domain.Post;
import com.arthuracrani.domain.User;
import com.arthuracrani.dto.AuthorDTO;
import com.arthuracrani.repository.PostRepository;
import com.arthuracrani.repository.UserRepository;

//para o spring entender que é uma configuração
@Configuration
public class Instantiation implements CommandLineRunner {

	//injeção do Userrepository para fazer operação com o bd
	@Autowired
	private UserRepository userReposiroty;

	@Autowired
	private PostRepository postReposiroty;
	
	@Override
	public void run(String... arg0) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		//limpa a coleção no mongo db
		userReposiroty.deleteAll();
		postReposiroty.deleteAll();
		
		//id null pq é o bd que ira gerar
		User maria = new User(null, "Arthur Acrani", "arthur@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		//salvar primeiro os usuarios para que gere o ID e tenho salve o post paraa já buscar com o id
		userReposiroty.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

		//salva os objetos na coleção de usuario
	
		postReposiroty.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userReposiroty.save(maria);
	}
	
	
}
