package com.revature.movie.repository;

import java.util.List;

import com.revature.movie.model.Details;

public interface DetailsRepository {
  
  void save (Details details);

  void update (Details details);
  
  void delete (Details details);

  List<Details> findAll();
  
  Details findByGenre(String genre);

  Details findByDirector(String director);

  Details findById(int id);


}
