package com.capg.inventory.beans;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


 

import lombok.Data;

 

@Data
@Entity
@Table(name = "user_Info")
public class UserBean {

    @Column(name = "first_name")
    private String userFirstName;
    @Column(name = "last_name")
    private String userLastName;
    @Column(name = "email")
    private String userEmail;
    @Column(name = "mobile", unique = true)
    private long mobileNumber;
    @Id
    @Column(name = "user_Id") 
    private String userId;
    @Column(name = "user_Password")
    private String userPassword;
    @Column(name = "role")
    private String userRole;

 

}
