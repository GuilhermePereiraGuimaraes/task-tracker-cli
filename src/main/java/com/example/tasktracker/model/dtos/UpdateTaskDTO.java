package com.example.tasktracker.model.dtos;

import com.example.tasktracker.model.enums.Status;

public record UpdateTaskDTO(
		String description,
		Status status
		){}
