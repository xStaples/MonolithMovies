package com.revature.repository;

import java.util.List;

import com.revature.model.User;

public interface UserRepository {

  void save(User user);
  
  void update(User user);

  void delete(User user);
  
  List<User> findAll();

  User findByUsername(String username);

  User findById(int id);
  
}
