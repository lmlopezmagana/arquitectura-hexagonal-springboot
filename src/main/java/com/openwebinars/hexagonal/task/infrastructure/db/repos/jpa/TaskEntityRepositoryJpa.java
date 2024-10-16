package com.openwebinars.hexagonal.task.infrastructure.db.repos.jpa;

import com.openwebinars.hexagonal.task.infrastructure.db.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TaskEntityRepositoryJpa extends JpaRepository<TaskEntity, Long> {

    List<TaskEntity> findByAuthor(UUID id);


}
