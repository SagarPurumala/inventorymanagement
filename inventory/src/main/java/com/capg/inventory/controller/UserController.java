package com.capg.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.inventory.beans.UserBean;
import com.capg.inventory.response.InventoryResponse;
import com.capg.inventory.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    
    @Autowired
    private UserService service;
    
    InventoryResponse response = new InventoryResponse();
    
    @PostMapping("/registerUser")
    public InventoryResponse registerUser(@RequestBody UserBean userBean) {
        boolean isAdded = service.registerUser(userBean);
        if(isAdded) {
            response.setStatus(200);
            response.setMessage("Data is added successfully..");
        } else {
            response.setStatus(400);
            response.setMessage("Failed to add the data..");
        }
        return response;
    }//end of register
    

 

    @PostMapping("/registerByAdmin")
    public InventoryResponse registerByAdmin(@RequestBody UserBean userBean) {
        boolean isAdded = service.registerByAdmin(userBean);
        if(isAdded) {
            response.setStatus(200);
            response.setMessage("Data is added successfully..");
        } else {
            response.setStatus(400);
            response.setMessage("Failed to add the data..");
        }
        return response;
    }//end of register
    
    @PostMapping("/userLogin")
    public InventoryResponse userLogin(@RequestBody UserBean userBean) {
        String userId = userBean.getUserId();
        String userPassword = userBean.getUserPassword();            
        UserBean userBean2 = service.userLogin(userId, userPassword);
        String role = userBean2.getUserRole();
        String getUserId = userBean2.getUserId();
        if(role.equals("user")) {
            response.setStatus(200);
            response.setMessage("Success");
            response.setRole(role);
            response.setUserId(getUserId);
        }else if(role.equals("admin")) {
            response.setStatus(200);
            response.setMessage("Success");
            response.setRole(role);    
            response.setUserId(getUserId);
        }else if(role.equals("exe")) {
            response.setStatus(200);
            response.setMessage("Success");
            response.setRole(role);
            response.setUserId(getUserId);
        }else {
            response.setStatus(400);
            response.setMessage("Failed");
        }
        return response;
    }// end of userLogin()

 

    
}// end of controller class
