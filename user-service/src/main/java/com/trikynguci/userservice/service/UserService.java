package com.trikynguci.userservice.service;

import com.trikynguci.userservice.dto.UserDto;
import com.trikynguci.userservice.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User createUser(User user);
    UserDto getUserById(Long id);
}
