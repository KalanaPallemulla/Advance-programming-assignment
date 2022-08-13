package com.assignment.gocheeta.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.assignment.gocheeta.entity.UserEntity;
import com.assignment.gocheeta.model.User;
import com.assignment.gocheeta.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User createUser(User user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userRepository.save(userEntity);
        return user;
    }


    @Override
    public List<User> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<User> users = userEntities.stream().map(user -> new User(user.getId(),user.getName(),user.getEmail(),user.getPassword())).collect(Collectors.toList());
        return users;
    }


    @Override
    public User getUser(Long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        User user = new User(userEntity.getId(), userEntity.getName(), userEntity.getEmail(), userEntity.getPassword());
        return user;
    }


    @Override
    public boolean deleteUser(Long id) {
        UserEntity user = userRepository.findById(id).get();
        userRepository.delete(user);

        return true;
    }


    @Override
    public User updateUser(Long id, User user) {
        UserEntity ue = userRepository.findById(id).get();
        ue.setName(user.getName());
        ue.setEmail(user.getEmail());
        ue.setPassword(user.getPassword());
        userRepository.save(ue);
        return user;
    }


    @Override
    public User findUser(String email) {
        UserEntity ue = userRepository.findByEmail(email);
        User user = new User(ue.getId(),ue.getName(),ue.getEmail(),ue.getPassword());
        return user;
    }


    
    
}
