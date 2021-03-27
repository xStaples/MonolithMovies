package com.revature.movie.repository;

import java.util.List;

import com.revature.movie.model.Reviews;

public interface ReviewsRepository {
  
  void save (Reviews review);

  void update (Reviews review);

  void delete (Reviews review);

  List<Reviews> findAll();

  Reviews findById();
}
