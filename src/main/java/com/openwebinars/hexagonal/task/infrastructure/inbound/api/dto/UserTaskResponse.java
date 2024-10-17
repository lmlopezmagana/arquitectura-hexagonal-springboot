package com.openwebinars.hexagonal.task.infrastructure.inbound.api.dto;

import com.openwebinars.hexagonal.user.infrastructure.web.dto.UserResponse;

import java.time.LocalDateTime;

public record UserTaskResponse(Long id, String title, String description, LocalDateTime createdAt, boolean completed, UserResponse author) {
}
