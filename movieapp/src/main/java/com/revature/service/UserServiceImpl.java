package com.revature.service;

import java.util.List;

import com.revature.model.User;
import com.revature.repository.UserRepository;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

  private Logger logger = Logger.getLogger(UserServiceImpl.class);

  @Autowired
  private UserRepository userRepository;

  public UserServiceImpl() {
    logger.trace("Injection using Autowired User Repository in UserServiceImpl");
  }

  @Override
  public boolean registerUser(User user) {
    userRepository.save(user);
    return user.getId() != 0;
  }

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public User getUser(String username) {
    return userRepository.findByUsername(username);
  }
  
}
