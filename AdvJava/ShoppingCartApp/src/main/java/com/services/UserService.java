package com.services;

import com.bean.User;
import java.util.List;

public interface UserService {
    boolean registerUser(User user);

    User loginUser(String email, String password);

    List<User> getAllUsers();

    User getUserById(int id);

    boolean deleteUser(int id);

    boolean updateUser(User user);
}