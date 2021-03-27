package com.revature.movie.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.movie.model.User;
import com.revature.movie.repository.UserRepository;

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
