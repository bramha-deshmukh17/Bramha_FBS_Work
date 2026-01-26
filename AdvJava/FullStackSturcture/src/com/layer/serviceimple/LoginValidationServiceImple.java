package com.layer.serviceimple;

import com.layer.bean.User;
import com.layer.daoimpl.DAOImpl;
import com.layer.service.LoginValidationService;

public class LoginValidationServiceImple implements LoginValidationService {
	
     User u;
     DAOImpl dao=new DAOImpl(); 

	@Override
	public void createUser(String username, String password)
	{
		u=new User(username,password);
		dao.insertUser(u);
	}

	@Override
	public boolean validateUser(String username, String password) 
	{
		boolean flag=false;
		flag=dao.retriveData(username);
		
		return flag;
	}

}
