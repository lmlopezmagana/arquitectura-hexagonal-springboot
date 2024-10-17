package com.openwebinars.hexagonal.infrastructure.driving.dto.task;

public record TaskEditRequest(String title, String description, boolean complete) {
}
