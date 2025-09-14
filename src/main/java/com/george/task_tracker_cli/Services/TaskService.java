package com.george.task_tracker_cli.Services;

import com.george.task_tracker_cli.domain.entities.Task;
import com.george.task_tracker_cli.domain.entities.TaskList;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    List<Task> ListTasks(UUID taskListId);
    Task createTask(UUID taskListId,Task task);
}
