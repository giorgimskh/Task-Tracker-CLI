package com.george.task_tracker_cli.mappers.impl;

import com.george.task_tracker_cli.domain.TaskDto.TaskDto;
import com.george.task_tracker_cli.domain.entities.Task;
import com.george.task_tracker_cli.mappers.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task fromDto(TaskDto dto) {
        return new Task(
                dto.id(),
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.status(),
                dto.priority(),
                null,
                null,
                null
                );
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getTaskPriority(),
                task.getStatus()
        );
    }
}
