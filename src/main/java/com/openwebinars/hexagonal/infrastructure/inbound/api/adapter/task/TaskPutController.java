package com.openwebinars.hexagonal.infrastructure.inbound.api.adapter.task;


import com.openwebinars.hexagonal.application.usecase.task.edit.CompleteTaskUseCase;
import com.openwebinars.hexagonal.application.usecase.task.edit.EditTaskUseCase;
import com.openwebinars.hexagonal.application.model.Task;
import com.openwebinars.hexagonal.application.model.TaskId;
import com.openwebinars.hexagonal.infrastructure.inbound.api.dto.task.TaskEditRequest;
import com.openwebinars.hexagonal.infrastructure.inbound.api.dto.task.TaskResponse;
import com.openwebinars.hexagonal.infrastructure.inbound.api.mapper.TaskInMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskPutController {

    private final EditTaskUseCase editTaskUseCase;
    private final CompleteTaskUseCase completeTaskUseCase;

    @PutMapping("/{id}/complete")
    public TaskResponse completeTask(@PathVariable Long id) {
        Task t = completeTaskUseCase.completeTask(TaskId.of(id));
        return TaskInMapper.toResponse(t);
    }

    @PutMapping("/{id}")
    public TaskResponse editTask(@PathVariable Long id, @RequestBody TaskEditRequest taskEditRequest) {
        Task t = editTaskUseCase
                .update(TaskInMapper.toCommand(id, taskEditRequest));
        return TaskInMapper.toResponse(t);
    }

}
