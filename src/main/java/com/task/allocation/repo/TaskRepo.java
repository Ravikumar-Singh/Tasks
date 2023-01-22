package com.task.allocation.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.task.allocation.model.Tasks;


public interface TaskRepo extends MongoRepository<Tasks, String> {

	Tasks findByName(String name);
	List<Tasks> findByNameRegex(String name);
}
