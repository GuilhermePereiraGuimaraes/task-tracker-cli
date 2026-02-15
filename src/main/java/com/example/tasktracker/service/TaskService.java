package com.example.tasktracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tasktracker.exceptions.TaskNotFoundException;
import com.example.tasktracker.model.Task;
import com.example.tasktracker.model.dtos.CreateTaskDTO;
import com.example.tasktracker.model.dtos.TaskDTO;
import com.example.tasktracker.model.dtos.UpdateTaskDTO;
import com.example.tasktracker.model.enums.Status;
import com.example.tasktracker.model.mapper.TaskMapper;
import com.example.tasktracker.repository.TaskRepository;

@Service
public class TaskService {
	
	private TaskRepository repository;
	private TaskMapper mapper;
	
	public TaskService(TaskRepository repository, TaskMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public TaskDTO create(CreateTaskDTO dto) {
		Task task = mapper.toEntity(dto);
		task = repository.save(task);
		return mapper.toDTO(task);
	}
	
	public void update(String description, Long id) {
		Task task = repository.findById(id).orElseThrow(()-> new TaskNotFoundException());
		task.setDescription(description);
		
		repository.save(task);
	}
	
	public void delete(Long id) {
		Task task = repository.findById(id).orElseThrow(()-> new TaskNotFoundException());
		repository.delete(task);
	}
	
	public void markInProgress(Long id) {
		Task task = repository.findById(id).orElseThrow(()-> new TaskNotFoundException());
		task.setStatus(Status.IN_PROGRESS);
		
		repository.save(task);
	}
	
	public void markDone(Long id) {
		Task task = repository.findById(id).orElseThrow(()-> new TaskNotFoundException());
		task.setStatus(Status.DONE);
		
		repository.save(task);
	}
	
	public List<TaskDTO> listAll(){
		return repository.findAll().stream().map(task -> mapper.toDTO(task)).toList();
	}
	
	public List<TaskDTO> listAllDone(){
		return repository.findAll().stream()
				.filter(task -> task.getStatus().equals(Status.DONE))
				.map(task -> mapper.toDTO(task)).toList();
	}
	public List<TaskDTO> listAllInProgress(){
		return repository.findAll().stream()
				.filter(task -> task.getStatus().equals(Status.IN_PROGRESS))
				.map(task -> mapper.toDTO(task)).toList();
	}
	public List<TaskDTO> listAllToDo(){
		return repository.findAll().stream()
				.filter(task -> task.getStatus().equals(Status.TODO))
				.map(task -> mapper.toDTO(task)).toList();
	}
}
