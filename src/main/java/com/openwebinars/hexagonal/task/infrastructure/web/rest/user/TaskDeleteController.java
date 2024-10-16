package com.openwebinars.hexagonal.task.infrastructure.web.rest.user;

import com.openwebinars.hexagonal.task.application.delete.DeleteTaskUseCase;
import com.openwebinars.hexagonal.task.domain.model.TaskId;
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
