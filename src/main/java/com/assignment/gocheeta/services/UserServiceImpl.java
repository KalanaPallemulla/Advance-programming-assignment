package com.assignment.gocheeta.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.assignment.gocheeta.entity.User;
import com.assignment.gocheeta.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        User userEntity = new User();
        BeanUtils.copyProperties(user, userEntity);
        return userRepository.save(userEntity);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userEntities = userRepository.findAll();
        // List<UserEntity> users = userEntities.stream().map(user -> new
        // User(user.getId(),user.getName(),user.getEmail(),user.getPassword())).collect(Collectors.toList());
        return userEntities;
    }

    @Override
    public User getUser(Long id) {
        User userEntity = userRepository.findById(id).get();
        // User user = new User(userEntity.getId(), userEntity.getName(),
        // userEntity.getEmail(), userEntity.getPassword());
        return userEntity;
    }

    @Override
    public boolean deleteUser(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);

        return true;
    }

    @Override
    public User updateUser(Long id, User user) {
        User ue = userRepository.findById(id).get();
        ue.setName(user.getName());
        ue.setEmail(user.getEmail());
        ue.setPassword(user.getPassword());
        userRepository.save(ue);
        return user;
    }

    @Override
    public User findUser(String email) {
        User ue = userRepository.findByEmail(email);
        // User user = new User(ue.getId(),ue.getName(),ue.getEmail(),ue.getPassword());
        return ue;
    }

}
