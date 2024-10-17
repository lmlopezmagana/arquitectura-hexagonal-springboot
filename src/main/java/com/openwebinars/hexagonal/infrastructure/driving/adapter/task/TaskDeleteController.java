package com.openwebinars.hexagonal.infrastructure.driving.adapter.task;

import com.openwebinars.hexagonal.application.usecase.task.delete.DeleteTaskUseCase;
import com.openwebinars.hexagonal.application.model.TaskId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskDeleteController {

    private final DeleteTaskUseCase deleteTaskUseCase;

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        deleteTaskUseCase.deleteById(TaskId.of(id));
        return ResponseEntity.noContent().build();
    }

}
