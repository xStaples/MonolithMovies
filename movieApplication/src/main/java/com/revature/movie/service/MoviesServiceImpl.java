package com.revature.movie.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.movie.model.Movies;
import com.revature.movie.repository.MoviesRepository;

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
