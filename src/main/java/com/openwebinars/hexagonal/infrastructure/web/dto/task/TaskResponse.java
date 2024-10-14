package com.openwebinars.hexagonal.infrastructure.web.dto.task;

import com.openwebinars.hexagonal.domain.model.UserId;

import java.time.LocalDateTime;

public record TaskResponse(Long id, String title, String description, LocalDateTime createdAt, boolean completed, UserId author) {

}
