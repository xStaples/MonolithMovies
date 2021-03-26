package com.revature.controller;

import static com.revature.util.ClientMessageUtil.REGISTRATION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.SOMETHING_WRONG;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.ajax.ClientMessage;
import com.revature.model.User;
import com.revature.service.UserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("userController")
@CrossOrigin(origins = "http://localhost:52742")
public class UserControllerImpl {

  private Logger log = Logger.getLogger(UserController.class);
  
  @Autowired
  private UserService userService;

  @PostMapping("/registerUser") // localhost:8080/SpringMVC/register
  public @ResponseBody ClientMessage registerUser(@RequestBody User user) {
    log.info("inside register User");
    // remember that our registerHero method returns a boolean, so we can use a ternary operator
    return (userService.registerUser(user)) ? REGISTRATION_SUCCESSFUL : SOMETHING_WRONG;
  }

  @GetMapping("/findAllUsers")
  public @ResponseBody List<User> findAllUsers() {
    return userService.getAllUsers();
  }

  @PostMapping("/findUser")
  public @ResponseBody User findUser(@RequestBody User user, HttpServletRequest request) {
    request.getSession();
    return userService.getUser(user.getFirstName());
  }

  
}
