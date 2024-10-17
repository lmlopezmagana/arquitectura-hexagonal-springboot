package com.openwebinars.hexagonal.infrastructure.security.model;

import com.openwebinars.hexagonal.application.model.User;
import com.openwebinars.hexagonal.application.model.UserId;
import com.openwebinars.hexagonal.infrastructure.outbound.db.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthUser implements UserDetails {

    private UUID id;
    private String name;
    private String email;
    private String password;
    private UserRole role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_"+ role.toString()));
    }


    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    public UserId getIdAsUserId() {
        return UserId.of(id);
    }

    public static AuthUser of(User user) {
        return AuthUser.builder()
                .id(user.getId().getValue())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(UserRole.of(user.getRole()))
                .build();
    }

}
