package com.abhishek.orm.Services;

import com.abhishek.orm.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    User updateUser(User user, int userId);

    User getUser(int userId);

    List<User> getAllUser();

    void deleteUser(int userId);
}
