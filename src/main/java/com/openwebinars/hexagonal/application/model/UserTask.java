package com.openwebinars.hexagonal.application.model;

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
