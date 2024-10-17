package com.openwebinars.hexagonal.infrastructure.inbound.api.dto.user;

import java.util.UUID;

public record UserResponse(UUID id, String name, String email, String role) {
}
