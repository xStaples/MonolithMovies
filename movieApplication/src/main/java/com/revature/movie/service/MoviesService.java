package com.revature.movie.service;

import java.util.List;

import com.revature.movie.model.Movies;

public interface MoviesService {

  public boolean registerMovie(Movies movie);
  
  public List<Movies> getAllMovies();

  public Movies getMovie(String moviename);
  
  
}
