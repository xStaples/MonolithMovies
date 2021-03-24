package com.revature.service;

import java.util.List;

import com.revature.model.MovieCast;

public interface MovieCastService {

  public boolean registerCast(MovieCast cast);

  public List<MovieCast> getAllCast();
  
  public MovieCast getMovieCastById(int id);
}
