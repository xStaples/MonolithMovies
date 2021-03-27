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
import com.revature.movie.models.Details;
import com.revature.movie.repository.DetailsRepository;

@CrossOrigin
@RestController
@RequestMapping("/moviedetails")
public class DetailsController {

	protected final Log log = LogFactory.getLog(getClass());

	@Autowired
	private DetailsRepository detailsRepository;
	
	@GetMapping("/details")
	public List<Details> getAllDetails() {
		log.info("<>------------- Inside getAllDetails(...)");
		return detailsRepository.findAll();
	}	
	
	@PostMapping("/adddetails")
	public Details createDetails(@RequestBody Details dts) {
		log.info("<>------------- Inside createDetails(...)");
		return detailsRepository.save(dts);
	}
	
	@GetMapping("/getdetails/{id}")
	public ResponseEntity<Details> getDetailsById(@PathVariable Integer id) {
		log.info("<>------------- Inside getDetailsById(...) :: "+id);
		Details details = detailsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Details ID not found: "+id)); 
		return ResponseEntity.ok(details);
	}	
	
	@PostMapping("/updatedetails/{id}")
	public ResponseEntity<Details> updateDetails(@PathVariable Integer id,
													@RequestBody Details dts){
		log.info("<>------------- Inside updateDetails(...):: "+id);
		Details details = detailsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Details ID not found: "+id)); 

		details.setGenre(dts.getGenre());
		details.setDirector(dts.getDirector());
		
		//update details
		details = detailsRepository.save(details);
		
		return ResponseEntity.ok(details);	
	}
	
	@DeleteMapping("/deletedetails/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDetails(@PathVariable Integer id) {
		log.info("<>------------- Inside deleteDetails(...):: "+id);
		Details details = detailsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Details ID not found: "+id)); 
		
		detailsRepository.delete(details);
		 Map<String, Boolean> deleteMap = new HashMap<>(); 
		 
		 deleteMap.put("deleted", Boolean.TRUE);
		 
		 return ResponseEntity.ok(deleteMap);
	}
}
