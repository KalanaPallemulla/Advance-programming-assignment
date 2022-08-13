package com.assignment.gocheeta.services;

import java.util.List;
import java.util.Optional;

import com.assignment.gocheeta.model.User;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    User getUser(Long id);

    boolean deleteUser(Long id);

    User updateUser(Long id, User user);

    User findUser(String email);

}
