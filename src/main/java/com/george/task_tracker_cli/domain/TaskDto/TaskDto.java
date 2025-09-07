package com.george.task_tracker_cli.domain.TaskDto;

import com.george.task_tracker_cli.domain.entities.TaskList;
import com.george.task_tracker_cli.domain.entities.TaskPriority;
import com.george.task_tracker_cli.domain.entities.TaskStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(
        UUID id, String title,
        String description,
        LocalDate dueDate,
        TaskPriority priority,
        TaskStatus status,
        TaskList taskList,
        LocalDateTime created,
        LocalDateTime updated) {
}
