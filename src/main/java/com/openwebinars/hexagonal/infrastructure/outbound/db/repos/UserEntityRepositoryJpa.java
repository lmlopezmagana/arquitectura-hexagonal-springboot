package com.openwebinars.hexagonal.infrastructure.outbound.db.repos;

import com.openwebinars.hexagonal.infrastructure.outbound.db.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserEntityRepositoryJpa extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByEmail(String email);

}
