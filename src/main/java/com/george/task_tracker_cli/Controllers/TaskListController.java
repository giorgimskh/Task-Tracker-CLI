package com.george.task_tracker_cli.Controllers;

import com.george.task_tracker_cli.Services.TaskListService;
import com.george.task_tracker_cli.domain.dto.TaskListDto;
import com.george.task_tracker_cli.domain.entities.TaskList;
import com.george.task_tracker_cli.mappers.TaskListMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/task-lists")
public class TaskListController {
    private final TaskListService taskListService;
    private final TaskListMapper taskListMappers;

    public TaskListController(TaskListService taskListService, TaskListMapper taskListMappers1) {
        this.taskListService = taskListService;
        this.taskListMappers = taskListMappers1;

    }

    @GetMapping
    public List<TaskListDto> listTaskLists() {
        return taskListService.listTaskLists()
                .stream()
                .map(taskListMappers::toDto).toList();
    }

    @PostMapping
    public TaskListDto createTaskList(@RequestBody TaskListDto taskListDto) {
        TaskList createdTaskList = taskListService.createTaskList(taskListMappers.fromDto(taskListDto));
        return taskListMappers.toDto(createdTaskList);
    }

    @GetMapping(path = "/{task_list_id}/tasks")
    public Optional<TaskListDto> getTaskList(@PathVariable("task_list_id")UUID taskListId) {
        return taskListService.getTaskList(taskListId)
                .map(taskListMappers::toDto);
    }
}
