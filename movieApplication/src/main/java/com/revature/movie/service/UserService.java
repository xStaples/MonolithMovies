package com.revature.movie.service;

import java.util.List;

import com.revature.movie.model.User;

public interface UserService {

  public boolean registerUser(User user);

  public List<User> getAllUsers();

  public User getUser(String username);
  
}
