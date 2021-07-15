package com.ecomm.dao;

import com.ecomm.entity.UserDetail;
public interface UserDAO {
	
	
	public  boolean registerUser(UserDetail user);
	public UserDetail getUser(String username);
	public boolean updateUserDetails(UserDetail user);
		
	}
	


