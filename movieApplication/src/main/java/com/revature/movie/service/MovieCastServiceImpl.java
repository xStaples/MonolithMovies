package com.revature.movie.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.movie.model.MovieCast;
import com.revature.movie.repository.MovieCastRepository;

@Service("movieCastService")
public class MovieCastServiceImpl implements MovieCastService{

  private Logger logger = Logger.getLogger(MovieCastServiceImpl.class);

  @Autowired
  private MovieCastRepository movieCastRepository;

  public MovieCastServiceImpl() {
    logger.trace("Injection using Autowired MovieCast Repository in MovieCastServiceImpl");
  }

  @Override
  public boolean registerCast(MovieCast cast) {
    movieCastRepository.save(cast);
    return cast.getId() != 0;
  }

  @Override
  public List<MovieCast> getAllCast() {
    return movieCastRepository.findAll();
  }

  @Override
  public MovieCast getMovieCastById(int id) {
    return movieCastRepository.findById(id);
  }


  
}
