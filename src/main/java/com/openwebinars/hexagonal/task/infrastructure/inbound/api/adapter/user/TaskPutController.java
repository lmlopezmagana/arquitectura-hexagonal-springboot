package com.openwebinars.hexagonal.task.infrastructure.inbound.api.adapter.user;


import com.openwebinars.hexagonal.task.application.service.edit.CompleteTaskUseCase;
import com.openwebinars.hexagonal.task.application.service.edit.EditTaskUseCase;
import com.openwebinars.hexagonal.task.application.model.Task;
import com.openwebinars.hexagonal.task.application.model.TaskId;
import com.openwebinars.hexagonal.task.infrastructure.inbound.api.mapper.TaskMapper;
import com.openwebinars.hexagonal.task.infrastructure.inbound.api.dto.TaskEditRequest;
import com.openwebinars.hexagonal.task.infrastructure.inbound.api.dto.TaskResponse;
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
        return TaskMapper.toResponse(t);
    }

    @PutMapping("/{id}")
    public TaskResponse editTask(@PathVariable Long id, @RequestBody TaskEditRequest taskEditRequest) {
        Task t = editTaskUseCase
                .update(TaskMapper.toCommand(id, taskEditRequest));
        return TaskMapper.toResponse(t);
    }

}
