package com.revature.movie.repository;

import java.util.List;

import com.revature.movie.model.UserType;

public interface UserTypeRepository {

  void save(UserType usertype);
  
  void update(UserType usertype);

  void delete(UserType usertype);
  
  List<UserType> findAll();

  UserType findByType(String type);

  UserType findById(int id);
  
}
