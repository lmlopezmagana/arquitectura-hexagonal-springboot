package com.openwebinars.hexagonal.application.usecase.user.find;

import com.openwebinars.hexagonal.domain.error.UserNotFoundException;
import com.openwebinars.hexagonal.domain.model.User;
import com.openwebinars.hexagonal.domain.model.UserId;
import com.openwebinars.hexagonal.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindUserUseCase {

    private final UserRepository userRepository;

    public User getById(UserId id) {
        return userRepository.getById(id)
                .orElseThrow(UserNotFoundException::new);

    }

    public List<User> getByIds(Iterable<UserId> ids) {
        List<User> result = userRepository.getByIds(ids);

        if (result.isEmpty()){
            throw  new UserNotFoundException();
        }

        return result;

    }





}
