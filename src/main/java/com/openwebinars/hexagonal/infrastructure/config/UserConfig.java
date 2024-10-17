package com.openwebinars.hexagonal.infrastructure.config;

import com.openwebinars.hexagonal.application.usecase.user.create.CreateUserUseCase;
import com.openwebinars.hexagonal.application.usecase.user.find.FindUserUseCase;
import com.openwebinars.hexagonal.application.ports.out.UserRepository;
import com.openwebinars.hexagonal.infrastructure.outbound.adapter.UserRepositoryImpl;
import com.openwebinars.hexagonal.infrastructure.outbound.db.repos.UserEntityRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class UserConfig {

    private final UserEntityRepositoryJpa userEntityRepositoryJpa;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public UserRepository userRepositoryJpa() {
        return new UserRepositoryImpl(userEntityRepositoryJpa, passwordEncoder);
    }

    @Bean
    public CreateUserUseCase createUserUseCase() {
        return new CreateUserUseCase(userRepositoryJpa());
    }

    @Bean
    public FindUserUseCase findUserUseCase() {
        return new FindUserUseCase(userRepositoryJpa());
    }

}

