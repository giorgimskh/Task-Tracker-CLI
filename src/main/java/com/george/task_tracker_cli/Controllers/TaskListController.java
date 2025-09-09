package com.george.task_tracker_cli.Controllers;

import com.george.task_tracker_cli.Repositories.TaskListRepository;
import com.george.task_tracker_cli.Services.TaskListService;
import com.george.task_tracker_cli.domain.TaskDto.TaskListDto;
import com.george.task_tracker_cli.domain.entities.Task;
import com.george.task_tracker_cli.domain.entities.TaskList;
import com.george.task_tracker_cli.mappers.TaskListMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/task-lists")
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
}
