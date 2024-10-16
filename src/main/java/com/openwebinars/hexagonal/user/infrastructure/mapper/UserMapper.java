package com.openwebinars.hexagonal.user.infrastructure.mapper;

import com.openwebinars.hexagonal.user.application.create.CreateUserCommand;
import com.openwebinars.hexagonal.user.domain.model.User;
import com.openwebinars.hexagonal.user.domain.model.UserId;
import com.openwebinars.hexagonal.user.infrastructure.db.entity.UserEntity;
import com.openwebinars.hexagonal.user.infrastructure.db.entity.UserRole;
import com.openwebinars.hexagonal.user.infrastructure.web.dto.UserRequest;
import com.openwebinars.hexagonal.user.infrastructure.web.dto.UserResponse;

public class UserMapper {

    public static UserEntity toPersistence(User user) {
        return UserEntity.builder()
                .id(user.getId() != null ? user.getId().getValue() : null)
                .email(user.getEmail())
                .name(user.getName())
                .password(user.getPassword())
                .role(UserRole.of(user.getRole()))
                .build();
    }

    public static User toDomain(UserEntity user) {
        return User.builder()
                .id(UserId.of(user.getId()))
                .email(user.getEmail())
                .name(user.getName())
                .password(user.getPassword())
                .role(user.getRole().toString())
                .build();
    }

    public static UserResponse toDto(User u) {
        return new UserResponse(u.getId().getValue(), u.getName(), u.getEmail(), u.getRole());
    }

    public static CreateUserCommand toCommand(UserRequest request) {
        return new CreateUserCommand(request.name(), request.email(), request.password());
    }



}
