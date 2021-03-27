package com.revature.movie.repository;

import java.util.List;

import com.revature.movie.model.Movies;

public interface MoviesRepository {

  void save (Movies movie);

  void update (Movies movie);

  void delete (Movies movie);

  List<Movies> findAll();
  
  Movies findByMovieName(String movieName);

  Movies findById(int id);
  
}
