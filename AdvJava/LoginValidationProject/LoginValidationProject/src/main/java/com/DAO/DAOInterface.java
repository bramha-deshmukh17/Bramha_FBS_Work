package com.DAO;

import com.bean.userPojo;

public interface DAOInterface {
	
	public int InsertData(userPojo u); 
	public boolean RetriveData(String username);
	public String UpdatePassword(userPojo u);
//	public void ForgetPassword();
	public boolean DeleteData(userPojo u);
		
	

}
