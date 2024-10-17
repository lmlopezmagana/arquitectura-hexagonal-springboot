package com.openwebinars.hexagonal.infrastructure.inbound.api.dto.task;


public record TaskRequest(
        String title, String description) {
}
