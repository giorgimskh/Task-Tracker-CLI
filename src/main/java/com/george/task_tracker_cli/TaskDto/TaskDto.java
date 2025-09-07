package com.george.task_tracker_cli.TaskDto;

import com.george.task_tracker_cli.domain.entities.TaskPriority;
import com.george.task_tracker_cli.domain.entities.TaskStatus;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record TaskDto(UUID id, String title, String description, LocalDateTime dueDate, TaskPriority priority, TaskStatus status) implements Serializable {

}
