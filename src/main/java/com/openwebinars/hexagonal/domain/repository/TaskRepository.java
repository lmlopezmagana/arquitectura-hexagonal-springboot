package com.openwebinars.hexagonal.domain.repository;

import com.openwebinars.hexagonal.domain.model.Task;
import com.openwebinars.hexagonal.domain.model.TaskId;
import com.openwebinars.hexagonal.domain.model.UserId;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    Task save(Task task);
    List<Task> getAll();
    Optional<Task> getById(TaskId id);
    void delete(TaskId id);
    List<Task> getByUserId(UserId id);

}