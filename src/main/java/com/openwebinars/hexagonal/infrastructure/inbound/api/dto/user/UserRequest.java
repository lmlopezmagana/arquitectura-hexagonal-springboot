package com.openwebinars.hexagonal.infrastructure.inbound.api.dto.user;


public record UserRequest(
        String email, String name, String password) {
}
