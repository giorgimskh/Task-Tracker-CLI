package com.george.task_tracker_cli.Services.Impl;

import com.george.task_tracker_cli.Repositories.TaskRepository;
import com.george.task_tracker_cli.Services.TaskService;
import com.george.task_tracker_cli.domain.entities.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> ListTasks(UUID taskListId) {
        return taskRepository.findByTaskListId(taskListId);
    }
}
