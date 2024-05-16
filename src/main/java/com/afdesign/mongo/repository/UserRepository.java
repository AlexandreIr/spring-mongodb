package com.afdesign.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.afdesign.mongo.domain.User;

public interface UserRepository extends MongoRepository<User, String>{

}
