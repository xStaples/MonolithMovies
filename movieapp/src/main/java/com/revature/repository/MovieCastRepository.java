package com.revature.repository;

import java.util.List;

import com.revature.model.MovieCast;

public interface MovieCastRepository {

  void save(MovieCast cast);
  
  void update(MovieCast cast);

  void delete(MovieCast cast);
  
  List<MovieCast> findAll();

  MovieCast findByRole(String role);

  MovieCast findByActor(String actor);

  MovieCast findById(int id);
  
}