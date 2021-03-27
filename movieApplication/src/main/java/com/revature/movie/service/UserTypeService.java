package com.revature.movie.service;

import java.util.List;

import com.revature.movie.model.UserType;

public interface UserTypeService {

  public boolean registerUserType(UserType usertype);
  
  public List<UserType> getAllUserTypes();
  
  public UserType getUserType(String type);
}
