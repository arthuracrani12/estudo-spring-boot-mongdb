package com.arthuracrani.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.arthuracrani.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}