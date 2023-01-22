package com.task.allocation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.allocation.model.JwtRequest;
import com.task.allocation.model.Tasks;
import com.task.allocation.model.User;
import com.task.allocation.model.UserResponse;
import com.task.allocation.service.TaskAllocationService;
import com.task.allocation.service.UserValidation;

@RestController
@CrossOrigin(origins = "*" , exposedHeaders = "**")
public class Controller {

	@Autowired
	TaskAllocationService allocations;
	
	@Autowired
	UserValidation validation;
	
	
	@PostMapping("/saveTask")
	public Tasks saveTask(@RequestBody Tasks task)
	{
		return allocations.savetask(task);
	}
	
	
	@PutMapping("/updateTask")
	public ResponseEntity<Tasks> updateTask(@RequestBody Tasks task)
	{
		return new ResponseEntity<>(allocations.upDateTasks(task),HttpStatus.OK);
	}
	
	@GetMapping("/getTasks")
	public List<Tasks>getTasksByname(@RequestParam String name)
	{
		return allocations.getTaskByName(name);
	}
	
	@GetMapping("/getallTasks")
	public List<Tasks>getTasks()
	{
		return allocations.getTasks();
	}
	
	@DeleteMapping("/deleteTask")
	public Tasks deletetasks(@RequestParam String name)
	{
		return allocations.deleteTask(name);
	}
	
	
	@PostMapping("/getUsers")
	public UserResponse getUser(@RequestBody JwtRequest userRequest) throws Exception
	{
		return validation.validateUser(userRequest);
	}
}
