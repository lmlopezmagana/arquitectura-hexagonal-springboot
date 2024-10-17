package com.openwebinars.hexagonal.application.ports.driven;

import com.openwebinars.hexagonal.application.model.Task;
import com.openwebinars.hexagonal.application.model.TaskId;
import com.openwebinars.hexagonal.application.model.UserId;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    Task save(Task task);
    List<Task> getAll();
    Optional<Task> getById(TaskId id);
    void delete(TaskId id);
    List<Task> getByUserId(UserId id);

}