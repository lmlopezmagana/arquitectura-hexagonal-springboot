package com.openwebinars.hexagonal.user.infrastructure.web.dto;


public record UserRequest(
        String email, String name, String password) {
}
