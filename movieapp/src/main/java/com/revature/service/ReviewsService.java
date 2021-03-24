package com.revature.service;

import java.util.List;

import com.revature.model.Reviews;

public interface ReviewsService {

  public boolean registerReview(Reviews review);

  public List<Reviews> getAllReviews();
  
  public Reviews getReviewsById(int id);
}
