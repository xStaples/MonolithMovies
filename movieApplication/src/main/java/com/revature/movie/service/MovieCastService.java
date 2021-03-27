package com.revature.movie.service;

import java.util.List;

import com.revature.movie.model.MovieCast;

public interface MovieCastService {

  public boolean registerCast(MovieCast cast);

  public List<MovieCast> getAllCast();
  
  public MovieCast getMovieCastById(int id);
}
