package com.openwebinars.hexagonal.task.infrastructure.inbound.api.dto;

public record TaskEditRequest(String title, String description, boolean complete) {
}
