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
import com.revature.movie.models.Reviews;
import com.revature.movie.repository.ReviewsRepository;

@CrossOrigin
@RestController
@RequestMapping("/reviews")
public class ReviewsController {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private ReviewsRepository reviewsRepository;
	
	@GetMapping("/allreviews")
	public List<Reviews> getAllReviews() {
		log.info("<>------------- Inside getAllUsers(...)");
		return reviewsRepository.findAll();
	}
	
	@PostMapping("/addreviews")		//will handle http post request
	public Reviews createReview(@RequestBody Reviews rvw) {
		log.info("<>------------- Inside createUser(...)");
		return reviewsRepository.save(rvw);
	}
	
	@GetMapping("/getreview/{id}")
	public ResponseEntity<Reviews> getReviewsById(@PathVariable Integer id) {
		log.info("<>------------- Inside getUserById(...) :: "+id);
		Reviews reviews = reviewsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Review ID not found: "+id)); 
		return ResponseEntity.ok(reviews);
	}	
	
	@PostMapping("/updatereview/{id}")
	public ResponseEntity<Reviews> updateReview(@PathVariable Integer id, 
				   									@RequestBody Reviews rvw) {
	log.info("<>------------- Inside updateUser(...):: "+id);
	Reviews reviews = reviewsRepository.findById(id)
	.orElseThrow(() -> new ResourceNotFoundException("User ID not found: "+id)); 
	
	reviews.setReviewScore(rvw.getReviewScore());
	reviews.setReviewText(rvw.getReviewText());

	
	//update user
	reviews = reviewsRepository.save(reviews);
	
	return ResponseEntity.ok(reviews);		
	}	
	
	@DeleteMapping("/deletereview/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Integer id) {
		log.info("<>------------- Inside deleteUser(...):: "+id);
		Reviews reviews = reviewsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User ID not found: "+id)); 
		
		reviewsRepository.delete(reviews);
		 Map<String, Boolean> deleteMap = new HashMap<>(); 
		 
		 deleteMap.put("deleted", Boolean.TRUE);
		 
		 return ResponseEntity.ok(deleteMap);
	}	
}
