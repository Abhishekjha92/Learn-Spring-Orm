package com.abhishek.orm.Services.impl;

import com.abhishek.orm.Services.UserService;
import com.abhishek.orm.entities.User;
import com.abhishek.orm.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    Logger logger = LoggerFactory.getLogger((UserServiceImpl.class));
    @Autowired
    private UserRepository userRepository;


    @Override
    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        logger.info("user saved: {}", savedUser.getId());
        return savedUser;
    }

    @Override
    public User updateUser(User user, int userId) {
        // 1:  user get from database
        User olduser = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User with given id not found"));
        olduser.setCity(user.getCity());
        olduser.setName(user.getName());
        olduser.setAge(user.getAge());
// rest of the details also be updated
        // 2: then update user
        User UpdatedUser = userRepository.save(olduser);
        return UpdatedUser;
    }

    //get single user with given id
    @Override
    public User getUser(int userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        User user = userOptional.orElseThrow(() -> new RuntimeException("user with given id not found"));
        return user;
    }

    /// to get all users
    @Override
    public List<User> getAllUser() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public void deleteUser(int userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User with given id not found"));
        userRepository.delete(user);
    }
}
