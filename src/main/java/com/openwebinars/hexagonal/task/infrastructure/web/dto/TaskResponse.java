package com.openwebinars.hexagonal.task.infrastructure.web.dto;

import com.openwebinars.hexagonal.user.domain.model.UserId;

import java.time.LocalDateTime;

public record TaskResponse(Long id, String title, String description, LocalDateTime createdAt, boolean completed, UserId author) {

}
