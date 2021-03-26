package com.revature.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.revature.model.Details;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("detailsRepository")
@Transactional
public class DetailsRepositoryImpl implements DetailsRepository{

  private static Logger logger = Logger.getLogger(DetailsRepositoryImpl.class);

  @Autowired
  private SessionFactory sessionFactory;

  public DetailsRepositoryImpl() {
    logger.trace("Injection session factory bean");
  }

  @Override
  public void save(Details details) {
    sessionFactory.getCurrentSession().save(details);
    
  }

  @Override
  public void update(Details details) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void delete(Details details) {
    // TODO Auto-generated method stub
    
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Details> findAll() {
    return sessionFactory.getCurrentSession().createCriteria(Details.class).list();
  }

  @Override
  public Details findByGenre(String genre) {
    try {
      return (Details) sessionFactory.getCurrentSession().createCriteria(Details.class).add(Restrictions.like("genre", genre)).list().get(0);
    } catch (IndexOutOfBoundsException e) {
      logger.debug(e);
      return null;
    }
  }

  @Override
  public Details findByDirector(String director) {
    try {
      return (Details) sessionFactory.getCurrentSession().createCriteria(Details.class).add(Restrictions.like("director", director)).list().get(0);
    } catch (IndexOutOfBoundsException e) {
      logger.debug(e);
      return null;
    }
  }

  @Override
  public Details findById(int id) {
    // TODO Auto-generated method stub
    return null;
  }
  
}
