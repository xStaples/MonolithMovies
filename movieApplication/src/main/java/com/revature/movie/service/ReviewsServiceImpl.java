package com.revature.movie.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.movie.model.Reviews;
import com.revature.movie.repository.ReviewsRepository;

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
