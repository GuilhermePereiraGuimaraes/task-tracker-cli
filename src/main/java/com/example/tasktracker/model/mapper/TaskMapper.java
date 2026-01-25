package com.example.tasktracker.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.example.tasktracker.model.Task;
import com.example.tasktracker.model.dtos.CreateTaskDTO;
import com.example.tasktracker.model.dtos.TaskDTO;
import com.example.tasktracker.model.dtos.UpdateTaskDTO;

@Mapper(
		componentModel = "spring",
		nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
		)
public interface TaskMapper {
	
	TaskDTO toDTO (Task task);
	
	@Mapping(target = "id", ignore = true)
	Task toEntity(CreateTaskDTO dto);
	
	void updateEntityFromDTO(UpdateTaskDTO dto, @MappingTarget Task task);
}
