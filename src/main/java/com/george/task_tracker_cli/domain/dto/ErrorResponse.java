package com.george.task_tracker_cli.domain.dto;

public record ErrorResponse(
    int status,
    String message,
    String details
){
}
