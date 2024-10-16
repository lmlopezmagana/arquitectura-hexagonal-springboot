package com.openwebinars.hexagonal.task.domain.model;

import com.openwebinars.hexagonal.user.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserTask {

    private User user;
    private Task task;

}
