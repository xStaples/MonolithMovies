package com.revature.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.movie.models.Details;

@Repository
public interface DetailsRepository extends JpaRepository<Details, Integer>{

}
