package com.openwebinars.hexagonal.infrastructure.web.dto.task;

import java.time.LocalDateTime;

public record TaskResponse(Long id, String title, String description, LocalDateTime createdAt, boolean completed) {

}
