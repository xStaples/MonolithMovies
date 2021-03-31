package com.revature.movie.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.revature.movie.exceptions.ResourceNotFoundException;
import com.revature.movie.models.UserType;
import com.revature.movie.repository.UserTypeRepository;

@CrossOrigin
@RestController
@RequestMapping("/usertypes")
public class UserTypeController {
			
		protected final Log log = LogFactory.getLog(getClass());
		
		@Autowired
		private UserTypeRepository userTypeRepository;
		
		/*
		 * Get all usertypes
		 * Postman Test: Get, URL: http://localhost:8080/movieusers/usertypes
		 */
		@GetMapping("/usertype")
		public List<UserType> getAllUserTypes() {
			log.info("<>------------- Inside getAllUserTypes(...)");
			return userTypeRepository.findAll();
		}
		
		@PostMapping("/addusertype")
		public UserType createUserType(@RequestBody UserType usertype) {
			log.info("<>---------------- Inside createUserType(...)");
			return userTypeRepository.save(usertype);
		}
		
		@GetMapping("/getUserType/{id}")
		public ResponseEntity<UserType> getUserTypeById(@PathVariable Integer id) {
			log.info("<>--------- Inside getUserTypeById(...) :: "+id);
			UserType usertype = userTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("UserType ID not found: "+id));
			return ResponseEntity.ok(usertype);
		}
		
		@PostMapping("/updateusertype/{id}")
		public ResponseEntity<UserType> updateUserType(@PathVariable Integer id, 
																@RequestBody UserType usrtype) {
			log.info("<>------------ Inside updateUserType(...) :: "+id);
			UserType usertype = userTypeRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("UserType ID not found: "+id));
			
			usertype.setType(usertype.getType());
			
			usertype = userTypeRepository.save(usertype);
			
			return ResponseEntity.ok(usertype);
		}
		
		@DeleteMapping("/deleteuser/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteUserType(@PathVariable Integer id) {
			log.info("<>----------------- nside deleteUserType(...) :: "+id);
			UserType usertype = userTypeRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("UserType ID not found: "+id));
			
			userTypeRepository.delete(usertype);
			Map<String, Boolean> deleteMap = new HashMap<>();
			
			deleteMap.put("deleted", Boolean.TRUE);
			
			return ResponseEntity.ok(deleteMap);
						
		}
		
	
}
