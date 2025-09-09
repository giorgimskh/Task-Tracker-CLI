package com.george.task_tracker_cli.Services.Impl;

import com.george.task_tracker_cli.Repositories.TaskListRepository;
import com.george.task_tracker_cli.Services.TaskListService;
import com.george.task_tracker_cli.domain.entities.TaskList;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        if(null!=taskList.getId()){
            throw new IllegalArgumentException("Task list already has an ID!");
        }
        if(null==taskList.getTitle() || taskList.getTitle().isBlank()){
            throw new IllegalArgumentException("Task list title is required!");
        }

        LocalDateTime now = LocalDateTime.now();

        return taskListRepository.save(new TaskList(
                null,
                taskList.getTitle(),
                taskList.getDescription(),
                null,
                now,
                now
        ));

    }


}
