package com.example.tasktracker.model.dtos;

import com.example.tasktracker.model.enums.Status;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateTaskDTO(
		@NotBlank
		String description,
		
		@NotNull
		Status status){}
