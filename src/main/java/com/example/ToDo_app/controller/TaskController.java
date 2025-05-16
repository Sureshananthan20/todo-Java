package com.example.ToDo_app.controller;

import com.example.ToDo_app.model.Task;
import com.example.ToDo_app.model.User;
import com.example.ToDo_app.service.TaskService;
import com.example.ToDo_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @GetMapping("/user/{username}")
    public List<Task> getTasksByUser(@PathVariable String username) {
        User user = userService.login(username, ""); // Simplified, needs proper auth
        return taskService.getTasksByUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @PutMapping("/toggle/{id}")
    public Task toggleCompleted(@PathVariable Long id) {
        return taskService.toggleCompleted(id);
    }
}
