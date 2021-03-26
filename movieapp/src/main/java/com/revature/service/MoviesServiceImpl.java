package com.revature.service;

import java.util.List;

import com.revature.model.Movies;
import com.revature.repository.MoviesRepository;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("moviesService")
public class MoviesServiceImpl implements MoviesService{

  private Logger logger = Logger.getLogger(MoviesServiceImpl.class);

  @Autowired
  private MoviesRepository moviesRepository;

  public MoviesServiceImpl() {
    logger.trace("Injection using Autowired Movies Repository in MoviesServiceImpl");
  }

  @Override
  public boolean registerMovie(Movies movie) {
    moviesRepository.save(movie);
    return movie.getId() != 0;
  }

  @Override
  public List<Movies> getAllMovies() {
    return moviesRepository.findAll();
  }

  @Override
  public Movies getMovie(String moviename) {
    return moviesRepository.findByMovieName(moviename);
  }
  
}
