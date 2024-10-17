package com.openwebinars.hexagonal.application.service;

import com.openwebinars.hexagonal.application.usecase.task.create.CreateTaskCommand;
import com.openwebinars.hexagonal.application.usecase.task.create.CreateTaskUseCase;
import com.openwebinars.hexagonal.application.usecase.user.find.FindUserUseCase;
import com.openwebinars.hexagonal.application.model.Task;
import com.openwebinars.hexagonal.application.model.User;
import com.openwebinars.hexagonal.application.model.UserTask;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateTaskService {

    private final CreateTaskUseCase createTaskUseCase;
    private final FindUserUseCase findUserUseCase;


    public UserTask createTask(CreateTaskCommand command) {

        // Validamos el usuario
        User u = findUserUseCase.getById(command.author());
        // Creamos la tarea
        Task t = createTaskUseCase.create(command);
        // Los devolvemos conjuntamente
        return new UserTask(u,t);

    }




}
