package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public Flux<Task> getAllTasks() {
        return repo.findAll();
    }

    public Mono<Task> getTaskById(Long id) {
        return repo.findById(id);
    }

    public Mono<Task> createTask(Task task) {
        return repo.save(task);
    }

    public Mono<Void> deleteTask(Long id) {
        return repo.deleteById(id);
    }
}
