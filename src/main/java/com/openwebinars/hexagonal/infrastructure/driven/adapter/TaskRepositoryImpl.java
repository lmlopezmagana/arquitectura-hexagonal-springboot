package com.openwebinars.hexagonal.infrastructure.driven.adapter;

import com.openwebinars.hexagonal.application.model.Task;
import com.openwebinars.hexagonal.application.model.TaskId;
import com.openwebinars.hexagonal.application.model.UserId;
import com.openwebinars.hexagonal.application.ports.driven.TaskRepository;
import com.openwebinars.hexagonal.infrastructure.driven.db.entity.TaskEntity;
import com.openwebinars.hexagonal.infrastructure.driven.db.repos.TaskEntityRepositoryJpa;
import com.openwebinars.hexagonal.infrastructure.driven.mapper.TaskOutMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class TaskRepositoryImpl implements TaskRepository {

    private final TaskEntityRepositoryJpa taskEntityRepositoryJpa;

    @Override
    public Task save(Task task) {
        TaskEntity entity = TaskOutMapper.toPersistence(task);
        return TaskOutMapper.toDomain(taskEntityRepositoryJpa.save(entity));
    }

    @Override
    public List<Task> getAll() {
        return taskEntityRepositoryJpa.findAll()
                .stream()
                .map(TaskOutMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Task> getById(TaskId id) {
        return taskEntityRepositoryJpa.findById(id.getValue())
                .map(TaskOutMapper::toDomain);
    }

    @Override
    public void delete(TaskId id) {
        taskEntityRepositoryJpa.deleteById(id.getValue());
    }

    @Override
    public List<Task> getByUserId(UserId id) {
        return taskEntityRepositoryJpa.findByAuthor(id.getValue())
                .stream()
                .map(TaskOutMapper::toDomain)
                .toList();

    }

}
