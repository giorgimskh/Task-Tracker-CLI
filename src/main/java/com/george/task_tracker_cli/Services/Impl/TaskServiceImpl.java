package com.george.task_tracker_cli.Services.Impl;

import com.george.task_tracker_cli.Repositories.TaskListRepository;
import com.george.task_tracker_cli.Repositories.TaskRepository;
import com.george.task_tracker_cli.Services.TaskService;
import com.george.task_tracker_cli.domain.entities.Task;
import com.george.task_tracker_cli.domain.entities.TaskList;
import com.george.task_tracker_cli.domain.entities.TaskPriority;
import com.george.task_tracker_cli.domain.entities.TaskStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskListRepository taskListRepository;

    public TaskServiceImpl(TaskRepository taskRepository, TaskListRepository taskListRepository) {
        this.taskRepository = taskRepository;
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<Task> ListTasks(UUID taskListId) {
        return taskRepository.findByTaskListId(taskListId);
    }

    @Override
    public Task createTask(UUID taskListId, Task task) {
        if(null!=task.getId()){
            throw new IllegalArgumentException("Task  already has an ID!");
        }
        if(null==task.getTitle() || task.getTitle().isEmpty()){
            throw new IllegalArgumentException("Task  must have a title!");
        }
        TaskPriority taskPriority = Optional.ofNullable(task.getPriority()).orElse(TaskPriority.MEDIUM);
        TaskStatus taskStatus = TaskStatus.OPEN;


        TaskList taskList = taskListRepository.findById(taskListId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid task ID"));

        LocalDateTime dateTime = LocalDateTime.now();

        Task taskToSave = new Task(
                null,
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                taskStatus,
                taskPriority,
                dateTime,
                dateTime,
                taskList
        );

        return taskRepository.save(taskToSave);
    }
}
