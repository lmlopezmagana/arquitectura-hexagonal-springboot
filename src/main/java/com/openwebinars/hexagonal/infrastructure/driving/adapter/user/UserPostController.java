package com.openwebinars.hexagonal.infrastructure.driving.adapter.user;

import com.openwebinars.hexagonal.application.model.User;
import com.openwebinars.hexagonal.application.usecase.user.create.CreateUserUseCase;
import com.openwebinars.hexagonal.infrastructure.driving.dto.user.UserRequest;
import com.openwebinars.hexagonal.infrastructure.driving.dto.user.UserResponse;
import com.openwebinars.hexagonal.infrastructure.driving.mapper.UserInMapper;
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
        User u = createUserUseCase.create(UserInMapper.toCommand(userRequest));
        return ResponseEntity.status(201).body(UserInMapper.toDto(u));
    }

}
