package com.emirates.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emirates.entity.Task;
import com.emirates.repository.TaskRepository;

@RestController
public class TaskController {

	@Autowired
	TaskRepository repository;

	
	

	@GetMapping("/getTasks")
	public Collection<Task> getTasks() {
		return repository.findAll().stream().filter(this::notDeleted).collect(Collectors.toList());

	}

	@PostMapping("/createTask")
	public void createTask() {

		Task task = new Task();
		task.setName("abcd");
		task.setStatus("PENDING");
		
		repository.save(task);
	}
	
	@PutMapping("/approveTask")
	public void approveTask(@RequestBody String taskName) {
		
		repository.updateTaskStatus("APPROVE", taskName);
		
	}
	

	private boolean notDeleted(Task task) {
		return !task.getStatus().equalsIgnoreCase("DELETE");
	}

}
