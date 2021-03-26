package com.revature.service;

import java.util.List;

import com.revature.model.Details;

public interface DetailsService {

  public boolean registerDetails(Details details);

  public List<Details> getAllDetails();

  public Details getDetailsById(int id);
  
}
