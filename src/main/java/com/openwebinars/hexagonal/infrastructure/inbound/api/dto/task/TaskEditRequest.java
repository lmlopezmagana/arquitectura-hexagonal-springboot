package com.openwebinars.hexagonal.infrastructure.inbound.api.dto.task;

public record TaskEditRequest(String title, String description, boolean complete) {
}
