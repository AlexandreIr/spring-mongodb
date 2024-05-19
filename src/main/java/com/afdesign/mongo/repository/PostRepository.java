package com.afdesign.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.afdesign.mongo.domain.Post;
import com.afdesign.mongo.domain.User;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}