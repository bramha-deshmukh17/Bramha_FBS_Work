package com.serviceimpl;

import com.aspect.ObjectCreater;
import com.services.UserService;
import com.DAO.UserDAO;
import com.bean.User;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDAO userDAO = ObjectCreater.createObject("userDAO", UserDAO.class);

    @Override
    public boolean registerUser(User user) {
        return userDAO.registerUser(user);
    }

    @Override
    public User loginUser(String email, String password) {
        return userDAO.loginUser(email, password);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    @Override
    public boolean deleteUser(int id) {
        return userDAO.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }
}