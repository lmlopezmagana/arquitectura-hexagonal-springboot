package com.openwebinars.hexagonal.shared.infrastructure.security;

import com.openwebinars.hexagonal.user.domain.repository.UserRepository;
import com.openwebinars.hexagonal.shared.infrastructure.security.model.AuthUser;
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
