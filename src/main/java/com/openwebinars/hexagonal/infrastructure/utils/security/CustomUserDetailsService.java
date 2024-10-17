package com.openwebinars.hexagonal.infrastructure.utils.security;

import com.openwebinars.hexagonal.application.ports.driven.UserRepository;
import com.openwebinars.hexagonal.infrastructure.utils.security.model.AuthUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.getByEmail(username)
                .map(AuthUser::of)
                .orElseThrow(() -> new UsernameNotFoundException("No user with email %s".formatted(username)));
    }
}
