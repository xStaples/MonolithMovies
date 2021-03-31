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
import com.revature.movie.models.Cast;
import com.revature.movie.repository.CastRepository;

@CrossOrigin
@RestController
@RequestMapping("/castmembers")
public class CastController {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private CastRepository castRepository;
	
	@GetMapping("/allcast")
	public List<Cast> getAllCast() {
		log.info("<>------------- Inside getAllCast(...)");
		return castRepository.findAll();
	}
	
	@PostMapping("/addcast")
	public Cast createCast(@RequestBody Cast cst) {
		log.info("<>------------- Inside createCast(...)");
		return castRepository.save(cst);
	}
	
	@GetMapping("/getcast/{id}")
	public ResponseEntity<Cast> getCastById(@PathVariable Integer id) {
		log.info("<>------------- Inside getCastById(...) :: "+id);
		Cast cast = castRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cast ID not found: "+id)); 
		return ResponseEntity.ok(cast);
	}	
	
	@PostMapping("/updatecast/{id}")
	public ResponseEntity<Cast> updateCast(@PathVariable Integer id,
													@RequestBody Cast cst){
		log.info("<>------------- Inside updateCast(...):: "+id);
		Cast cast = castRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cast ID not found: "+id)); 

		cast.setActor(cst.getActor());
		cast.setRole(cst.getRole());

	
		//update cast
		cast = castRepository.save(cast);
		
		return ResponseEntity.ok(cast);	
	}
	
	@DeleteMapping("/deletecast/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCast(@PathVariable Integer id) {
		log.info("<>------------- Inside deleteCast(...):: "+id);
		Cast cast = castRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Cast ID not found: "+id)); 
		
		castRepository.delete(cast);
		 Map<String, Boolean> deleteMap = new HashMap<>(); 
		 
		 deleteMap.put("deleted", Boolean.TRUE);
		 
		 return ResponseEntity.ok(deleteMap);
	}

}
