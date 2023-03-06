package com.training.usermanagementassignment.adapter.repository;

import com.training.usermanagementassignment.model.User;

import java.util.Optional;

public interface UserRepository {
    String save(User user);

    Optional<User> getById(String userID);

    Optional<User> update(String userId,User newUser);

    Optional<User>delete(String userId);
}
