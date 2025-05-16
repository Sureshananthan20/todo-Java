package com.example.ToDo_app.service;

import com.example.ToDo_app.model.Task;
import com.example.ToDo_app.model.User;
import com.example.ToDo_app.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepo;

    public Task addTask(Task task) {
        return taskRepo.save(task);
    }

    public List<Task> getTasksByUser(User user) {
        return taskRepo.findByUser(user);
    }

    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }

    public Task toggleCompleted(Long id) {
        Task task = taskRepo.findById(id).orElse(null);
        if (task != null) {
            task.setCompleted(!task.isCompleted());
            return taskRepo.save(task);
        }
        return null;
    }
}
