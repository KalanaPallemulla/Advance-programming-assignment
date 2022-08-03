package com.assignment.gocheeta.controller;

import java.util.List;
import java.util.Map;
import java.util.Hashtable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.gocheeta.model.UserModel;
import com.assignment.gocheeta.services.UserService;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser" )
    public UserModel createUser(@RequestBody UserModel user){
       return userService.createUser(user);
    }

    @GetMapping("/getUsers")
    public List<UserModel> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/getUser/{id}")
    public UserModel getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteUser(@PathVariable Long id){
        boolean deleted = false;
        deleted = userService.deleteUser(id);
        Map<String,Boolean> response = new Hashtable<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }


}
