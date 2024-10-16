package com.openwebinars.hexagonal.task.infrastructure.web.dto;

public record TaskEditRequest(String title, String description, boolean complete) {
}
