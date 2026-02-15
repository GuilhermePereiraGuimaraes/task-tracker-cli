package com.example.tasktracker.model.dtos;

import java.time.OffsetDateTime;

import com.example.tasktracker.model.enums.Status;

public record TaskDTO(
		Long id,
		String description,
		Status status,
		OffsetDateTime createdAt,
		OffsetDateTime updatedAt
		) {}
