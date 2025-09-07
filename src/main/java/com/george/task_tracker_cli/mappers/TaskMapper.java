package com.george.task_tracker_cli.mappers;

import com.george.task_tracker_cli.domain.TaskDto.TaskDto;
import com.george.task_tracker_cli.domain.entities.Task;

public interface TaskMapper {
    Task fromDto(TaskDto dto);
    TaskDto toDto(TaskDto dto);
}
