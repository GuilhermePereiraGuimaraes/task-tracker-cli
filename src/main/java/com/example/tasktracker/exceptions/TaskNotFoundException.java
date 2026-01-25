package com.example.tasktracker.exceptions;

public class TaskNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public TaskNotFoundException() {
		super("Task não encontrada");
	}
	
	
}
