package com.revature.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.movie.models.Reviews;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, Integer> {

}
