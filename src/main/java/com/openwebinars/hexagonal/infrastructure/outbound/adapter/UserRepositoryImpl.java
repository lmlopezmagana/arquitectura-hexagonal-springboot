package com.openwebinars.hexagonal.infrastructure.outbound.adapter;

import com.openwebinars.hexagonal.application.model.User;
import com.openwebinars.hexagonal.application.model.UserId;
import com.openwebinars.hexagonal.application.ports.out.UserRepository;
import com.openwebinars.hexagonal.infrastructure.outbound.db.entity.UserEntity;
import com.openwebinars.hexagonal.infrastructure.outbound.db.repos.UserEntityRepositoryJpa;
import com.openwebinars.hexagonal.infrastructure.outbound.mapper.UserOutMapper;
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
        UserEntity entity = UserOutMapper.toPersistence(user);
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return UserOutMapper.toDomain(userEntityRepositoryJpa.save(entity));
    }

    @Override
    public User update(User user) {
        UserEntity entity = UserOutMapper.toPersistence(user);
        return UserOutMapper.toDomain(userEntityRepositoryJpa.save(entity));
    }

    @Override
    public Optional<User> changePassword(UserId id, String newPassword) {
        Optional<UserEntity> entity = userEntityRepositoryJpa.findById(id.getValue())
                .map(u -> {
                    u.setPassword(passwordEncoder.encode(newPassword));
                    return userEntityRepositoryJpa.save(u);
                });

        return entity.map(UserOutMapper::toDomain);

    }

    @Override
    public Optional<User> getById(UserId id) {
        return userEntityRepositoryJpa.findById(id.getValue())
                .map(UserOutMapper::toDomain);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return userEntityRepositoryJpa.findByEmail(email)
                .map(UserOutMapper::toDomain);
    }

    @Override
    public List<User> getByIds(Iterable<UserId> ids) {

        List<UUID> uuids = StreamSupport.stream(ids.spliterator(), false)
                .map(UserId::getValue)
                .toList();

        return userEntityRepositoryJpa.findAllById(uuids)
                .stream()
                .map(UserOutMapper::toDomain)
                .toList();
    }


}
