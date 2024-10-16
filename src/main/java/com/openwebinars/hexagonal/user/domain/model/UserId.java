package com.openwebinars.hexagonal.user.domain.model;

import lombok.Value;

import java.util.UUID;

@Value
public class UserId {

    UUID value;

    public static UserId of(UUID id) {
        return new UserId(id);
    }

    public static UserId of(String id) {
        return new UserId(UUID.fromString(id));
    }

}
