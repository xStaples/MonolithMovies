package com.revature.service;

import java.util.List;

import com.revature.model.UserType;

public interface UserTypeService {

  public boolean registerUserType(UserType usertype);
  
  public List<UserType> getAllUserTypes();
  
  public UserType getUserType(String type);
}
