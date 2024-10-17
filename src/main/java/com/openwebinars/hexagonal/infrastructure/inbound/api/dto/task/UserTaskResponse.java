package com.openwebinars.hexagonal.infrastructure.inbound.api.dto.task;

import com.openwebinars.hexagonal.infrastructure.inbound.api.dto.user.UserResponse;

import java.time.LocalDateTime;

public record UserTaskResponse(Long id, String title, String description, LocalDateTime createdAt, boolean completed, UserResponse author) {
}
