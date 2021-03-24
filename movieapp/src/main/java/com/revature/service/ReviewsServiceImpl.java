package com.revature.service;

import java.util.List;

import com.revature.model.Reviews;
import com.revature.repository.ReviewsRepository;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("reviewsService")
public class ReviewsServiceImpl implements ReviewsService {

  private Logger logger = Logger.getLogger(ReviewsServiceImpl.class);

  @Autowired
  private ReviewsRepository reviewsRepository;

  public ReviewsServiceImpl() {
    logger.trace("Injection using Autowired Reviews Repository in ReviewsServiceImpl");
  }

  @Override
  public boolean registerReview(Reviews review) {
    reviewsRepository.save(review);
    return review.getId() != 0;
  }

  @Override
  public List<Reviews> getAllReviews() {
    return reviewsRepository.findAll();
  }

  @Override
  public Reviews getReviewsById(int id) {
    return reviewsRepository.findById();
  }
  
}
