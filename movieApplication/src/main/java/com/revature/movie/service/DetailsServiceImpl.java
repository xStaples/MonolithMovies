package com.revature.movie.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.movie.model.Details;
import com.revature.movie.repository.DetailsRepository;

@Service("detailsService")
public class DetailsServiceImpl implements DetailsService {

  private Logger logger = Logger.getLogger(DetailsServiceImpl.class);

  @Autowired
  private DetailsRepository detailsRepository;

  public DetailsServiceImpl() {
    logger.trace("Injection using Autowired Details Repository in DetailsServiceImpl");
  }


  @Override
  public boolean registerDetails(Details details) {
    detailsRepository.save(details);
    return details.getId() != 0;
  }

  @Override
  public List<Details> getAllDetails() {
    return detailsRepository.findAll();
  }

  @Override
  public Details getDetailsById(int id) {
    return detailsRepository.findById(id);
  }

  
}
