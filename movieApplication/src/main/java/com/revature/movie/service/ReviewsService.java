package com.revature.movie.service;

import java.util.List;

import com.revature.movie.model.Reviews;

public interface ReviewsService {

  public boolean registerReview(Reviews review);

  public List<Reviews> getAllReviews();
  
  public Reviews getReviewsById(int id);
}
