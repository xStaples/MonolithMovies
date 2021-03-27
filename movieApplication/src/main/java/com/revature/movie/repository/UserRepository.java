package com.revature.movie.repository;

import java.util.List;

import com.revature.movie.model.User;

public interface UserRepository {

  void save(User user);
  
  void update(User user);

  void delete(User user);
  
  List<User> findAll();

  User findByUsername(String username);

  User findById(int id);
  
}
