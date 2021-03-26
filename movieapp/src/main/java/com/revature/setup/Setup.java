package com.revature.setup;

import com.revature.model.User;
import com.revature.model.UserType;
import com.revature.service.UserService;
import com.revature.service.UserServiceImpl;
import com.revature.service.UserTypeService;
import com.revature.service.UserTypeServiceImpl;

public class Setup {

  public static void main(String[] args) {
    Setup.initialValues();
  }

  public static void initialValues() {

  
  UserTypeService utServ = new UserTypeServiceImpl();
  UserService uServ = new UserServiceImpl();

  UserType ut1 = new UserType ("Basic"); 
  User u1 = new User("chris", "yowpp", "pass", "user", ut1);

  utServ.registerUserType(ut1);
  uServ.registerUser(u1);
  
  
}
  
  
}
