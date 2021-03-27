package com.revature.movie.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.movie.model.UserType;

@Repository("userTypeRepository")
@Transactional
public class UserTypeRepositoryImpl implements UserTypeRepository {

  private static Logger logger = Logger.getLogger(UserTypeRepositoryImpl.class);

  @Autowired
  private SessionFactory sessionFactory;

  public UserTypeRepositoryImpl() {
    logger.trace("Injection session factory bean");
  }


  @Override
  public void save(UserType usertype) {
    sessionFactory.getCurrentSession().save(usertype);
    
  }

  @Override
  public void update(UserType usertype) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void delete(UserType usertype) {
    // TODO Auto-generated method stub
    
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<UserType> findAll() {
    return sessionFactory.getCurrentSession().createCriteria(UserType.class).list();

  }

  @Override
  public UserType findByType(String type) {
    try {
      return (UserType) sessionFactory.getCurrentSession().createCriteria(UserType.class).add(Restrictions.like("type", type)).list().get(0);
    } catch (IndexOutOfBoundsException e) {
      logger.debug(e);
      return null;
    }
  }

  @Override
  public UserType findById(int id) {
    // TODO Auto-generated method stub
    return null;
  }
  
}
