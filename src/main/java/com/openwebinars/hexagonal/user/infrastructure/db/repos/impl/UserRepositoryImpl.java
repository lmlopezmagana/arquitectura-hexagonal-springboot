package com.openwebinars.hexagonal.user.infrastructure.db.repos.impl;

import com.openwebinars.hexagonal.user.domain.model.User;
import com.openwebinars.hexagonal.user.domain.model.UserId;
import com.openwebinars.hexagonal.user.domain.repository.UserRepository;
import com.openwebinars.hexagonal.user.infrastructure.db.entity.UserEntity;
import com.openwebinars.hexagonal.user.infrastructure.db.repos.jpa.UserEntityRepositoryJpa;
import com.openwebinars.hexagonal.user.infrastructure.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserEntityRepositoryJpa userEntityRepositoryJpa;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User create(User user) {
        UserEntity entity = UserMapper.toPersistence(user);
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return UserMapper.toDomain(userEntityRepositoryJpa.save(entity));
    }

    @Override
    public User update(User user) {
        UserEntity entity = UserMapper.toPersistence(user);
        return UserMapper.toDomain(userEntityRepositoryJpa.save(entity));
    }

    @Override
    public Optional<User> changePassword(UserId id, String newPassword) {
        Optional<UserEntity> entity = userEntityRepositoryJpa.findById(id.getValue())
                .map(u -> {
                    u.setPassword(passwordEncoder.encode(newPassword));
                    return userEntityRepositoryJpa.save(u);
                });

        return entity.map(UserMapper::toDomain);

    }

    @Override
    public Optional<User> getById(UserId id) {
        return userEntityRepositoryJpa.findById(id.getValue())
                .map(UserMapper::toDomain);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return userEntityRepositoryJpa.findByEmail(email)
                .map(UserMapper::toDomain);
    }

    @Override
    public List<User> getByIds(Iterable<UserId> ids) {

        List<UUID> uuids = StreamSupport.stream(ids.spliterator(), false)
                .map(UserId::getValue)
                .toList();

        return userEntityRepositoryJpa.findAllById(uuids)
                .stream()
                .map(UserMapper::toDomain)
                .toList();
    }


}
