package com.revature.service;

import java.util.List;

import com.revature.model.Movies;

public interface MoviesService {

  public boolean registerMovie(Movies movie);
  
  public List<Movies> getAllMovies();

  public Movies getMovie(String moviename);
  
  
}
