package com.capg.inventory.dao;

import com.capg.inventory.beans.UserBean;

public interface UserDAO {

	 public boolean registerUser(UserBean userBean);
	    
	    public UserBean userLogin(String userId, String userPassword);
	    
	    public boolean registerByAdmin(UserBean userBean);
	    
	    	
}
