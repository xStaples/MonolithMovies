package com.revature.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.movie.models.Cast;

@Repository
public interface CastRepository extends JpaRepository<Cast, Integer> {

}
