package com.george.task_tracker_cli.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="task_lists")

public class TaskList {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    @Column(name="id",updatable=false,nullable=false)
    private UUID id;

    @Column(name="title",nullable=false)
    private String title;

    @Column(name="description")
    private String description;

    @OneToMany(mappedBy = "taskList",cascade={
            CascadeType.REMOVE,CascadeType.PERSIST}
    )
    protected List<Task> tasks;

    @Column(name="created",nullable=false)
    private LocalDateTime created;

    @Column(name="updated",nullable=false)
    private LocalDateTime updated;

    public TaskList() {
    }

    public TaskList(UUID id, String title, String description, List<Task> tasks, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.tasks = tasks;
        this.created = created;
        this.updated = updated;
    }
}
