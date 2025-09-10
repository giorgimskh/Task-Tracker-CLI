package com.george.task_tracker_cli.domain.dto;

import com.george.task_tracker_cli.domain.entities.TaskPriority;
import com.george.task_tracker_cli.domain.entities.TaskStatus;

import java.time.LocalDate;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDate dueDate,
        TaskPriority priority,
        TaskStatus status) {
}
