package com.revature.movie.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.movie.ajax.ClientMessage;
import com.revature.movie.model.User;

public interface UserController {

  ClientMessage registerUser(User user);

  User findUser(User user, HttpServletRequest request);

  List<User> findAllUsers();

  
}
