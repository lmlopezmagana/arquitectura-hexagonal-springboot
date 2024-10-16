package com.openwebinars.hexagonal.task.application.create;

import com.openwebinars.hexagonal.user.application.find.FindUserUseCase;
import com.openwebinars.hexagonal.task.domain.model.Task;
import com.openwebinars.hexagonal.user.domain.model.User;
import com.openwebinars.hexagonal.task.domain.model.UserTask;
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
