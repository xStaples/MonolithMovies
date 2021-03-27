package com.revature.movie.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.movie.model.MovieCast;

@Repository("movieCastRepository")
@Transactional
public class MovieCastRepositoryImpl implements MovieCastRepository{

  private static Logger logger = Logger.getLogger(MovieCastRepositoryImpl.class);

  @Autowired
  private SessionFactory sessionFactory;

  public MovieCastRepositoryImpl() {
    logger.trace("Injection session factory bean");
  }


  @Override
  public void save(MovieCast cast) {
    sessionFactory.getCurrentSession().save(cast);
    
  }

  @Override
  public void update(MovieCast cast) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void delete(MovieCast cast) {
    // TODO Auto-generated method stub
    
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<MovieCast> findAll() {
    return sessionFactory.getCurrentSession().createCriteria(MovieCast.class).list();
  }

  @Override
  public MovieCast findByRole(String role) {
    try {
      return (MovieCast) sessionFactory.getCurrentSession().createCriteria(MovieCast.class).add(Restrictions.like("role", role)).list().get(0);
    } catch (IndexOutOfBoundsException e) {
      logger.debug(e);
      return null;
    }
  }

  @Override
  public MovieCast findByActor(String actor) {
    try {
      return (MovieCast) sessionFactory.getCurrentSession().createCriteria(MovieCast.class).add(Restrictions.like("actor", actor)).list().get(0);
    } catch (IndexOutOfBoundsException e) {
      logger.debug(e);
      return null;
    }
  }

  @Override
  public MovieCast findById(int id) {
    // TODO Auto-generated method stub
    return null;
  }
  
}
