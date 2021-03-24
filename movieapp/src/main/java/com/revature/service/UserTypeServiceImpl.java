package com.revature.service;

import java.util.List;

import com.revature.model.UserType;
import com.revature.repository.UserTypeRepository;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userTypeService")
public class UserTypeServiceImpl implements UserTypeService{

  private Logger logger = Logger.getLogger(UserTypeServiceImpl.class);

  @Autowired
  private UserTypeRepository userTypeRepository;

  public UserTypeServiceImpl() {
    logger.trace("Injection using Autowired UserType Repository in UserTypeServiceImpl");
  }

  @Override
  public boolean registerUserType(UserType usertype) {
    userTypeRepository.save(usertype);
    return usertype.getId() != 0;
  }

  @Override
  public List<UserType> getAllUserTypes() {
    return userTypeRepository.findAll();
  }

  @Override
  public UserType getUserType(String type) {
    return userTypeRepository.findByType(type);
  }
  
}
