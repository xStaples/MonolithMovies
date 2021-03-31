/**
 * 
 */
package com.revature.movie.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.revature.movie.exceptions.ResourceNotFoundException;
import com.revature.movie.models.User;
import com.revature.movie.repository.UserRepository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author hectorv
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/movieusers") //This is pretty much standard
public class UserController {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private UserRepository userRepository;
	
	/*Get all users
	  Test in PostMan:: Select Get, URL: http://localhost:8080/movieusers/users 
	  Values must be displayed in a json format.
	*/
	@GetMapping("/users")
	public List<User> getAllUsers() {
		log.info("<>------------- Inside getAllUsers(...)");
		return userRepository.findAll();
	}
	
	/*Create user rest api
	  Test in PostMan:: Select Post, URL: http://localhost:8080/movieusers/adduser
	  Headers tab:: Key:Content-Type, Value: application/json
	  Body tab:: Select Raw, and paste the json values below
    	{
	        set user properties here
    	}	  
	  Click on send, then check user table.
	*/
	@PostMapping("/adduser")		//will handle http post request
	public User createUser(@RequestBody User user) {
		log.info("<>------------- Inside createUser(...)");
		return userRepository.save(user);
	}
	
	/*Get user by id rest api
	  Test in PostMan:: Select Get, URL: http://localhost:8080/movieusers/getUser/1 
	  1 is the id of the user
	*/
	@GetMapping("/getuser/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id) {
		log.info("<>------------- Inside getUserById(...) :: "+id);
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User ID not found: "+id)); 
		return ResponseEntity.ok(user);
	}	
	
	/*Update user rest api
	  Test in PostMan:: Select Put, URL: http://localhost:8080/movieusers/updateuser/4, 4 is the id of the user
	  Headers tab:: Key:Content-Type, Value: application/json
	  Body tab:: Select Raw, and paste the json values below
  		{
			set user properties here
  		}	  
	  Click on send, then check user table.
	*/
	@PostMapping("/updateuser/{id}") 
	public ResponseEntity<User> updateUser(@PathVariable Integer id, 
												   @RequestBody User usr) {
		log.info("<>------------- Inside updateUser(...):: "+id);
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User ID not found: "+id)); 

		user.setFirstName(usr.getFirstName());
		user.setLastName(usr.getLastName());
		user.setUsername(usr.getUsername());
		user.setPassword(usr.getPassword());
	
		//update user
		user = userRepository.save(user);
		
		return ResponseEntity.ok(user);		
	}	
	
	/*Delete user rest api
	  Test in PostMan:: Select Delete, URL: http://localhost:8080/movieusers/deleteuser/1 
	  1 is the id of the user to delete
	  Click on send, then check user table.
	*/
	@DeleteMapping("/deleteuser/{id}") 
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Integer id) {
		log.info("<>------------- Inside deleteUser(...):: "+id);
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User ID not found: "+id)); 
		
		userRepository.delete(user);
		 Map<String, Boolean> deleteMap = new HashMap<>(); 
		 
		 deleteMap.put("deleted", Boolean.TRUE);
		 
		 return ResponseEntity.ok(deleteMap);
	}	
	

	
//	@GetMapping("/userByName/{name}")
//	public ResponseEntity<User> getUserByName(@PathVariable String name) {
//		log.info("<>------------- Inside getUserByName(...) :: "+name);
//		User user = userRepository.findByName(name);
//		log.info("<>------------- The user :: "+user);
//		return ResponseEntity.ok(user);
//	}
	
	@GetMapping("/login/{username}/{password}")
	public ResponseEntity<User> findByUsername(@PathVariable String username, @PathVariable String password) {
		log.info("<>------------- Inside findByUsername(...)");
		User user =  userRepository.findByName(username);
		
		if(user!=null) {
			if(user.getPassword().equals(password)) {
				return ResponseEntity.ok(user);
			} else {
				System.out.println(user);
				return null;
			}
		} else {
		System.out.println(user);
		return null;
		}
	}
}
