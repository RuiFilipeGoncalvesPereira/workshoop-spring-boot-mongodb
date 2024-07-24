package com.rui6._9.hotmail.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rui6._9.hotmail.workshopmongo.domain.Post;
import com.rui6._9.hotmail.workshopmongo.domain.User;
import com.rui6._9.hotmail.workshopmongo.repository.PostRepository;
import com.rui6._9.hotmail.workshopmongo.repository.UserRepository;
import com.rui6._9.hotmail.workshopmongo.dto.AuthorDTO;
import com.rui6._9.hotmail.workshopmongo.dto.CommentDTO;


@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();		
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1= new Post(null, sdf.parse("21/03/2018"),"Partiu Viagem","Vou viajar para faro.Abraços!", new AuthorDTO(maria));
		Post post2= new Post(null, sdf.parse("23/03/2018"),"Bom dia","Acordei feliz hoje!", new AuthorDTO(maria));
		
		CommentDTO C1 = new  CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"),new AuthorDTO(alex));
		CommentDTO C2 = new  CommentDTO("Aproveite", sdf.parse("22/03/2018"),new AuthorDTO(bob));
		CommentDTO C3 = new  CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"),new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(C1,C2));
		post2.getComments().addAll(Arrays.asList(C3));
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(maria);
		
	}
}
