package com.layer.dao;

import com.layer.bean.User;

//Hold CRUD operations
public interface DAOInterface 
{
    public void insertUser(User u);
    public boolean retriveData(String username);
}
