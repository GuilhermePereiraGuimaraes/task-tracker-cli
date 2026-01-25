package com.example.tasktracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tasktracker.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

}
