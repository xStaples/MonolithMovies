/**
 * 
 */
package com.revature.movie.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.revature.movie.models.Movie;
import com.revature.movie.repository.MovieRepository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * @author hectorv
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/movie") //This is pretty much standard
public class MovieController {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private MovieRepository movieRepository;
	
	/*Get all movies
	  Test in PostMan:: Select Get, URL: http://localhost:8080/api/v1/movies 
	  Values must be displayed in a json format.
	*/
	@GetMapping("/movies")
	public List<Movie> getAllMovies() {
		log.info("<>------------- Inside getAllMovies(...)");
		return movieRepository.findAll();
	}
	
	/*Create movie rest api
	  Test in PostMan:: Select Post, URL: http://localhost:8080/api/v1/movies
	  Headers tab:: Key:Content-Type, Value: application/json
	  Body tab:: Select Raw, and paste the json values below
    	{
	        set movie properties here
    	}	  
	  Click on send, then check movie table.
	*/
	@PostMapping("/addmovie")		//will handle http post request
	public Movie createMovie(@RequestBody Movie movie) {
		log.info("<>------------- Inside createMovie(...)");
		return movieRepository.save(movie);
	}
	
	/*Get movie by id rest api
	  Test in PostMan:: Select Get, URL: http://localhost:8080/api/v1/movies/1 
	  1 is the id of the movie
	*/
	@GetMapping("/moviebyid/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
		log.info("<>------------- Inside getMovieById(...) :: "+id);
		Movie movie = movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie ID not found: "+id)); 
		return ResponseEntity.ok(movie);
	}	
	
	/*Update movie rest api
	  Test in PostMan:: Select Put, URL: http://localhost:8080/movie/movies/4, 4 is the id of the movie
	  Headers tab:: Key:Content-Type, Value: application/json
	  Body tab:: Select Raw, and paste the json values below
  		{
			set movie properties here
  		}	  
	  Click on send, then check movie table.
	*/
	@PostMapping("/updatemovie/{id}") 
	public ResponseEntity<Movie> updateMovie(@PathVariable Long id, 
												   @RequestBody Movie employhi) {
		log.info("<>------------- Inside updateMovie(...):: "+id);
		Movie movie = movieRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Movie ID not found: "+id)); 

		/*
		 set movie properties here 
		 * */
		
		//update movie
		movie = movieRepository.save(movie);
		
		return ResponseEntity.ok(movie);		
	}	
	
	/*Delete movie rest api
	  Test in PostMan:: Select Delete, URL: http://localhost:8080/api/v1/movies/1 
	  1 is the id of the movie to delete
	  Click on send, then check movie table.
	*/
	@DeleteMapping("/movies/{id}") 
	public ResponseEntity<Map<String, Boolean>> deleteMovie(@PathVariable Long id) {
		log.info("<>------------- Inside deleteMovie(...):: "+id);
		Movie movie = movieRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Movie ID not found: "+id)); 
		
		movieRepository.delete(movie);
		 Map<String, Boolean> deleteMap = new HashMap<>(); 
		 
		 deleteMap.put("deleted", Boolean.TRUE);
		 
		 return ResponseEntity.ok(deleteMap);
	}	

}
