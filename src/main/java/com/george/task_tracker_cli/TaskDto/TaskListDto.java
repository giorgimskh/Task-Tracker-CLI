package com.george.task_tracker_cli.TaskDto;

import java.util.List;
import java.util.UUID;

public record TaskListDto(
        UUID id,
        String Title,
        String description,
        Integer count,
        double progress,
        List<TaskDto> tasks
) {
}
