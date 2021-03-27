package com.revature.movie.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.movie.model.Movies;

@Repository("moviesRepository")
@Transactional
public class MoviesRepositoryImpl implements MoviesRepository {

  private static Logger logger = Logger.getLogger(MoviesRepositoryImpl.class);


  @Autowired
  private SessionFactory sessionFactory;


  public MoviesRepositoryImpl() {
    logger.trace("Injection session factory bean");
  }

  @Override
  public void save(Movies movie) {
    sessionFactory.getCurrentSession().save(movie);
    
  }

  @Override
  public void update(Movies movie) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void delete(Movies movie) {
    // TODO Auto-generated method stub
    
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Movies> findAll() {
    return sessionFactory.getCurrentSession().createCriteria(Movies.class).list();
  }

  @Override
  public Movies findByMovieName(String movieName) {
    try {
      return (Movies) sessionFactory.getCurrentSession().createCriteria(Movies.class).add(Restrictions.like("movieName", movieName)).list().get(0);
    } catch (IndexOutOfBoundsException e) {
      logger.debug(e);
      return null;
    }
  }

  @Override
  public Movies findById(int id) {
    // TODO Auto-generated method stub
    return null;
  }
  
}
