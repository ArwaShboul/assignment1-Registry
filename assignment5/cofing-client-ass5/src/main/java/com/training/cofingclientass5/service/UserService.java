package com.training.usermanagementassignment.service;

import com.training.usermanagementassignment.adapter.repository.UserRepository;
import com.training.usermanagementassignment.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String register(User user){

        return  userRepository.save(user);
    }
    public Optional<User> findById(String userId){
        return userRepository.getById(userId);
    }
    public Optional<User> updateUserData(String id,User newUser){
        return userRepository.update(id, newUser);
    }

    public Optional<User> deleteUser(String userId){
        return userRepository.delete(userId);
    }

}
