package com.example.projeto_interdisciplinar.repo;

import com.example.projeto_interdisciplinar.entity.Log;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogsRepo extends MongoRepository<Log, Integer> {
}
