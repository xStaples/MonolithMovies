package com.revature.movie.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.movie.model.User;

@Repository("userRepository")
@Transactional
public class UserRepositoryImpl implements UserRepository {

  private static Logger logger = Logger.getLogger(UserRepositoryImpl.class);

  @Autowired
  private SessionFactory sessionFactory;

  public UserRepositoryImpl() {
    logger.trace("Injection session factory bean");
  }


  @Override
  public void save(User user) {
    sessionFactory.getCurrentSession().save(user);
  }

  @Override
  public void update(User user) {
    
    
  }

  @Override
  public void delete(User user) {
    // TODO Auto-generated method stub
    
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<User> findAll() {
    return sessionFactory.getCurrentSession().createCriteria(User.class).list();
  }

  @Override
  public User findByUsername(String username) {
    try {
      return (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.like("username", username)).list().get(0);
    } catch (IndexOutOfBoundsException e) {
      logger.debug(e);
      return null;
    }
  }

  @Override
  public User findById(int id) {
    // TODO Auto-generated method stub
    return null;
  }
  

}
