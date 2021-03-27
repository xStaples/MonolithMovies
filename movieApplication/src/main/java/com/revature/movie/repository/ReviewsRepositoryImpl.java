package com.revature.movie.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.movie.model.Reviews;

@Repository("reviewsRepository")
@Transactional
public class ReviewsRepositoryImpl implements ReviewsRepository {

  private static Logger logger = Logger.getLogger(ReviewsRepositoryImpl.class);

  @Autowired
  private SessionFactory sessionFactory;

  public ReviewsRepositoryImpl() {
    logger.trace("Injection session factory bean");
  }


  @Override
  public void save(Reviews review) {
    sessionFactory.getCurrentSession().save(review);
    
  }

  @Override
  public void update(Reviews review) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void delete(Reviews review) {
    // TODO Auto-generated method stub
    
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Reviews> findAll() {
    return sessionFactory.getCurrentSession().createCriteria(Reviews.class).list();
  }

  @Override
  public Reviews findById() {
    // TODO Auto-generated method stub
    return null;
  }
  
}
