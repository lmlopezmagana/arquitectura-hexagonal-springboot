package com.openwebinars.hexagonal.task.application.service.find;

import com.openwebinars.hexagonal.user.application.find.FindUserUseCase;
import com.openwebinars.hexagonal.task.application.model.Task;
import com.openwebinars.hexagonal.task.application.model.TaskId;
import com.openwebinars.hexagonal.task.application.model.UserTask;
import com.openwebinars.hexagonal.user.domain.model.User;
import com.openwebinars.hexagonal.user.domain.model.UserId;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class FindTaskService {

    private final FindTaskUseCase findTaskUseCase;
    private final FindUserUseCase findUserUseCase;


    public UserTask findByTaskId(TaskId id) {
        Task t = findTaskUseCase.findById(id);
        User u = findUserUseCase.getById(t.getAuthor());
        return new UserTask(u,t);
    }

    public List<UserTask> findAll() {

        List<Task> tasks = findTaskUseCase.findAll();

        // En caso de no encontrar a alguno de los autores
        // lo dejamos como null

        List<UserId> authorsId = tasks.stream()
                .map(Task::getAuthor)
                .distinct()
                .toList();

        Map<UserId, List<User>> authors = findUserUseCase.getByIds(authorsId)
                .stream()
                .collect(Collectors.groupingBy(User::getId));

        return tasks.stream()
                .map(t -> new UserTask(authors.get(t.getAuthor()).get(0), t))
                .toList();

    }






}

