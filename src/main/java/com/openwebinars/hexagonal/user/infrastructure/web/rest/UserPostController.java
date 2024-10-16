package com.openwebinars.hexagonal.user.infrastructure.web.rest;

import com.openwebinars.hexagonal.user.application.create.CreateUserUseCase;
import com.openwebinars.hexagonal.user.domain.model.User;
import com.openwebinars.hexagonal.user.infrastructure.mapper.UserMapper;
import com.openwebinars.hexagonal.user.infrastructure.web.dto.UserRequest;
import com.openwebinars.hexagonal.user.infrastructure.web.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserPostController {

    private final CreateUserUseCase createUserUseCase;


    @PostMapping("/auth/register")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        User u = createUserUseCase.create(UserMapper.toCommand(userRequest));
        return ResponseEntity.status(201).body(UserMapper.toDto(u));
    }

}
