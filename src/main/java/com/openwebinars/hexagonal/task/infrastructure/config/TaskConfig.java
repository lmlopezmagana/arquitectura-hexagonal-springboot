package com.openwebinars.hexagonal.task.infrastructure.config;

import com.openwebinars.hexagonal.task.application.create.CreateTaskService;
import com.openwebinars.hexagonal.task.application.find.FindTaskService;
import com.openwebinars.hexagonal.task.application.create.CreateTaskUseCase;
import com.openwebinars.hexagonal.task.application.delete.DeleteTaskUseCase;
import com.openwebinars.hexagonal.task.application.edit.CompleteTaskUseCase;
import com.openwebinars.hexagonal.task.application.edit.EditTaskUseCase;
import com.openwebinars.hexagonal.task.application.find.FindTaskUseCase;
import com.openwebinars.hexagonal.user.application.find.FindUserUseCase;
import com.openwebinars.hexagonal.task.domain.repository.TaskRepository;
import com.openwebinars.hexagonal.task.infrastructure.db.repos.impl.TaskRepositoryImpl;
import com.openwebinars.hexagonal.task.infrastructure.db.repos.jpa.TaskEntityRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class TaskConfig {

    private final TaskEntityRepositoryJpa taskEntityRepositoryJpa;
    private final FindUserUseCase findUserUseCase;


    @Bean
    public TaskRepository taskRepositoryJpa() {
        return new TaskRepositoryImpl(taskEntityRepositoryJpa);
    }

    @Bean
    public CreateTaskUseCase createTaskUseCase() {
        return new CreateTaskUseCase(taskRepositoryJpa());
    }

    @Bean
    public FindTaskUseCase findTaskUseCase() {
        return new FindTaskUseCase(taskRepositoryJpa());
    }

    @Bean
    public CompleteTaskUseCase completeTaskUseCase() {
        return new CompleteTaskUseCase(taskRepositoryJpa());
    }

    @Bean
    public EditTaskUseCase editTaskUseCase() {
        return new EditTaskUseCase(taskRepositoryJpa());
    }

    @Bean
    public DeleteTaskUseCase deleteTaskUseCase() {
        return new DeleteTaskUseCase(taskRepositoryJpa());
    }

    @Bean
    public CreateTaskService createTaskService() {
        return new CreateTaskService(createTaskUseCase(), findUserUseCase);
    }

    @Bean
    public FindTaskService findTaskService() {
        return new FindTaskService(findTaskUseCase(), findUserUseCase);
    }
}
