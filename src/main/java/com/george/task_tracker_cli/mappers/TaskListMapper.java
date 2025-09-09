package com.george.task_tracker_cli.mappers;

import com.george.task_tracker_cli.domain.TaskDto.TaskListDto;
import com.george.task_tracker_cli.domain.entities.TaskList;

public interface TaskListMapper {
    TaskList fromDto(TaskListDto taskListDto);
    TaskListDto toDto (TaskList taskList);
}
