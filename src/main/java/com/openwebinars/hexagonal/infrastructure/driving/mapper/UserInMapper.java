package com.openwebinars.hexagonal.infrastructure.driving.mapper;

import com.openwebinars.hexagonal.application.model.User;
import com.openwebinars.hexagonal.application.usecase.user.create.CreateUserCommand;
import com.openwebinars.hexagonal.infrastructure.driving.dto.user.UserRequest;
import com.openwebinars.hexagonal.infrastructure.driving.dto.user.UserResponse;

public class UserInMapper {

    public static UserResponse toDto(User u) {
        return new UserResponse(u.getId().getValue(), u.getName(), u.getEmail(), u.getRole());
    }

    public static CreateUserCommand toCommand(UserRequest request) {
        return new CreateUserCommand(request.name(), request.email(), request.password());
    }

}
