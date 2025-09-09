package com.george.task_tracker_cli.Repositories;

import com.george.task_tracker_cli.domain.entities.Task;
import com.george.task_tracker_cli.domain.entities.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
    List<Task> findByTaskList(TaskList taskList);
    Optional<Task> findByTaskListAndId(UUID taskListId, UUID id);
}
