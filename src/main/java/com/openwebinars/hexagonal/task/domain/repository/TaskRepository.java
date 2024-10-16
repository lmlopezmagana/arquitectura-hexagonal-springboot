package com.openwebinars.hexagonal.task.domain.repository;

import com.openwebinars.hexagonal.task.domain.model.Task;
import com.openwebinars.hexagonal.task.domain.model.TaskId;
import com.openwebinars.hexagonal.user.domain.model.UserId;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    Task save(Task task);
    List<Task> getAll();
    Optional<Task> getById(TaskId id);
    void delete(TaskId id);
    List<Task> getByUserId(UserId id);

}