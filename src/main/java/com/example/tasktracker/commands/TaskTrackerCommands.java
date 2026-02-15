package com.example.tasktracker.commands;

import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;
import org.springframework.shell.standard.ShellComponent;

import com.example.tasktracker.model.dtos.CreateTaskDTO;
import com.example.tasktracker.model.dtos.TaskDTO;
import com.example.tasktracker.model.dtos.UpdateTaskDTO;
import com.example.tasktracker.model.enums.Status;
import com.example.tasktracker.service.TaskService;

@ShellComponent
@Command(group = "task-cli")
public class TaskTrackerCommands {
	
	private TaskService service;

	public TaskTrackerCommands(TaskService service) {
		super();
		this.service = service;
	}
	
	
	@Command(command = "task-cli add")
	public void add(
			@Option(required = true, longNames = "description", shortNames = 'd')
			String description) {
		TaskDTO taskDTO = service.create(new CreateTaskDTO(description, Status.TODO));
		System.out.println("# Output: Task added successfully (ID: "+taskDTO.id()+")");
	}
	
	@Command(command = "task-cli list")
	public void list() {
		service.listAll()
		.forEach(e -> System.out.println("# Task "+e.id()+
				"| Description: "+e.description()+
				"| Status: "+e.status()+
				"| CreatedAt: "+e.createdAt()+
				"| UpdatedAt: "+e.updatedAt()));
	}
	
	@Command(command = "task-cli list todo")
	public void listTodo() {
		service.listAllToDo()
		.forEach(e -> System.out.println("# Task "+e.id()+
				"| Description: "+e.description()+
				"| Status: "+e.status()+
				"| CreatedAt: "+e.createdAt()+
				"| UpdatedAt: "+e.updatedAt()));
	}
	
	@Command(command = "task-cli list done")
	public void listDone() {
		service.listAllDone()
		.forEach(e -> System.out.println("# Task "+e.id()+
				"| Description: "+e.description()+
				"| Status: "+e.status()+
				"| CreatedAt: "+e.createdAt()+
				"| UpdatedAt: "+e.updatedAt()));
	}
	
	@Command(command = "task-cli list in-progress")
	public void listInPtogress() {
		service.listAllInProgress()
		.forEach(e -> System.out.println("# Task "+e.id()+
				"| Description: "+e.description()+
				"| Status: "+e.status()+
				"| CreatedAt: "+e.createdAt()+
				"| UpdatedAt: "+e.updatedAt()));
	}
	
	@Command(command = "task-cli update")
	public void update(@Option(required = true) Long id, @Option(required = true) String description) {
		service.update(description, id);
		System.out.println("# Task "+id+" updated successfully!");
	}
	
	@Command(command = "task-cli mark-in-progress")
	public void markInProgress(@Option(required = true) Long id) {
		service.markInProgress(id);
		System.out.println("# Task "+id+" changed for \"in progress\" successfully!");
	}
	
	@Command(command = "task-cli mark-done")
	public void markDone(@Option(required = true) Long id) {
		service.markDone(id);
		System.out.println("# Task "+id+" changed for \"done\" successfully!");
	}
}	
