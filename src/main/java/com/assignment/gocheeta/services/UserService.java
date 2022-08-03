package com.assignment.gocheeta.services;

import java.util.List;

import com.assignment.gocheeta.model.UserModel;

public interface UserService {

    UserModel createUser(UserModel user);

    List<UserModel> getAllUsers();

    UserModel getUser(Long id);

    boolean deleteUser(Long id);
    
}
