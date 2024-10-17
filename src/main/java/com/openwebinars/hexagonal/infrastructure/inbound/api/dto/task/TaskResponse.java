package com.openwebinars.hexagonal.infrastructure.inbound.api.dto.task;

import com.openwebinars.hexagonal.application.model.UserId;

import java.time.LocalDateTime;

public record TaskResponse(Long id, String title, String description, LocalDateTime createdAt, boolean completed, UserId author) {

}
