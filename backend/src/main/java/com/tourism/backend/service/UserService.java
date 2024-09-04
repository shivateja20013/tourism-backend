package com.tourism.backend.service;

import com.tourism.backend.dto.UserDTO;
import com.tourism.backend.entity.User;
import com.tourism.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserDTO userDTO){
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        User newUser = this.userRepository.save(user);
        return newUser;
    }

    public User authenticateUser(UserDTO userDTO){
        User user = this.userRepository.findUserByUsernameAndPasswordAndIsActive(userDTO.getUsername(), userDTO.getPassword(), true);
        user.setPassword(null);
        return user;
    }

    public List<User> getAllUsers(){
        List<User> userList = this.userRepository.findByIsActive(true);
        for (User user: userList) {
            user.setPassword(null);
        }
        return userList;
    }

    public User updateUser(UserDTO userDTO){
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        User newUser = this.userRepository.save(user);
        return newUser;
    }

    public User deleteUser(String username){
        User user = this.userRepository.findById(username).orElseThrow();
        user.setIsActive(false);
        return this.userRepository.save(user);
    }
}
