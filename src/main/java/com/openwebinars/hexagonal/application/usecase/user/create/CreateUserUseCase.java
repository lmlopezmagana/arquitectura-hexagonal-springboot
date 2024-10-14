package com.openwebinars.hexagonal.application.usecase.user.create;

import com.openwebinars.hexagonal.domain.model.User;
import com.openwebinars.hexagonal.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateUserUseCase {

    private final UserRepository userRepository;

    public User create(CreateUserCommand command) {
        User u = User.builder()
                .name(command.name())
                .email(command.email())
                .password(command.password())
                .build();

        return userRepository.create(u);
    }





}
