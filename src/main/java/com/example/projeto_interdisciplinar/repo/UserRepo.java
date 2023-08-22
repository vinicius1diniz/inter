package com.example.projeto_interdisciplinar.repo;

import com.example.projeto_interdisciplinar.entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.projeto_interdisciplinar.repo")
public interface UserRepo extends MongoRepository<User,Integer> {
}
