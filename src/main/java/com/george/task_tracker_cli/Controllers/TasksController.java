package com.george.task_tracker_cli.Controllers;

import com.george.task_tracker_cli.Services.TaskService;
import com.george.task_tracker_cli.domain.dto.TaskDto;
import com.george.task_tracker_cli.mappers.TaskMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/task_list/{task_list_id}/tasks")
public class TasksController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TasksController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @GetMapping
    public List<TaskDto> ListTasks(@PathVariable("task_list_id") UUID taskListId) {
        return taskService.ListTasks(taskListId).stream().map(taskMapper::toDto).toList();
    }
}
