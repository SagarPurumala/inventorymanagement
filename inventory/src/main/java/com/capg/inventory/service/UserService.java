package com.capg.inventory.service;

import com.capg.inventory.beans.UserBean;

public interface UserService {
	
	  public boolean registerUser(UserBean userBean);

	    public UserBean userLogin(String userId, String userPassword);
	    
	    public boolean registerByAdmin(UserBean userBean);

}
