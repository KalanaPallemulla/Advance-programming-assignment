package com.assignment.gocheeta.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.assignment.gocheeta.entity.UserEntity;
import com.assignment.gocheeta.model.UserModel;
import com.assignment.gocheeta.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserModel createUser(UserModel user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userRepository.save(userEntity);
        return user;
    }


    @Override
    public List<UserModel> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserModel> users = userEntities.stream().map(user -> new UserModel(user.getId(),user.getEmail(),user.getName(),user.getPassword())).collect(Collectors.toList());
        return users;
    }


    @Override
    public UserModel getUser(Long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        UserModel user = new UserModel(userEntity.getId(), userEntity.getName(), userEntity.getEmail(), userEntity.getPassword());
        return user;
    }


    @Override
    public boolean deleteUser(Long id) {
        UserEntity user = userRepository.findById(id).get();
        userRepository.delete(user);

        return true;
    }



    
    
}
