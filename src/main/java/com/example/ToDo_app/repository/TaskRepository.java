package com.example.ToDo_app.repository;

import com.example.ToDo_app.model.Task;
import com.example.ToDo_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
}
