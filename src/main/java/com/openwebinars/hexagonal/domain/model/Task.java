package com.openwebinars.hexagonal.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class Task {

    @Setter(AccessLevel.NONE)
    private TaskId id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private boolean completed;
    private UserId author;


    public void taskCompleted() {
        this.completed = true;
    }


}

