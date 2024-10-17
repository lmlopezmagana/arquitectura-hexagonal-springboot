package com.openwebinars.hexagonal.infrastructure.driving.dto.user;


public record UserRequest(
        String email, String name, String password) {
}
