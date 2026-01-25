package com.example.tasktracker.model.dtos;

import java.time.OffsetDateTime;

public record TaskDTO(
		Long id,
		String description,
		Boolean done,
		OffsetDateTime createdAt,
		OffsetDateTime updatedAt
		) {}
