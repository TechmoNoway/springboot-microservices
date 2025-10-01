package com.trikynguci.userservice.service.impl;

import com.trikynguci.userservice.dto.UserDto;
import com.trikynguci.userservice.model.User;
import com.trikynguci.userservice.repository.UserRepository;
import com.trikynguci.userservice.service.UserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Cacheable(value = "allUsers")
    public List<User> getAllUsers() {
        System.out.println("Querying DB...");
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }
}
