package com.george.task_tracker_cli.Services.Impl;

import com.george.task_tracker_cli.Repositories.TaskListRepository;
import com.george.task_tracker_cli.Services.TaskListService;
import com.george.task_tracker_cli.domain.entities.TaskList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskListServiceImpl implements TaskListService {

    private final TaskListRepository taskListRepository;

    public TaskListServiceImpl(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }


    @Override
    public List<TaskList> listTaskLists() {
        return taskListRepository.findAll();
    }

    @Override
    public TaskList createTaskList(TaskList taskList) {
        return null;
    }


}
