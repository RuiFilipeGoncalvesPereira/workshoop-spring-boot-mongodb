package com.rui6._9.hotmail.workshopmongo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rui6._9.hotmail.workshopmongo.domain.Post;


@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	
	
    
}
