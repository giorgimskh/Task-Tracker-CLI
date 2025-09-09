package com.george.task_tracker_cli.Services;

import com.george.task_tracker_cli.domain.entities.TaskList;

import java.util.List;

public interface TaskListService {
    List<TaskList> listTaskLists();
    TaskList createTaskList(TaskList taskList);
}
