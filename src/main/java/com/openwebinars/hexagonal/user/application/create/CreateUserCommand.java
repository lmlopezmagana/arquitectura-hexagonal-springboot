package com.openwebinars.hexagonal.user.application.create;

public record CreateUserCommand(String name, String email, String password) {
}
