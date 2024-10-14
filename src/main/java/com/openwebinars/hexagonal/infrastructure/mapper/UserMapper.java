package com.openwebinars.hexagonal.infrastructure.mapper;

import com.openwebinars.hexagonal.domain.model.User;
import com.openwebinars.hexagonal.domain.model.UserId;
import com.openwebinars.hexagonal.infrastructure.db.entity.UserEntity;
import com.openwebinars.hexagonal.infrastructure.db.entity.UserRole;

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



}
