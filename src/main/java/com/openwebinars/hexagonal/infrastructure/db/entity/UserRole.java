package com.openwebinars.hexagonal.infrastructure.db.entity;

import lombok.extern.java.Log;

public enum UserRole {
    USER, ADMIN;

    public static UserRole of(String role) {

        try {
            return UserRole.valueOf(role);
        } catch (IllegalArgumentException e) {
            return USER;
        }

    }

}
